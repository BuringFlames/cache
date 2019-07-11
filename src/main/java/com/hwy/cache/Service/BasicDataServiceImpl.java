package com.hwy.cache.Service;

import com.hwy.cache.entity.TDataExample;
import com.hwy.cache.repository.TDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
}
