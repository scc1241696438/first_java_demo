package com.chixing.controller;

import com.chixing.dao.CustomerDao;
import com.chixing.dao.CustomerDaoImpl;
import com.chixing.pojo.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收页面的参数：用户名，密码
        String username =  request.getParameter("username");
        String userpwd =  request.getParameter("userpwd");
        System.out.println("用户名：" + username);
        System.out.println("密码：" + userpwd);
        //2. 访问dao，逻辑判断： 根据用户名与密码查询用户记录，若存在，则表示登录成功；
        //若不存在，则表示登录失败

        CustomerDao customerDao = new CustomerDaoImpl();
        Customer customer =  customerDao.selectByCustNameAndPwd(username,userpwd);
        //3. 登录失败的消息返回到页面中 ,转发forword login.jsp
        if(customer ==null){ //登录失败
            request.setAttribute("loginMsg","用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);   //相对路径
        }else{//4.登录成功 ,用户信息绑定到session;重定向到index.jsp
            HttpSession session = request.getSession();
            session.setAttribute("loginCustomer",customer);
            response.sendRedirect(request.getContextPath()+"/index.jsp"); //绝对路径
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
