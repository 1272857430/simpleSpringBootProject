package cn.cjd.springboot.modal.redis.new_use;

import org.springframework.data.redis.core.ListOperations;

import java.util.List;
import java.util.Set;

public interface RedisServiceInterface {
    boolean containsKey(String var1);

    boolean expireValue(String var1, String var2, long var3);

    boolean expireSet(String var1, String var2, long var3);

    boolean expireSet(String var1, Set<String> var2, long var3);

    boolean expireList(String var1, String var2, long var3);

    boolean expireList(String var1, List<String> var2, long var3);

    boolean cacheValue(String var1, String var2);

    boolean cacheSet(String var1, String var2);

    boolean cacheSet(String var1, Set<String> var2);

    boolean cacheList(String var1, String var2);

    boolean cacheList(String var1, List<String> var2);

    String getValue(String var1);

    Set<String> getSet(String var1);

    List<String> getList(String var1, long var2, long var4);

    boolean removeValue(String var1);

    boolean removeSet(String var1);

    boolean removeList(String var1);

    long getListSize(String var1);

    long getListSize(ListOperations<String, String> var1, String var2);

    boolean removeOneOfList(String var1);

    boolean exclusiveSetWithExpire(String var1, Object var2, int var3, int var4);

    boolean exclusiveSetWithExpire(String var1, Object var2);
}
