package com.dynamodb.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dynamodb.bean.User;
import com.dynamodb.dao.UserDao;
import com.dynamodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public JSONArray getUserMsg(User user) {
        return userDao.getUserMsg(user);
    }

    @Override
    public boolean saveUserMsg(User user) {
         return userDao.saveUserMsg(user);
    }

    @Override
    public boolean updateUserMsg(User user) {
        return userDao.updateUserMsg(user);
    }

    @Override
    public boolean deleteUserMsg(User user) {
        return userDao.deleteUserMsg(user);
    }
}
