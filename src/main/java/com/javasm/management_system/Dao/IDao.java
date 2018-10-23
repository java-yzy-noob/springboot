package com.javasm.management_system.Dao;

import com.javasm.management_system.Entity.TestData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Mapper
public interface IDao {

    List<TestData> getTr_data(@Param("start")int start, @Param("limit")int limit, @Param("theKey")String theKey,
                              @Param("date_start")String date_start, @Param("date_end")String date_end);
    List<TestData> getAllTr_data(@Param("theKey")String theKey, @Param("date_start")String date_start, @Param("date_end")String date_end);
}
