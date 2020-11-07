package org.xiren.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     *
     * @param request
     * @param response
     * @param handler
     * @return true 放行 || false 拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object logined = request.getSession().getAttribute("logined");
        if (logined != null){
            return true;
        }else {
            response.sendRedirect("login.html");
            return false;
        }
    }
}
