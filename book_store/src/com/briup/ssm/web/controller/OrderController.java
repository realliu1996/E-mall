package com.briup.ssm.web.controller;

import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.bean.Line;
import com.briup.ssm.common.bean.Order;
import com.briup.ssm.common.bean.ShoppingCar;
import com.briup.ssm.common.exception.OrderException;
import com.briup.ssm.common.exception.ShoppingCartException;
import com.briup.ssm.service.interfaces.IOrderService;
import com.briup.ssm.service.interfaces.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("/orderController")
@Controller
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IShoppingCartService shoppingCartService;


    @RequestMapping(value = "/confirmOrderPage",method = RequestMethod.GET)
    public String confirmOrderPage(){
        return "user/confirmOrder";
    }



    @RequestMapping(value = "/confirmOrder",method = RequestMethod.GET)
    public String confirmOrder(HttpSession session){

        ShoppingCar shopcart = (ShoppingCar) session.getAttribute("shoppingCar");

        if (shopcart.getLines().size()==0){
            session.setAttribute("delmessage","购物车为空,无法提交订单");
            return "redirect:/shoppingCarController/shoppingCartPage";
        }
        return "redirect:/orderController/confirmOrderPage";

    }


    @RequestMapping(value = "/orderPage",method = RequestMethod.GET)
    public String orderPage(){
        return "order";
    }


    @RequestMapping(value = "/confirmOrder",method = RequestMethod.POST)
    public String confirmOrder(String payway, HttpSession session){

        Customer customer = (Customer)session.getAttribute("customer");
        ShoppingCar shoppingCar = (ShoppingCar)session.getAttribute("shoppingCar");
        List<Order> orderall = (List<Order>)session.getAttribute("orderall");
        Map<Long, Line> map = shoppingCar.getLines();
        double sum = 0;
        for (Line line : map.values()) {
            sum+=line.getNum()*line.getBook().getPrice();
        }
        Order order=new Order();
        order.setCost(sum);
        order.setOrderDate(new Date());
        order.setPayment(payway);
        order.setCustomer(customer);
        orderall.add(order);
        Collection<Line> lines=map.values();

        try {

            orderService.confirmOrder(customer,order,lines);
            shoppingCar.clear();
            shoppingCartService.delShoppingCart(customer.getId());
            session.setAttribute("shoppingCar",shoppingCar);
            session.setAttribute("ordermessage","提交订单成功");
            return "redirect:/orderController/orderPage";

        } catch (OrderException e) {

            session.setAttribute("ordermessage","提交订单失败");
            return "redirect:/orderController/orderPage";

        } catch (ShoppingCartException e) {

            session.setAttribute("ordermessage","提交订单失败");
            return "redirect:/orderController/orderPage";

        }
    }

    @RequestMapping(value = "/orderInfoPage",method = RequestMethod.GET)
    public String orderInfoPage(){
        return "user/orderinfo";
    }

    @RequestMapping(value = "/datailOrder/{orderId}",method = RequestMethod.GET)
    public String datailOrder(@PathVariable("orderId") Long orderId,HttpSession session){
        try {
            Order order = orderService.findById(orderId);
            Set<Line> lines = order.getLines();
            Customer customer = order.getCustomer();
            Date orderDate = order.getOrderDate();
            DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
            String format = dateFormat.format(orderDate);
            session.setAttribute("format",format);
            session.setAttribute("customerfromdb", customer);
            session.setAttribute("order", order);
            session.setAttribute("lines", lines);
            return "redirect:/orderController/orderInfoPage";

        } catch (OrderException e) {
            session.setAttribute("ordermessage","查看订单失败");
            return "redirect:/orderController/orderPage";
        }

    }

    @RequestMapping(value = "/delOrder/{orderid}",method = {RequestMethod.GET,RequestMethod.POST})
    public String delOrder(@PathVariable("orderid") Long orderid,HttpSession session){

        try {
            Order order = orderService.findById(orderid);
            Long id = order.getCustomer().getId();
            orderService.deleteOrder(orderid);
            List<Order> orderall = orderService.findByIdReturnList(id);
            session.setAttribute("orderall",orderall);
            session.setAttribute("ordermessage","删除订单成功");
            return "redirect:/orderController/orderPage";
        } catch (OrderException e) {
            session.setAttribute("ordermessage","删除订单失败");
            return "redirect:/orderController/orderPage";
        }

    }

}
