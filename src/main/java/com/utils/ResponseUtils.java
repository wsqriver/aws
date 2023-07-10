package com.utils;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ResponseUtils   {
    public static final Integer SuccessCode = 200;
    public static final Integer FailCode = 500;

    private Integer code;
    private String message;
    private Object data;

    @JsonIgnore
    public Boolean isSuccess() {
        return SuccessCode.equals(getCode());
    }

    public static ResponseUtils success(Object data) {
        ResponseUtils response = new ResponseUtils();
        response.setCode(SuccessCode);
        response.setMessage("success");
        response.setData(data);
        return response;
    }
    public static ResponseUtils success(Object data,String message) {
        ResponseUtils response = new ResponseUtils();
        response.setCode(SuccessCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    public static ResponseUtils fail(String message) {
        ResponseUtils response = new ResponseUtils();
        response.setCode(FailCode);
        response.setMessage(message);
        return response;
    }

    public static ResponseUtils fail(Integer code, String message) {
        ResponseUtils response = new ResponseUtils();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }
}
