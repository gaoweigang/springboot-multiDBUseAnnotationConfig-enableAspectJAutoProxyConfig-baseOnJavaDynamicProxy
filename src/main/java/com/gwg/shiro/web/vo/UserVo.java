package com.gwg.shiro.web.vo;

import com.gwg.shiro.web.model.Role;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class UserVo implements Serializable{

    /**
     * 用户id
     */
    private String userCode;

    /**
     * 员工姓名
     */
    private String username;

    //角色集合
    private List<Role> roleList;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
