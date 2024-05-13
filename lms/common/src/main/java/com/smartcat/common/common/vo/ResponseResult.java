package com.smartcat.common.common.vo;


import java.io.Serializable;

public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean success = true;
    private String message = "";
    private int statusCode = 0;
    private String errorCode = "";
    private T result;
    private long timestamp = System.currentTimeMillis();

    public ResponseResult() {
    }

    public static ResponseResult<Object> error(String msg) {
        return error(500, msg);
    }

    public static ResponseResult<Object> error(int statusCode, String msg) {
        ResponseResult<Object> result = new ResponseResult();
        result.setStatusCode(statusCode);
        result.setErrorCode("error");
        result.setMessage(msg);
        result.setSuccess(false);
        return result;
    }

    public static ResponseResult<Object> error(int statusCode, String errorCode, String msg) {
        ResponseResult<Object> result = new ResponseResult();
        result.setStatusCode(statusCode);
        result.setErrorCode(errorCode);
        result.setMessage(msg);
        result.setSuccess(false);
        return result;
    }


    public static ResponseResult<Object> ok(String msg) {
        ResponseResult<Object> result = new ResponseResult();
        result.setSuccess(true);
        result.setStatusCode(200);
        result.setErrorCode("success");
        result.setMessage(msg);
        return result;
    }

    public static ResponseResult<Object> ok(Object data) {
        ResponseResult<Object> result = new ResponseResult();
        result.setSuccess(true);
        result.setStatusCode(200);
        result.setErrorCode("success");
        result.setMessage("操作成功！");
        result.setResult(data);
        return result;
    }

    public static ResponseResult<Object> ok(String msg, Object data) {
        ResponseResult<Object> result = new ResponseResult();
        result.setSuccess(true);
        result.setStatusCode(200);
        result.setMessage(msg);
        result.setResult(data);
        return result;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public T getResult() {
        return this.result;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }


    protected boolean canEqual(Object other) {
        return other instanceof ResponseResult;
    }


    public String toString() {
        return "ResponseResult(success=" + this.isSuccess() + ", message=" + this.getMessage() + ", statusCode=" + this.getStatusCode() + ", errorCode=" + this.getErrorCode() + ", result=" + this.getResult() + ", timestamp=" + this.getTimestamp() + ")";
    }
}