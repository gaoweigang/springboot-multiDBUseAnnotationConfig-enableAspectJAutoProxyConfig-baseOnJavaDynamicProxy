package com.gwg.shiro.web.controller;

import com.gwg.shiro.web.model.UserRole;
import com.gwg.shiro.web.service.UserService;
import com.gwg.shiro.web.service.impl.UserServiceImpl;
import com.gwg.shiro.web.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 查询user_system
     * @param userCode
     * @return
     */
    @PostMapping("/queryUserVoByUserCode")
    public @ResponseBody  UserVo queryUserVoByUserCode(String userCode){
        System.out.println(userService.getClass());
        UserVo userVo = userService.queryUserVoByUserCode(userCode);
        return userVo;
    }

    /**
     * 查询role_system
     * @param userCode
     * @return
     */
    @PostMapping("/queryUserRoleInfoByUserCode")
    public @ResponseBody  List<UserRole> queryUserRoleInfoByUserCode(String userCode){
        System.out.println(userService.getClass());
        List<UserRole> userRoleList = userService.queryUserRoleInfoByUserCode(userCode);
        return userRoleList;
    }







}
