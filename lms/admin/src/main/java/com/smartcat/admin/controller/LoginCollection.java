package com.smartcat.admin.controller;

import com.smartcat.admin.DTO.LoginDTO;
import com.smartcat.admin.service.LoginService;
import com.smartcat.common.common.vo.ResponseResult;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class LoginCollection {


    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseResult<Object> login(@RequestBody(required = false)LoginDTO loginDTO) {
        try {
            loginService.login(loginDTO);
        }catch (Exception ex) {
            return ResponseResult.error(ex.getMessage());
        }
        return ResponseResult.ok("登录成功");
    }
}
