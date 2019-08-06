package com.sut.example.demo.Controller;

import com.sut.example.demo.utils.myVerifyCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;

@Controller
public class LoginController {
    @RequestMapping ("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("verifyCode") String vercode,
                        Map<String,Object> map,HttpServletRequest request, HttpSession session){
        //System.out.println("用户输入"+vercode);
        session = request.getSession();
        String signcode = (String) session.getAttribute("signcode");
        // Object verCode = session.getAttribute("verCode");
        System.out.println("用户输入的"+vercode);
        System.out.println("后台生成的"+signcode);
        if (null == vercode) {
            map.put("msg","验证码已失效，请重新输入");
            //return "redirect:verifycode.html";
            // retur "验证码已失效，请重新输入";
            System.out.println("验证码已失效，请重新输入");
            return "/login";
        }

        LocalDateTime localDateTime = (LocalDateTime)session.getAttribute("codeTime");

        long past = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long now = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println(now);
        if(vercode == null || signcode == null || vercode.isEmpty() || !vercode.equalsIgnoreCase(signcode)){
            map.put("msg", "验证码错误");
            return "/login";
        } else if((now-past)/1000/60>5){
            map.put("msg", "验证码已过期，重新获取");
            return "/login";
        } else {
            //验证成功，删除存储的验证码
            session.removeAttribute("signcode");
            System.out.println("验证成功");
        }

        if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        else{
            map.put("msg","用户名或密码错误");
            return "login";
        }

    }



}
