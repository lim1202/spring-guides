package com.example.demo.common;

import java.io.Serializable;

import org.springframework.lang.Nullable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Common Response Entity")
public class ResultEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(value = "Code")
    private Integer code;

    @ApiModelProperty(value = "Message")
    private String message;

    @ApiModelProperty(value = "Data")
    private T data;

    public ResultEntity() {
        this(null);
    }

    public ResultEntity(@Nullable T data) {
		this(data, ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage());
    }
    
	public ResultEntity(@Nullable T data, @Nullable Integer code, @Nullable String message) {
        this.data = data;
        this.code = code;
		this.message = message;
    }
    
    public static ResultEntity<String> ok() {
        return new ResultEntity<>();
    }

    public static <T> ResultEntity<T> ok(T data) {
        return new ResultEntity<>(data);
    }

    public static <T> ResultEntity<T> error() {
        return new ResultEntity<>(null, ResultEnum.FAILED.getCode(), ResultEnum.FAILED.getMessage());
    }

    public static <T> ResultEntity<T> error(T data) {
        return new ResultEntity<>(data, ResultEnum.FAILED.getCode(), ResultEnum.FAILED.getMessage());
    }

}