package com.hzs.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hzs
 * @description 跨域请求
 * @date 2019/5/23 20:30
 */
public class SimpleCORSFilter implements Filter {
    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
//        System.out.println("进行同源策略的处理");
        HttpServletRequest req= (HttpServletRequest) request;
        String uri=req.getRequestURI();
        if(!uri.endsWith(".html") && !uri.endsWith(".css") && !uri.endsWith(".js"))
            System.out.println("非静态资源经过tomcat 8111");
        else
            System.out.println("html,css,js资源经过tomcat 8111");

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        // 是否支持cookie跨域
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }
}
