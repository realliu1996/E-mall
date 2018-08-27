package com.briup.ssm.web.controller;

import com.briup.ssm.common.bean.*;
import com.briup.ssm.common.exception.*;
import com.briup.ssm.common.util.ResponseResult;
import com.briup.ssm.service.interfaces.IBookService;
import com.briup.ssm.service.interfaces.ICustomerService;
import com.briup.ssm.service.interfaces.IOrderService;
import com.briup.ssm.service.interfaces.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RequestMapping("/customerController")
@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IBookService bookService;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IShoppingCartService shoppingCartService;

    @RequestMapping(value = "/registerPage",method = RequestMethod.GET)
    public String registerPage(){

        return "register";
    }


    @RequestMapping(value = "/checkUserName/{name}",method = RequestMethod.GET)
    @ResponseBody
    public Object checkUserName(@PathVariable String name){
        try {
            Customer customer = customerService.findCustomer(name);
            if (customer == null) {
                return ResponseResult.ok();
            }
            return ResponseResult.build(500, "faile");
        } catch (EstoreCommonException e) {
            e.printStackTrace();
            return ResponseResult.build(500, "faile");
        }
    }


    @RequestMapping(value = "/customerRegister",method = RequestMethod.POST)
    public String customerRegister(Customer customer,HttpSession session){

        try {
            customerService.register(customer);
            session.setAttribute("msg", "注册成功,请登录!");
            return "redirect:/customerController/loginPage";
        } catch (EstoreCommonException e) {
            e.printStackTrace();
            session.setAttribute("msg","注册失败: " + e.getMessage());
            return "redirect:/customerController/registerPage";
        }
    }

    @RequestMapping(value = "/loginPage",method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/customerLogin",method = {RequestMethod.POST,RequestMethod.GET})
    public String customerLogin(String name,String password, HttpSession session){
        try {
            Customer customerLogin = customerService.login(name, password);
            Long id = customerLogin.getId();
            List<Order> orderall = orderService.findByIdReturnList(id);
            ShoppingCar shoppingCart = shoppingCartService.findShoppingCart(id);

            session.setAttribute("customer",customerLogin);
            session.setAttribute("shoppingCar",shoppingCart);
            session.setAttribute("shoppingCarAll",shoppingCart.getLines());
            session.setAttribute("orderall",orderall);
            session.setAttribute("msg", "登录成功");

            return "redirect:/indexController/showIndexPage";

        } catch (OrderException e) {
            session.setAttribute("msg","登录失败: " + e.getMessage());
            return "redirect:/customerController/loginPage";
        } catch (ShoppingCartException e) {
            session.setAttribute("msg","登录失败: " + e.getMessage());
            return "redirect:/customerController/loginPage";
        } catch (EstoreCommonException e) {
            session.setAttribute("msg","登录失败: " + e.getMessage());
            return "redirect:/customerController/loginPage";
        }
    }

    @RequestMapping(value = "/updatePage",method = RequestMethod.GET)
    public String updatePage(){
        return "user/userinfo";
    }

    @RequestMapping(value = "/customerUpdate",method = {RequestMethod.GET,RequestMethod.POST})
    public String customerUpdate(Customer customer, HttpSession session){
        try {
            customerService.updateCustomer(customer);
            session.setAttribute("customer",customer);
            session.setAttribute("updatemsg","修改成功");
            return "redirect:/customerController/updatePage";
        } catch (EstoreCommonException e) {
            session.setAttribute("updatemsg","修改失败: " + e.getMessage());
            return "redirect:/customerController/updatePage";
        }
    }


    @RequestMapping(value = "/indexPage",method = RequestMethod.GET)
    public String indexPage(){
        return "index";
    }

    @RequestMapping(value = "exitPage",method = RequestMethod.GET)
    public String exitPage(HttpSession session){
        ShoppingCar shoppingCar = (ShoppingCar) session.getAttribute("shoppingCar");
        Customer customer = (Customer) session.getAttribute("customer");
        if (shoppingCar!=null){
            try {
                shoppingCartService.saveShoppingCart(shoppingCar,customer);
                session.removeAttribute("customer");
                session.setAttribute("msg","当前用户已退出，");
            } catch (ShoppingCartException e) {
                session.setAttribute("msg","未知错误");
                return "redirect:/customerController/loginPage";
            }
        }
        return "redirect:/customerController/loginPage";
    }
}
