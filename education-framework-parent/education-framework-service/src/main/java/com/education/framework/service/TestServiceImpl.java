package com.education.framework.service;

import com.education.framework.model.Test;
import com.education.framework.repo.TestRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/3/30.
 */
@Transactional
@Service
public class TestServiceImpl implements  TestService{

    @Resource
    private TestRepo testRepo;

    @Override
    public Test getById(int id) {
        Test test = testRepo.getById(1);
        System.out.println(test);
        return test;
    }
}
