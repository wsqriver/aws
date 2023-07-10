package com.dynamodb.dao.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.dynamodb.bean.User;
import com.dynamodb.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
@Slf4j
public class UserDaoImpl implements UserDao {
    @Autowired
    DynamoDBMapper dynamoDBMapper;

    private  final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public JSONArray getUserMsg(User user) {
        //PaginatedQueryList<User> scan = dynamoDBMapper.query(user);
        return JSONArray.parseArray(JSON.toJSONString(null));

    }

    @Override
    public boolean saveUserMsg(User user) {
        boolean flag=true;
        try {
            dynamoDBMapper.save(user);
        }
        catch (Exception e){
            logger.error("查询失败");
            flag=false;
        }
        return flag;
    }

    @Override
    public boolean updateUserMsg(User user) {
        return saveUserMsg(user);
    }
    @Override
    public boolean deleteUserMsg(User user) {
        boolean flag=true;
        try {
            dynamoDBMapper.delete(user);
        }
        catch (Exception e){
            logger.error("查询失败");
            flag=false;
        }
        return flag;
    }
}
