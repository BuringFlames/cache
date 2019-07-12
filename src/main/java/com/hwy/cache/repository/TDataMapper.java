package com.hwy.cache.repository;

import com.hwy.cache.entity.TData;
import com.hwy.cache.entity.TDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TDataMapper {
    long countByExample(TDataExample example);

    int deleteByExample(TDataExample example);

    int deleteByPrimaryKey(Integer dataId);

    int insert(TData record);

    int insertSelective(TData record);

    List<TData> selectByExampleWithBLOBs(TDataExample example);

    List<TData> selectByExample(TDataExample example);

    TData selectByPrimaryKey(Integer dataId);

    int updateByExampleSelective(@Param("record") TData record, @Param("example") TDataExample example);

    int updateByExampleWithBLOBs(@Param("record") TData record, @Param("example") TDataExample example);

    int updateByExample(@Param("record") TData record, @Param("example") TDataExample example);

    int updateByPrimaryKeySelective(TData record);

    int updateByPrimaryKeyWithBLOBs(TData record);

    int updateByPrimaryKey(TData record);

    int count();
}