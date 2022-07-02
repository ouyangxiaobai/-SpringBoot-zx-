package com.gqzdev.learn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * @ClassName MyInterceptor
 * @Description
 * @Author ganquanzhong
 * @Date2021/4/11 17:44
 * @Version
 **/
@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object obj) throws Exception {
        //处理之前执行
        //System.out.println("处理之前执行: preHandle");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        //1.判断session里有没有保存用户  2.判断uri路径
        HttpSession session=request.getSession();
        Object object = (Object)session.getAttribute("user");
        String uri=request.getRequestURI();

        if (uri.endsWith("logon.html")||uri.endsWith("logon.jsp") || uri.endsWith("logon") || uri.endsWith("userLogon.html")  || uri.endsWith("css")
                || uri.endsWith("js")|| uri.endsWith(".jpg") || uri.endsWith(".html") ||
                uri.endsWith("addStudent.html")  ||	uri.endsWith("checkName.action")) {
            //访问登录页面时，直接访问
            return true;
        }else if (object!=null) {
            //用户已经登录了，session中有用户的信息，可以访问admin/下的内容
            return true;
        }else {
            //其他情况，不允许访问下的内容  跳转到登录页面
//			System.out.println("--拦截--");
            PrintWriter out = response.getWriter();
            out.print("<script>alert('您还未登录！请先完成登录后再操作！！');</script>");
            response.sendRedirect(request.getContextPath()+"/logon.html");
//			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
        }
        return false;
    }


    @Override
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        //完成之后执行
        //System.out.println("完成之后执行： afterCompletion ");
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
        //处理完毕之后执行
        //System.out.println("处理完毕之后执行:  postHandle");
    }




}
