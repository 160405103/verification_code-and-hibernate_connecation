package com.sut.example.demo.Controller;



import com.sut.example.demo.utils.myVerifyCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public class MyVerifyController1 {
    @RequestMapping("/createImg")
//微服务用redis
    public void createImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
        myVerifyCodeUtils verifycode=new myVerifyCodeUtils();
        String text=verifycode.generateVerifyCode(4);//生成4位验证码
        BufferedImage image = verifycode.getImage(150,50,text);//获取验证码图片
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuffer randomCode = new StringBuffer();
        randomCode.append(text);
        // 将验证码保存到Session中。
        HttpSession session = request.getSession();
        session.removeAttribute("verCode");  //先删除旧的验证码
        session.removeAttribute("codeTime");
        session.setAttribute("signcode", randomCode.toString());
        session.setAttribute("codeTime", LocalDateTime.now());
        System.out.println("session-signcode==>"+randomCode.toString());
        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache"); // 禁止图像缓存。
        response.setDateHeader("Expire", 0);
        ServletOutputStream sos = response.getOutputStream();
        // 将图像输出到Servlet输出流中。
        ImageIO.write(image, "jpg", sos);
        sos.flush();
        sos.close();
    }

//    //@RequestMapping("/verifycode")
//    public String validImage(@RequestParam("code") String vercode,
//                             Map<String,Object> map, HttpServletRequest request,HttpSession session){
//        session = request.getSession();
//        String signcode = (String) session.getAttribute("signcode");
//        // Object verCode = session.getAttribute("verCode");
//        System.out.println("用户输入的"+vercode);
//        System.out.println("后台生成的"+signcode);
//        if (null == vercode) {
//            map.put("errmsg","验证码已失效，请重新输入");
//            //return "redirect:verifycode.html";
//           // retur "验证码已失效，请重新输入";
//            System.out.println("验证码已失效，请重新输入");
//            return "4";
//        }
//        // String verCodeStr = verCode.toString();
//        LocalDateTime localDateTime = (LocalDateTime)session.getAttribute("codeTime");
//
//        long past = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
//        long now = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
//        System.out.println(now);
//        if(vercode == null || signcode == null || vercode.isEmpty() || !vercode.equalsIgnoreCase(signcode)){
//            map.put("errmsg", "验证码错误");
//            System.out.println("验证码错误");
//            //return "1";
//            return "4";
//            //return "redirect:verifycode.html";
//        } else if((now-past)/1000/60>5){
//            map.put("errmsg", "验证码已过期，重新获取");
//            System.out.println("验证码已过期，重新获取");
//           // return "验证码已过期，重新获取";
//            return "4";
//            //return "redirect:verifycode.html";
//        } else {
//            //验证成功，删除存储的验证码
//            session.removeAttribute("signcode");
//            System.out.println("验证成功");
//            //return "redirect:/index.html";
//            return "1";
//        }
//
//
//    }


}
