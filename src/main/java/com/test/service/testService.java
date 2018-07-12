package com.test.service;

import com.test.model.testModel;

public interface testService {

    public testModel getNameById(String id);

    public void deleteById(String s);

    public testModel insert(testModel test);


}
