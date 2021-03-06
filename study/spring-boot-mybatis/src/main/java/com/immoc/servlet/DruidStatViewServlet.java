package com.immoc.servlet;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-30
 */
@WebServlet(urlPatterns = "/druid/*",
        initParams = {
                // IP白名单(没有配置或者为空，则允许所有访问)
                @WebInitParam(name = "allow", value = "127.0.0.1,192.168.163.1"),
                // IP黑名单 (存在共同时，deny优先于allow)
                @WebInitParam(name = "deny", value = "192.168.1.73"),
                // druid用户名
                @WebInitParam(name = "loginUsername", value = "root"),
                // druid密码
                @WebInitParam(name = "loginPassword", value = "111111"),
                // 禁用HTML页面上的“Reset All”功能
                @WebInitParam(name = "resetEnable", value = "true")
        })
public class DruidStatViewServlet extends StatViewServlet {
    private static final long serialVersionUID = -2688872071445249539L;

}