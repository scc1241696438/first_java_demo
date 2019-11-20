package com.chixing.dao;

import com.chixing.pojo.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public Customer selectByCustNameAndPwd(String username, String userpwd) {
        Customer customer = null;
        //1. 连接数据库
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //2. 执行SQL
        String sql ="select cust_id,cust_name,cust_pwd  from customer where cust_name = ? and cust_pwd = ?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,userpwd);
            //3. 获得结果
            rs = pstmt.executeQuery();
            //4. 封装结果
            while(rs.next()){
                int customerId = rs.getInt(1);
                String customerName = rs.getString(2);
                String customerPwd = rs.getString(3);
                customer = new Customer(customerId,customerName,customerPwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally { //5. 关闭数据库的连接等
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DBConnection.closeConnection();

        }
        return customer;

    }
}
