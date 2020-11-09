package com.example.demo.common;

import java.io.Serializable;

import org.springframework.lang.Nullable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ResponseEntity", description = "通用返回对象")
public class ResultEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "是否正常")
    private Boolean success;
    
    @ApiModelProperty(value = "代码")
    private String code;

    @ApiModelProperty(value = "消息")
    private String message;

    @ApiModelProperty(value = "数据")
    private T data;

    public ResultEntity() {
        this(null);
    }

    public ResultEntity(@Nullable T data) {
		this(data, ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), true);
    }
    
	public ResultEntity(@Nullable T data, @Nullable String code, @Nullable String message, @Nullable Boolean success) {
        this.data = data;
        this.code = code;
        this.message = message;
        this.success = success;
    }
    
    public static ResultEntity<String> ok() {
        return new ResultEntity<>();
    }

    public static <T> ResultEntity<T> ok(T data) {
        return new ResultEntity<>(data);
    }

    public static <T> ResultEntity<T> error() {
        return new ResultEntity<>(null, ResultEnum.FAILED.getCode(), ResultEnum.FAILED.getMessage(), false);
    }

    public static <T> ResultEntity<T> error(T data) {
        return new ResultEntity<>(data, ResultEnum.FAILED.getCode(), ResultEnum.FAILED.getMessage(), false);
    }

    public static <T> ResultEntity<T> error(T data, ResultEnum result) {
        return new ResultEntity<>(data, result.getCode(), result.getMessage(), false);
    }

}