package com.hwy.cache.Service;

import com.hwy.cache.entity.TData;
import com.hwy.cache.repository.TDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author hwy
 * @program cache
 * @date 2019/7/11 13:03
 */
@Service
public class BasicDataServiceImpl implements BasicDataService{

    @Autowired
    private TDataMapper tDataMapper;

    @Override
    public int countAllData() {
        return tDataMapper.count();
    }

    @Override
    @Cacheable(cacheNames = {"TData"})
    public TData getDataById(int id) {
        return tDataMapper.selectByPrimaryKey(id);
    }

    @Override
    @CachePut(key = "result.dataId")
    public int saveData(TData tData) {
        int id = tDataMapper.insert(tData);
        return id;
    }

    @Override
    public int deleteData(int id) {
        return tDataMapper.deleteByPrimaryKey(id);
    }
}
