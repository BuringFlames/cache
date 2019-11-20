//package com.hwy.cache.cache;
//
//import com.hwy.cache.service.UserService;
//import com.hwy.cache.utils.SpringUtil;
//import com.hwy.cache.common.Cache;
//import com.hwy.cache.entity.User;
//import com.hwy.cache.entity.vo.UserEntry;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.sql.Timestamp;
//import java.util.List;
//
///**
// * @author hwy
// * @program cache
// * @date 2019/7/11 20:09
// */
//@Component
//public class UserCache extends AbstractCache<User, UserEntry> {
//
//    private static Cache cacheName = Cache.USERCACHE;
//
//    public UserCache() {
//        super(cacheName.getCacheName());
//        this.userService = SpringUtil.getBean(UserService.class);
//    }
//
//
//    private static final String cacheKeyName = "user_%s";
//
//
//    @Autowired
//    private UserService userService;
//
//
//    @PostMapping
//    public void initCache(){
//        super.init(this);
//    }
//
//    @Override
//    public List<User> load() {
//        List<User> users = userService.getAllUsers();
//        return users;
//    }
//
//    @Override
//    public String getCacheKey(User user) {
//        return String.format(cacheKeyName, user.getId());
//    }
//
//    @Override
//    public UserEntry convertData(User user) {
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        UserEntry userEntry = new UserEntry(timestamp, getCacheKey(user), user);
//
//        return userEntry;
//    }
//
//    @Override
//    boolean needUpdate(UserEntry previous, UserEntry current) {
//        return current.equals(previous);
//    }
//}
