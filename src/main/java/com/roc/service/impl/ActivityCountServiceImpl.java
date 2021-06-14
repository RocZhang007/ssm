package com.roc.service.impl;

import com.roc.dao.ActivityCountDao;
import com.roc.domain.Count;
import com.roc.service.ActivityCountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("activityCountService")
@Transactional
public class ActivityCountServiceImpl implements ActivityCountService {
    @Resource
    private ActivityCountDao activityCountDao;

    @Override
    public void updateNumber(Count count) {
        activityCountDao.updateNumber(count);
    }

    @Override
    public void saveNumber(Count count) {
        activityCountDao.saveNumber(count);
        int i = 1 / 0;
        activityCountDao.saveNumber(count);
    }
}
