package com.hwy.cache.cache;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.hwy.cache.Service.UserService;
import com.hwy.cache.Service.UserServiceImpl;
import com.hwy.cache.Utils.SpringUtil;
import com.hwy.cache.common.Cache;
import com.hwy.cache.entity.User;
import com.hwy.cache.entity.vo.UserEntry;
import com.hwy.cache.repository.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hwy
 * @program cache
 * @date 2019/7/11 20:09
 */
@Component
public class UserCache extends AbstractCache<User, UserEntry> {

    private static Cache cacheName = Cache.USERCACHE;

    public UserCache() {
//        SpringApplication application = new SpringApplication(ApplicationServer.class);
//        ConfigurableApplicationContext context = application.run(args);
//        this.userService = context.getBean(UserService.class);
        super(cacheName.getCacheName());
        this.userService = SpringUtil.getBean(UserService.class);
    }

    private static ConfigurableApplicationContext applicationContext;
    //定义一个获取已经实例化bean的方法
    public static <T> T getBean(Class<T> c){
        return applicationContext.getBean(c);
    }

    private static final String cacheKeyName = "user_%s";


    @Autowired
    private UserService userService;


    @PostMapping
    public void initCache(){
        super.init(this);
    }

    @Override
    public List<User> load() {
        List<User> users = userService.getAllUsers();
        return users;
    }

    @Override
    public String getCacheKey(User user) {
        return String.format(cacheKeyName, user.getId());
    }

    @Override
    public UserEntry convertData(User user) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        UserEntry userEntry = new UserEntry(timestamp, getCacheKey(user), user);

        return userEntry;
    }

    @Override
    boolean needUpdate(UserEntry previous, UserEntry current) {
        return current.equals(previous);
    }
}
