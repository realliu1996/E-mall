package com.briup.ssm.web.controller;

import com.briup.ssm.common.bean.Book;
import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.bean.Line;
import com.briup.ssm.common.bean.ShoppingCar;
import com.briup.ssm.common.exception.BookException;
import com.briup.ssm.common.exception.ShoppingCartException;
import com.briup.ssm.common.util.ResponseResult;
import com.briup.ssm.service.interfaces.IBookService;
import com.briup.ssm.service.interfaces.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RequestMapping("/shoppingCarController")
@Controller
public class ShoppingCarController {

    @Autowired
    private IBookService bookService;
    @Autowired
    private IShoppingCartService shoppingCartService;

    @RequestMapping(value = "/addOrderline/{bookid}",method = {RequestMethod.GET,RequestMethod.POST})
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
            return "redirect:/indexController/showIndexPage";

        } catch (BookException e) {
            session.setAttribute("addmessage","加入购物车失败");
            return "redirect:/indexController/showIndexPage";
        }

    }
    @RequestMapping(value = "/shoppingCartPage",method = RequestMethod.GET)
    public String shoppingCartPage(){
        return "shopcart";
    }

    @RequestMapping(value = "/removeProduct/{productid}",method = RequestMethod.GET)
    public String removeProduct(@PathVariable("productid") Long productid,HttpSession session){
        ShoppingCar shoppingCar = (ShoppingCar)session.getAttribute("shoppingCar");
        shoppingCar.delete(productid);
        session.setAttribute("shoppingCar", shoppingCar);
        session.setAttribute("shoppingCarAll", shoppingCar.getLines());
        session.setAttribute("delmessage","删除订单项成功");
        return "redirect:/shoppingCarController/shoppingCartPage";
    }

    @RequestMapping(value = "/updateProduct",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateProduct(Long productid,Integer num,HttpSession session){
        ShoppingCar shoppingCar = (ShoppingCar)session.getAttribute("shoppingCar");
        Map<Long, Line> map = shoppingCar.getLines();
        Line line = map.get(productid);
        line.setNum(num);
        session.setAttribute("delmessage","修改订单项成功");
        return "redirect:/shoppingCarController/shoppingCartPage";
    }

    @RequestMapping(value = "/removeAllProduct",method = RequestMethod.GET)
    public String removeAllProduct(HttpSession session){
        ShoppingCar shoppingCar = (ShoppingCar)session.getAttribute("shoppingCar");
        Customer customer = (Customer) session.getAttribute("customer");
        if ((shoppingCar.getLines()).size()==0){
            session.setAttribute("delmessage","购物车为空");
            return "redirect:/shoppingCarController/shoppingCartPage";
        }
        shoppingCar.clear();
        try {
            shoppingCartService.delShoppingCart(customer.getId());
            session.setAttribute("delmessage","删除所有订单项成功");
            return "redirect:/shoppingCarController/shoppingCartPage";
        } catch (ShoppingCartException e) {
            session.setAttribute("delmessage","删除所有订单项失败");
            return "redirect:/shoppingCarController/shoppingCartPage";
        }

    }

}
