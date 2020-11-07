package org.xiren.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xiren.service.AccountService;
import org.xiren.service.LoginService;
import org.xiren.utils.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
@RestController
public class LoginController {
    @Resource
    private LoginService ls;
    @Resource
    private AccountService as;

    @RequestMapping("/login.ajax")
    public String doLogin(String user_name, String pwd, HttpServletRequest request){
        int code = 0;
        // 2.参数校验
        if (StringUtils.isAllNotEmpty(user_name, pwd)) {
            // 3.调用service
            boolean login = ls.doLogin(user_name, pwd);
            if (login) {
                code = 0;
                request.getSession().setAttribute("logined","true");
                request.getSession().setAttribute("displayName",user_name);
            } else {
                code = -1;
            }
        } else {
            // 空参数
            code = -2;
            System.out.println("================");
        }
        // 4.处理结果
        JSONObject data = new JSONObject();
        data.put("code", code);
        return data.toJSONString();
    }

    @RequestMapping("/out.login.ajax")
    public String outLogin(HttpServletRequest request){

        request.getSession().setAttribute("logined",null);
        JSONObject data = new JSONObject();
        data.put("type", true);
        return data.toString();
    }

    @RequestMapping("/main.ajax")
    public String mainPage(HttpServletRequest request){
        Object displayName = request.getSession().getAttribute("displayName");
        JSONObject data = new JSONObject();
        data.put("user_name",displayName);
        return data.toJSONString();
    }

    @RequestMapping("/upload.ajax")
    public String upLoadCode(Integer passwd, HttpServletRequest request){
        Object displayName = request.getSession().getAttribute("displayName");
        as.doUpLoad((String) displayName, passwd);
        JSONObject data = new JSONObject();
        data.put("as", as);
        return data.toString();
    }
}
