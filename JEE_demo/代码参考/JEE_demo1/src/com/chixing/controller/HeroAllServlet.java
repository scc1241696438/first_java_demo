package com.chixing.controller;

import com.chixing.dao.HeroDao;
import com.chixing.dao.HeroDaoImpl;
import com.chixing.pojo.Hero;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HeroAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HeroDao dao = new HeroDaoImpl();
        List<Hero> heroList = dao.selectAll();
        if(heroList.size()==0){
            request.setAttribute("msg","暂无数据");
        }else{
            request.setAttribute("heroList",heroList);
        }

        //页面分发（重定向 sendRedirect, forward）
        request.getRequestDispatcher("/...").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
