package cn.cjd.springboot.modal.redis.new_use;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Repository
public class DefaultRedisService implements RedisServiceInterface {
    private final RedisTemplate<String, String> redisTemplate;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public DefaultRedisService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public boolean expireValue(String key, String v, long time) {
        try {
            ValueOperations<String, String> valueOps = this.redisTemplate.opsForValue();
            valueOps.set(key, v);
            if (time > 0L) {
                this.redisTemplate.expire(key, time, TimeUnit.SECONDS);
                return true;
            }
        } catch (Throwable var6) {
            this.logger.error("缓存[" + key + "]失败, value[" + v + "]", var6);
        }

        return false;
    }

    public boolean exclusiveSetWithExpire(String key, Object value) {
        return this.exclusiveSetWithExpire(key, value, 10, 9);
    }

    public boolean exclusiveSetWithExpire(String key, Object value, int retryCount, int expiredSeconds) {
        if (retryCount <= 0) {
            retryCount = 10;
        }

        int count = 0;
        boolean result = false;

        try {
            ValueOperations valueOps;
            for(valueOps = this.redisTemplate.opsForValue(); count <= retryCount; ++count) {
                result = valueOps.setIfAbsent(key, value.toString());
                if (result) {
                    break;
                }

                Thread.sleep(5L);
            }

            if (result) {
                valueOps.getOperations().expire(key, (long)expiredSeconds, TimeUnit.SECONDS);
            }
        } catch (Exception var8) {
            this.logger.error("redis exception :", var8);
        }

        return result;
    }

    public boolean cacheValue(String key, String v) {
        return this.expireValue(key, v, -1L);
    }

    public boolean containsKey(String key) {
        try {
            return this.redisTemplate.hasKey(key);
        } catch (Throwable var3) {
            this.logger.error("判断缓存存在失败key[" + key + ", Codeor[" + var3 + "]");
            return false;
        }
    }

    public String getValue(String key) {
        try {
            ValueOperations<String, String> valueOps = this.redisTemplate.opsForValue();
            return (String)valueOps.get(key);
        } catch (Throwable var3) {
            this.logger.error("获取缓存失败key[" + key + ", Codeor[" + var3 + "]");
            return null;
        }
    }

    public boolean removeValue(String key) {
        return this.remove(key);
    }

    public boolean removeSet(String key) {
        return this.remove(key);
    }

    public boolean removeList(String key) {
        return this.remove(key);
    }

    public boolean expireSet(String key, String v, long time) {
        try {
            SetOperations<String, String> valueOps = this.redisTemplate.opsForSet();
            valueOps.add(key, new String[]{v});
            if (time > 0L) {
                this.redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }

            return true;
        } catch (Throwable var6) {
            this.logger.error("缓存[" + key + "]失败, value[" + v + "]", var6);
            return false;
        }
    }

    public boolean cacheSet(String key, String v) {
        return this.expireSet(key, v, -1L);
    }

    public boolean expireSet(String key, Set<String> v, long time) {
        try {
            SetOperations<String, String> setOps = this.redisTemplate.opsForSet();
            setOps.add(key, v.toArray(new String[v.size()]));
            if (time > 0L) {
                this.redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }

            return true;
        } catch (Throwable var6) {
            this.logger.error("缓存[" + key + "]失败, value[" + v + "]", var6);
            return false;
        }
    }

    public boolean cacheSet(String key, Set<String> v) {
        return this.expireSet(key, v, -1L);
    }

    public Set<String> getSet(String key) {
        try {
            SetOperations<String, String> setOps = this.redisTemplate.opsForSet();
            return setOps.members(key);
        } catch (Throwable var3) {
            this.logger.error("获取set缓存失败key[" + key + ", Codeor[" + var3 + "]");
            return null;
        }
    }

    public boolean expireList(String key, String v, long time) {
        try {
            ListOperations<String, String> listOps = this.redisTemplate.opsForList();
            listOps.rightPush(key, v);
            if (time > 0L) {
                this.redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }

            return true;
        } catch (Throwable var6) {
            this.logger.error("缓存[" + key + "]失败, value[" + v + "]", var6);
            return false;
        }
    }

    public boolean cacheList(String key, String v) {
        return this.expireList(key, v, -1L);
    }

    public boolean expireList(String key, List<String> v, long time) {
        try {
            ListOperations<String, String> listOps = this.redisTemplate.opsForList();
            listOps.rightPushAll(key, v);
            if (time > 0L) {
                this.redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }

            return true;
        } catch (Throwable var6) {
            this.logger.error("缓存[" + key + "]失败, value[" + v + "]", var6);
            return false;
        }
    }

    public boolean cacheList(String key, List<String> v) {
        return this.expireList(key, v, -1L);
    }

    public List<String> getList(String key, long start, long end) {
        try {
            ListOperations<String, String> listOps = this.redisTemplate.opsForList();
            return listOps.range(key, start, end);
        } catch (Throwable var7) {
            this.logger.error("获取list缓存失败key[" + key + ", Codeor[" + var7 + "]");
            return null;
        }
    }

    public long getListSize(String key) {
        try {
            ListOperations<String, String> listOps = this.redisTemplate.opsForList();
            return listOps.size(key);
        } catch (Throwable var3) {
            this.logger.error("获取list长度失败key[" + key + "], Codeor[" + var3 + "]");
            return 0L;
        }
    }

    public long getListSize(ListOperations<String, String> listOps, String key) {
        try {
            return listOps.size(key);
        } catch (Throwable var4) {
            this.logger.error("获取list长度失败key[" + key + "], Codeor[" + var4 + "]");
            return 0L;
        }
    }

    public boolean removeOneOfList(String key) {
        try {
            ListOperations<String, String> listOps = this.redisTemplate.opsForList();
            listOps.rightPop(key);
            return true;
        } catch (Throwable var3) {
            this.logger.error("移除list缓存失败key[" + key + ", Codeor[" + var3 + "]");
            return false;
        }
    }

    private boolean remove(String key) {
        try {
            this.redisTemplate.delete(key);
            return true;
        } catch (Throwable var3) {
            this.logger.error("获取缓存失败key[" + key + ", Codeor[" + var3 + "]");
            return false;
        }
    }
}