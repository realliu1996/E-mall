package com.briup.ssm.web.filter;

import com.briup.ssm.common.bean.Customer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;

        String url = request.getRequestURI() ;

        //获取Session
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");

        if(customer != null || url.indexOf("customerController/customerLogin")>=0 || url.indexOf("customerController/registerPage")>=0
        || url.indexOf("customerController/customerRegister")>=0 || url.contains("customerController/checkUserName/")
        || url.contains("css/") || url.contains("images/") || url.contains("js/")
        || url.indexOf("indexController/showIndexPage")>=0
        ){

            filterChain.doFilter(request,response);
            return;
        } else {


            //不符合条件的，跳转到登录界面
           // response.sendRedirect("customerController/loginPage");
            String msg = (String) session.getAttribute("msg");
            if (msg==null){
                msg="";
            }
            session.setAttribute("commonmsg",msg+" 请登录");

            request.getRequestDispatcher("/customerController/loginPage").forward(request, response);
            return;
        }

    }

    @Override
    public void destroy() {

    }
}



