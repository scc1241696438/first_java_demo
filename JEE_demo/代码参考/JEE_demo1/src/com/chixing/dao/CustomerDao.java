package com.chixing.dao;

import com.chixing.pojo.Customer;

public interface CustomerDao {
    /**
     根据用户名与密码查询用户
     @param username 用户名
     @param userpwd 用户密码
     @return 返回查询到的对应的用户对象
     */
    public Customer selectByCustNameAndPwd(String username, String userpwd);
}
