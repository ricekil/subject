package com.zcl.subject.service.impl;

import com.zcl.subject.bean.WindowBean;
import com.zcl.subject.dao.TestDao;
import com.zcl.subject.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jlm on 2019-07-05 14:16
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestDao testDao;

    @Override
    public WindowBean getData(Integer id) {
        return testDao.getWindowById(id);
    }

}
