package com.chixing.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 该类封装了获得数据库连接对象与关闭连接
 *
 */
public class DBConnection {

    private static Connection connection = null;

    /**
     * 获得连接对象
     * @return
     */
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lol","root","root");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }


    public static void closeConnection(){
        if(connection !=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
