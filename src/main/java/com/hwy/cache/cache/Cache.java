package com.hwy.cache.cache;

import java.sql.Timestamp;
import java.util.Collection;

/**
 * @author hwy
 * @program cache
 * @date 2019/7/11 19:31
 */
public interface Cache<T, V extends Cache.Entry> {

    void init(AbstractCache abstractCache);

    V get(String key);

    V get(String key, boolean isListened);

    Collection<V> getAll();

    abstract class Entry {
        private Timestamp time;
        private boolean needUpdate = true;
        private String cacheKey;


        public Entry(Timestamp timestamp, String cacheKey){
            this.time = timestamp;
            this.cacheKey = cacheKey;
        }

        public boolean needUpdate(Entry entry){
            return needUpdate;
        }

        public Timestamp getTime() {
            return this.time;
        }

        public String getCacheKey() {
            return this.cacheKey;
        }

    }
}
