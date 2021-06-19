package com.enesoon.zuul.server.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 路径：com.example.demo.zuul.config
 * 类名：
 * 功能：过滤器
 * 备注：
 * 创建人：typ
 * 创建时间：2018/9/13 14:12
 * 修改人：
 * 修改备注：
 * 修改时间：
 */

@Component
public class MyFilter extends ZuulFilter {

    private static final Logger log = LoggerFactory.getLogger(MyFilter.class);

    /**
     * 方法名：filterType
     * 功能：返回一个字符串代表过滤器的类型
     * 描述：
     *     PRE：这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试信息等。
     *     ROUTING：这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用Apache HttpClient或Netfilx Ribbon请求微服务。
     *     POST：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等。
     *     ERROR：在其他阶段发生错误时执行该过滤器。
     * 创建人：typ
     * 创建时间：2018/9/13 14:23
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 方法名：filterOrder
     * 功能：过滤的顺序
     * 描述：
     * 创建人：typ
     * 创建时间：2018/9/13 14:24 
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 方法名：shouldFilter
     * 功能：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     * 描述：
     * 创建人：typ
     * 创建时间：2018/9/13 14:25 
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Override
    public boolean shouldFilter() {
    	RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        ///apigateway/order/api/v1/order/test
        System.out.println(request.getRequestURI());
        //http://127.0.0.1:9000/apigateway/order/api/v1/order/test
        System.out.println(request.getRequestURL());

        //ACL: 访问控制列表
        //不需要拦截的接口
        List<String> noFIlter = new ArrayList<>();
        noFIlter.add("/enesoon-demo/login");

        AntPathMatcher matcher = new AntPathMatcher();
        for (String pattern : noFIlter) {//pattern--/user/**
            if (StringUtils.isNotEmpty(pattern)
                    && matcher.match(pattern, request.getRequestURI())) {
                return false;
            }
        }

        return true;
    }

    /**
     * 方法名：run
     * 功能：过滤器的具体逻辑。
     * 描述：
     * 创建人：typ
     * 创建时间：2018/9/13 14:25
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        log.info("method：{}, url：{}",request.getMethod(),request.getRequestURL());
        Object token = request.getParameter("token");
        if(token == null){
            log.info("token is empty");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        log.info("ok");
        return null;
    }
}
