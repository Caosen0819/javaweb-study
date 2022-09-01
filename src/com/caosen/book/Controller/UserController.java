package com.caosen.book.Controller;

import com.caosen.book.pojo.Cart;
import com.caosen.book.pojo.User;
import com.caosen.book.service.CartItemService;
import com.caosen.book.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author Caosen
 * @Date 2022/7/18 12:48
 * @Version 1.0
 */
public class UserController {

    private UserService userService ;
    private CartItemService cartItemService;

    public String login(String uname, String pwd, HttpSession session){
        User user = userService.login(uname, pwd);

        if (user != null){
            Cart cart = cartItemService.getCart(user);
            user.setCart(cart);
            session.setAttribute("currUser", user);
            System.out.println("user = " + user);
            return "redirect:book.do";
        }

        return "user/login";
    }
    public String regist(String verifyCode, String uname, String pwd, String email, HttpSession session, HttpServletResponse response) throws IOException {
        Object kaptcha_session_key = session.getAttribute("KAPTCHA_SESSION_KEY");
        if (kaptcha_session_key == null || !verifyCode.equals(kaptcha_session_key)){
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            //out.println("<script language='javascript'>alert('验证码不正确！');window.location.href='page.do?operate=page&page=user/regist';</script>");
            out.println("<script language='javascript'>alert('验证码不正确！');</script>");
            //return "user/regist";
            return "user/regist";
        }else {
            if (verifyCode.equals(kaptcha_session_key)){
                userService.regist(new User(uname, pwd, email, 0));
                return "user/login";
            }
        }
        return "user/login";
    }

    public String ckUname(String uname){
        User user = userService.getUser(uname);
        if (user != null) {
            return "json:{'uname':'1'}";
        }else {
            return "json:{'uname':'0'}";
        }

    }
}
