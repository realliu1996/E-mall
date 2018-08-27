package com.briup.ssm.web.controller;


import com.briup.ssm.common.bean.Book;
import com.briup.ssm.common.bean.Line;
import com.briup.ssm.common.bean.ShoppingCar;
import com.briup.ssm.common.exception.BookException;
import com.briup.ssm.service.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@RequestMapping("/bookController")
@Controller
public class BookController {

    @Autowired
    private IBookService bookService;


    @RequestMapping(value = "/bookDetailPage",method = RequestMethod.GET)
    public String bookDetailPage(){

        return "productDetail";
    }




    @RequestMapping(value = "/bookDetail/{bookid}",method = RequestMethod.GET)
    public String bookDetail(@PathVariable("bookid") Long bookid, HttpSession session){
        try {
            Book book = bookService.findById(bookid);
            session.setAttribute("book",book);
            return "redirect:/bookController/bookDetailPage";
        } catch (BookException e) {
            return "redirect:/indexController/showIndexPage";
        }

    }

    @RequestMapping(value = "/addOrderline/{bookid}",method = RequestMethod.GET)
    public String addOrderline(@PathVariable("bookid") Long bookid, HttpSession session){

        try {
            ShoppingCar shoppingCar = (ShoppingCar) session.getAttribute("shoppingCar");
            Line line=new Line();
            Book book = bookService.findById(bookid);
            line.setBook(book);
            shoppingCar.add(line);
            session.setAttribute("shoppingCar", shoppingCar);
            session.setAttribute("shoppingCarAll", shoppingCar.getLines());
            session.setAttribute("addmessage","加入购物车成功");
            return "redirect:/bookController/bookDetailPage";
        } catch (BookException e) {
            session.setAttribute("addmessage","加入购物车失败");
            return "redirect:/bookController/bookDetailPage";
        }

    }
}
