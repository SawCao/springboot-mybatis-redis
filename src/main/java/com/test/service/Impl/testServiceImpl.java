package com.test.service.Impl;


import com.test.dao.testDao;
import com.test.model.testModel;
import com.test.service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames="userCache") // 本类内方法指定使用缓存时，默认的名称就是userCache

public class testServiceImpl implements testService {

    @Autowired
    private testDao _testDao;

    @Override
    @Cacheable(key = "#p0")
    public testModel getNameById(String id){
        System.err.println("根据id=" + id +"获取用户对象，从数据库中获取");
        return _testDao.getNameById(id);
    }

    @Override
    @CacheEvict(key = "#p0")
    public void deleteById(String s){
        System.err.println("需要删除的是" + s);
        _testDao.deleteById(s);
    }

    @Override
    @CachePut(key="#p0.id")
    public testModel insert(testModel test){
        System.err.println("即将插入：" + test);
        _testDao.insert(test);
        return test;
    }
}
