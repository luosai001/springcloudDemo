package com.springcloud.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sai.luo on 2017-8-18.
 */
public class MyZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre"; //过滤器类型 有pre route post error
    }

    @Override
    public int filterOrder() {
        return 1;  //过滤器顺序 越小越优先
    }

    @Override
    public boolean shouldFilter() {
        return true; //是否过滤
    }

    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        String servletPath = request.getServletPath();
        //zuul 对所有 /** forward转发 到本地的 的请求进行重定向 到百度
        if (servletPath.lastIndexOf("/")==0){
            HttpServletResponse response = currentContext.getResponse();

            try {
                response.sendRedirect("http://www.baidu.com");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        return null;
    }
}
