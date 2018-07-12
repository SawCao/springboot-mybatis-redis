package com.test.dao;

import com.test.model.testModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface testDao {

    public testModel getNameById(String id);

    public void deleteById(String s);

    public void insert(testModel test);

}
