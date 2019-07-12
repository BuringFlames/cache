package com.hwy.cache.entity.vo;

import com.hwy.cache.cache.Cache;
import com.hwy.cache.entity.User;

import java.sql.Timestamp;

/**
 * @author hwy
 * @program cache
 * @date 2019/7/11 19:47
 */
public class UserEntry extends Cache.Entry{

    private int id;
    private String userName;
    private String passWard;

    public UserEntry(Timestamp timestamp, String cacheKey, User user) {
        super(timestamp, cacheKey);
        this.id = user.getId();
        this.userName = user.getUsername();
        this.passWard = user.getPassword();
    }


    @Override
    public int hashCode(){

        return this.id;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object)
            return true;
        if(object instanceof UserEntry) {
            UserEntry entry = (UserEntry) object;
            Timestamp time = new Timestamp(System.currentTimeMillis() - 5000);
            return entry.id == this.id
                    && entry.userName.equals(this.userName)
                    && entry.passWard.equals(this.passWard)
                    && entry.getTime().before(time);
        }

        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassWard() {
        return passWard;
    }

    public void setPassWard(String passWard) {
        this.passWard = passWard;
    }
}
