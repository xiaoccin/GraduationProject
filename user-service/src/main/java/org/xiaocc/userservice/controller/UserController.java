package org.xiaocc.userservice.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.xiaocc.commonmodule.entity.User;
import org.xiaocc.commonmodule.entity.util.JwtUtil;
import org.xiaocc.commonmodule.entity.util.ToolUtil;
import org.xiaocc.userservice.feignClient.PointServiceFeignClient;
import org.xiaocc.userservice.service.UserService;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private PointServiceFeignClient pointServiceFeignClient;
    @Autowired
    private UserService userService;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;


    @GetMapping(value = "/test")
    public String test(){
        return "this is user-service!!";
    }

    @GetMapping(value = "/addPoint")
    public String addPoint(){
        User user = new User();
        user.setAccount("123456789");
        return null;
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody User user){
        //todo 验证登录 - JWT生成token - token存入redis 返回token

        if (ToolUtil.isNotEmpty(user.getAccount())){
            User sourceUser = userService.getById(user.getAccount());
            if (sourceUser != null){
                if (sourceUser.getPassword().equals(user.getPassword())){
                    String token = JwtUtil.getToken(user.getAccount());
                    redisTemplate.opsForValue().set(token,token,JwtUtil.TOKEN_TIME_OUT, TimeUnit.SECONDS);
                    return token;
                }else {
                    return "password error";
                }
            }else {
                return "account error";
            }
        }else {
            return "account null";
        }
    }
}
