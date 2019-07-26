package com.gwg.shiro.web.service;

import com.gwg.shiro.web.config.jdbc.DataSource;
import com.gwg.shiro.web.config.jdbc.DataSourceNames;
import com.gwg.shiro.web.model.User;
import com.gwg.shiro.web.model.UserRole;
import com.gwg.shiro.web.vo.UserVo;

import java.util.List;

/**
 * Created by
 */
public interface UserService{

    /**
     * 获取用户角色信息
     */
    public UserVo queryUserVoByUserCode(String userCode);


    /**
     * 如果是使用JDK动态代理的话，则需要把注解加到这里。因为jdk动态代理会使用该接口实现代理对象，代理对象会调用被代理对象的方法
     */
    @DataSource(name = DataSourceNames.ROLE)
    public List<UserRole> queryUserRoleInfoByUserCode(String userCode);


}
