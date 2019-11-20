package com.chixing.dao;

import com.chixing.pojo.Hero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HeroDaoImpl implements HeroDao {
    @Override
    public boolean insert(Hero hero) {
        return false;
    }

    @Override
    public boolean update(Hero hero) {
        return false;
    }

    @Override
    public boolean delete(Hero hero) {
        return false;
    }

    @Override
    public List<Hero> selectAll() {
        List<Hero> heroList = new ArrayList<>();

        //1. 加载驱动类，连接数据库
        Connection connection = DBConnection.getConnection();
        String sql ="select id,uk_name,nickname,tiny_img,magic_power,physic_power,defence_power,hand_hard,roles from hero";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            //2. 执行SQL语句
            pstmt = connection.prepareStatement(sql);

            //3. 获得执行结果
            rs = pstmt.executeQuery();

            while(rs.next()){
               int id =  rs.getInt(1);
               String ukName = rs.getString(2);
               String nickName = rs.getString(3);
               String tinyImg = rs.getString(4);
               int magicPower = rs.getInt(5);
               int physicPower = rs.getInt(6);
               int defencePower = rs.getInt(7);
               int handHard = rs.getInt(8);
               String roles = rs.getString(9);

               // 4. 封装成POJO对象
                Hero hero =  new Hero(id,ukName,nickName,tinyImg,magicPower,physicPower,defencePower,handHard,roles);
                heroList.add(hero);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {  // finally 作用： 释放资源，节省内存（Connection，PreparedStatement，ResultSet 是重量级对象，用完之后，及时释放）
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(pstmt !=null ) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DBConnection.closeConnection();
        }
        return heroList;
    }

    @Override
    public List<Hero> selectByPrimaryKey(int id) {
        return null;
    }
}
