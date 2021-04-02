package com.example.begine.model.dto;

/**
 * Dto 通常是用來傳遞資料用的物件
 * 這個 RespDto 就是拿來做response 用的物件
 */
public class RespDto<T> {

    private String message;
    private String result;
    private T data;

    public String getMessage() {
        return message;
    }

    public RespDto<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getResult() {
        return result;
    }

    public RespDto<T> setResult(String result) {
        this.result = result;
        return this;
    }

    public T getData() {
        return data;
    }

    public RespDto<T> setData(T data) {
        this.data = data;
        return this;
    }
}
