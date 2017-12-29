package com.education.framework.model.user;

import java.util.List;

import javax.annotation.Resource;

public class LoginUser {

    private Integer userId;
    /** 用户名 */
    private String userName;
    /** 密码 */
    private String passWord;
    /** 用户真实姓名 */
    private String realName;
    /** staff */
    private Integer isstaff;
    /** token */
    private String token;
    /** 用户角色 */
    private List<String> roleList;
    /** 用户权限 */
    private List<Resource> resourceList;

    public LoginUser() {
    }

    public LoginUser(User user, List<String> roleList) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.realName = user.getRealName();
        this.isstaff = user.getIsstaff();
        this.token = user.getToken();
        this.roleList = roleList;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getIsstaff() {
        return isstaff;
    }

    public void setIsstaff(Integer isstaff) {
        this.isstaff = isstaff;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

    @Override
    public String toString() {
        return "LoginUser [userId=" + userId + ", userName=" + userName + ", realName=" + realName + ", isstaff="
                + isstaff + ", token=" + token + ", roleList=" + roleList + ", resourceList=" + resourceList + "]";
    }

}
