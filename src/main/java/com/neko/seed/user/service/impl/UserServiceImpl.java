package com.neko.seed.user.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neko.seed.auth.enums.TokenSubject;
import com.neko.seed.auth.service.TokenService;
import com.neko.seed.base.entity.Result;
import com.neko.seed.base.exception.ServiceException;
import com.neko.seed.user.data.SignInData;
import com.neko.seed.user.data.SignUpData;
import com.neko.seed.user.entity.User;
import com.neko.seed.user.exception.PasswordErrorException;
import com.neko.seed.user.exception.UserNotFoundException;
import com.neko.seed.user.mapper.UserMapper;
import com.neko.seed.user.service.UserService;
import com.neko.seed.user.view.SignInView;
import com.sun.org.apache.bcel.internal.generic.ATHROW;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;




}
