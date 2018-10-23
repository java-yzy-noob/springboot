package com.javasm.management_system.Service;

import com.javasm.management_system.Entity.TestData;

import java.util.List;

public interface IService {
    List<TestData> getTr_data(int start, int limit, String theKey, String date_start, String date_end);
    List<TestData> getAllTr_data( String theKey, String date_start, String date_end);
    List searchList(String key);
    String addContent();
}
