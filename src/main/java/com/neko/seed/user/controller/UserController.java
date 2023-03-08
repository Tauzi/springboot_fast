package com.neko.seed.user.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.neko.seed.auth.annotation.Auth;
import com.neko.seed.base.entity.Result;
import com.neko.seed.user.data.SignInData;
import com.neko.seed.user.data.SignUpData;
import com.neko.seed.user.entity.User;
import com.neko.seed.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登陆接口
     */
    @PostMapping("/signIn")
    public Result signIn(@RequestBody @Validated SignInData data) {
        User one = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getName, data.getName()));
        if(Objects.nonNull(one)){
            if(one.getName().equals(data.getName())&&one.getPassword().equals(data.getPassword())){
                StpUtil.login(one.getId());
                return new Result().success("登录成功");
            }
            return new Result().fail("登录失败",400);
        }

        return new Result().fail("登录失败",400);
    }

    /**
     * 注册接口
     */
    @PostMapping("/signUp")
    public Result signUp(@RequestBody @Validated SignUpData data) {
        // 使用SpringValidation校验数据
        User one = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getName, data.getName()));
        if (Objects.isNull(one)) {
            User user=new User();
            BeanUtils.copyProperties(data,user);
            userService.save(user);
            return new Result().success();
        }

        return new Result().fail("注册失败");
    }


    /**
     * 根据Id查看单个用户的信息
     */
    @GetMapping("/get")
    public Result get() {
        System.out.println("--------------------"+StpUtil.getLoginId());

        return new Result().success(userService.getById((Serializable) StpUtil.getLoginId())
        );
    }

    /**
     * 查看用户列表
     */
    @GetMapping("/list")
    public Result list(@Auth Long userId) {
        // 该接口需要检测用户是否登陆
        return new Result().success(userService.list());
    }
}