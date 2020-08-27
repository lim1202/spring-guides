package com.example.demo.controller;

import com.example.demo.common.ResultEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api")
public class HelloController {

    @ApiOperation(value = "Hello", httpMethod = "GET")
    @GetMapping("/hello/{name}")
    public ResultEntity<String> hello(@PathVariable String name) {
        return ResultEntity.ok("Hello " + name);
    }

}