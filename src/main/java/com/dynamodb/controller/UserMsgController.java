package com.dynamodb.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dynamodb.bean.User;
import com.dynamodb.service.UserService;
import com.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserMsgController {

    @Autowired
    UserService userService;
    @GetMapping
    public ResponseUtils getUser(@RequestBody User user){
        JSONArray userMsg = userService.getUserMsg(user);
        return ResponseUtils.success(userMsg);
    }
    @PostMapping
    public ResponseUtils saveUser(@RequestBody User user){
        boolean flag = userService.saveUserMsg(user);
        if(flag){

            return ResponseUtils.success(null);
        }
        return  ResponseUtils.fail(null);
    }
    @PutMapping
    public ResponseUtils updateUser(@RequestBody User user){
        boolean flag = userService.updateUserMsg(user);
        if(flag){

            return ResponseUtils.success(null);
        }
        return  ResponseUtils.fail(null);
    }
    @DeleteMapping
    public ResponseUtils deleteUser(@RequestBody User user){
        boolean flag = userService.deleteUserMsg(user);
        if(flag){

            return ResponseUtils.success(null);
        }
        return  ResponseUtils.fail(null);
    }

}
