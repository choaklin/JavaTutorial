package com.qutopia.tutorial.javaee.servlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * something
 *
 * @author choaklin
 * @since 0.1.0
 */
@WebServlet(
        loadOnStartup = 1,
        initParams = {
                @WebInitParam(name = "", value = ""),
                @WebInitParam(name = "", value = "")
        }
)
public class SimpleServlet extends HttpServlet {
}
