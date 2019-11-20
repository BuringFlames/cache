//package com.hwy.cache.cache;
//
//import com.hwy.cache.common.Constants;
//import com.hwy.cache.entity.vo.UserEntry;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//
///**
// * @author hwy
// * @program cache
// * @date 2019/7/11 19:26
// */
//
//@Component
//public final class CacheManager {
//
//    private static final UserCache userCache = new UserCache();
//
//    static{
//        init(userCache);
//    }
//
//    public Collection<UserEntry> getAll() {
//        return userCache.getAll();
//    }
//
//    public UserEntry getUser(int id) {
//        return userCache.get(String.format(Constants.USER_CACHE_NAME, id));
//    }
//
//    private static void init(AbstractCache cache) {
//        cache.init(cache);
//    }
//}
