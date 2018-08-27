package com.briup.ssm.web.controller;


import com.briup.ssm.common.bean.Book;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.briup.ssm.service.interfaces.IBookService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@RequestMapping("/indexController")
@Controller
public class IndexController {

    @Autowired
    private IBookService bookService;


    @RequestMapping("/showIndexPage")
    public String showIndexPage(HttpSession session, @RequestParam(value="page",required=false,defaultValue="1") int page) {
        try {
            PageInfo<Book> pageInfo = bookService.finaAllBookWithPage(page, 3);
            session.setAttribute("pageInfo", pageInfo);
            return "index";
        } catch (EstoreCommonException e) {
            e.printStackTrace();
            session.setAttribute("msg", "查询失败:" + e.getMessage());
            return "index";
        }
    }

}
