package com.example.demo.pojo;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.OrderItem;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "BaseQuery对象")
public abstract class BaseQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "排序列表")
    private List<OrderItem> orders;

}
