package com.example.demo.common;

import java.io.Serializable;

import org.springframework.lang.Nullable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ResponseEntity", description = "通用返回值对象")
public class ResultEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "是否成功")
    private Boolean success;
    
    @ApiModelProperty(value = "代码")
    private String code;

    @ApiModelProperty(value = "消息")
    private String message;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "数据")
    private T data;

    public ResultEntity() {
        this(null);
    }

    public ResultEntity(@Nullable T data) {
		this(data, ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), "", true);
    }
    
	public ResultEntity(@Nullable T data, @Nullable String code, @Nullable String message, @Nullable String description, @Nullable Boolean success) {
        this.data = data;
        this.code = code;
        this.message = message;
        this.description = description;
        this.success = success;
    }

    public boolean isSuccess() {
        return Boolean.TRUE.equals(this.success);
    }

    public static ResultEntity<String> ok() {
        return new ResultEntity<>();
    }

    public static <T> ResultEntity<T> ok(T data) {
        return new ResultEntity<>(data);
    }

    public static <T> ResultEntity<T> error() {
        return new ResultEntity<>(null, ResultEnum.FAILED.getCode(), ResultEnum.FAILED.getMessage(), null, false);
    }

    public static <T> ResultEntity<T> error(String description) {
        return new ResultEntity<>(null, ResultEnum.FAILED.getCode(), ResultEnum.FAILED.getMessage(), description, false);
    }

    public static <T> ResultEntity<T> error(ResultEnum result) {
        return new ResultEntity<>(null, result.getCode(), result.getMessage(), "", false);
    }

    public static <T> ResultEntity<T> error(ResultEnum result, String description) {
        return new ResultEntity<>(null, result.getCode(), result.getMessage(), description, false);
    }

    public static <T> ResultEntity<T> error(String code, String message) {
        return new ResultEntity<>(null, code, message, "", false);
    }

    public static <T> ResultEntity<T> error(String code, String message, String description) {
        return new ResultEntity<>(null, code, message, description, false);
    }

    public static ResultEntity<String> ret(boolean success) {
        return success ? ok() : error();
    }

}