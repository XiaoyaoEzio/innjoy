package me.innjoy.pms.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultDto implements Serializable {
    /**
     * 0：成功
     * 1：失败
     */
    private int code;
    private String message;
    private Object data;

    public ResultDto() {
    }

    public ResultDto(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResultDto success() {
        return new ResultDto(0, null, null);
    }

    public static ResultDto success(String message) {
        return new ResultDto(0, message, null);
    }

    public static ResultDto success(Object data) {
        return new ResultDto(0, null, data);
    }

    public static ResultDto success(String message, Object data) {
        return new ResultDto(0, message, data);
    }

    public static ResultDto failure() {
        return new ResultDto(1, null, null);
    }

    public static ResultDto failure(String message) {
        return new ResultDto(1, message, null);
    }

    public static ResultDto failure(Object data) {
        return new ResultDto(1, null, data);
    }

    public static ResultDto failure(String message, Object data) {
        return new ResultDto(1, message, data);
    }

    @Override
    public String toString() {
        return "ResultDto{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
