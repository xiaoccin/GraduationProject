package org.xiaocc.userservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import org.xiaocc.commonmodule.entity.User;
import org.xiaocc.userservice.mapper.UserMapper;
import org.xiaocc.userservice.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
