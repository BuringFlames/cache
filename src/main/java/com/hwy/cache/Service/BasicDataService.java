package com.hwy.cache.Service;

import com.hwy.cache.entity.TData;

/**
 * @author hwy
 * @program cache
 * @date 2019/7/11 13:03
 */
public interface BasicDataService {

    int countAllData();

    TData getDataById(int id);

    int saveData(TData tData);

    int deleteData(int id);
}
