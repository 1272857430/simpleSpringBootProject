package cn.cjd.springboot.modal.redis.new_use;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class RedisLock {

    @Autowired
    private RedisServiceInterface redisService;

    public RedisLock() {
    }

    public boolean tryLock(EnumRedisLockType lockType, String id) {
        try {
            String key = lockType.name() + "_" + id;
            boolean result = this.redisService.exclusiveSetWithExpire(key, 1);

            int count;
            for(count = 1; !result; result = this.redisService.exclusiveSetWithExpire(key, 1)) {
                ++count;
                if (count >= 20) {
                    log.error(Thread.currentThread().getName() + ", 命令" + key + "获取锁失败，放弃");
                    break;
                }

                log.error(Thread.currentThread().getName() + ", 命令" + key + "队列执行尝试超过指定次数，启用新一轮重试");
                Thread.sleep(300L);
            }

            if (count < 20) {
                log.info(Thread.currentThread().getName() + ", 获取锁：" + key);
                return true;
            }
        } catch (Exception var6) {
            log.error("Fatal error in tryLock: ", var6);
        }

        return false;
    }

    public void releaseLock(EnumRedisLockType lockType, String id) {
        String key = lockType.name() + "_" + id;
        log.info(Thread.currentThread().getName() + ", 释放锁：" + key);
        this.redisService.removeValue(key);
    }
}
