package com.smartcat.admin.service;

import com.smartcat.admin.DTO.LoginDTO;
import io.netty.util.internal.StringUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class LoginService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void login(LoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        if (StringUtil.isNullOrEmpty(stringRedisTemplate.opsForValue().get(username))) {
            stringRedisTemplate.opsForValue().set(username, password);
            System.out.println("登录成功！");
        } else {
            System.out.println(stringRedisTemplate.opsForValue().get(username));
        }


    }
}
