package com.dynamodb.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dynamodb.bean.User;

public interface UserService {
    public JSONArray getUserMsg(User user);
    public boolean saveUserMsg(User user);
    public boolean updateUserMsg(User user);
    public boolean deleteUserMsg(User user);
}
