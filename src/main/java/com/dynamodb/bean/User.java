package com.dynamodb.bean;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName ="user")
public class User {
    private String userId;
    private String userName;
    private String userData;

    @DynamoDBHashKey(attributeName="userId")
    @DynamoDBAutoGeneratedKey
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    @DynamoDBAttribute(attributeName = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @DynamoDBAttribute(attributeName = "userData")
    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }
}
