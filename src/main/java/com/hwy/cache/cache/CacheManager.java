package com.hwy.cache.cache;

import com.google.common.cache.AbstractCache;
import com.hwy.cache.cache.UserCache;
import com.hwy.cache.common.Constants;
import com.hwy.cache.entity.vo.UserEntry;
import org.springframework.stereotype.Component;
import sun.misc.Cache;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author hwy
 * @program cache
 * @date 2019/7/11 19:26
 */

public final class CacheManager {

    private static final UserCache userCache = new UserCache();


    static{
        userCache.init(userCache);
    }

    public Collection<UserEntry> getAll() {
        return userCache.getAll();
    }

    public static UserEntry getUser(int id) {
        return userCache.get(String.format(Constants.USER_CACHE_NAME, id));
    }


}
