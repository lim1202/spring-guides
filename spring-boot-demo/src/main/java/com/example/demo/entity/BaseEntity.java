package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="BaseEntity对象")
public  abstract class BaseEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(value = "ID")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(shape = Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @JsonProperty(value = "create_time")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(shape = Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @JsonProperty(value = "update_time")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @Version
    private Integer version;

    @TableLogic
    private Integer deleted;
}
