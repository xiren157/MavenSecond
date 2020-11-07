package org.xiren.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xiren.service.RegisterService;
import org.xiren.utils.StringUtils;

import javax.annotation.Resource;

/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
@RestController
public class RegisterController {
    @Resource
    private RegisterService ls;
    @RequestMapping("/register.ajax")
    public String registerNewAccount(String user_name, String pwd, String email){
        int code = 0;
        // 2.参数校验
        if (StringUtils.isAllNotEmpty(user_name, pwd)) {
            // 3.调用service
            boolean Register = ls.doRegister(user_name,pwd,email);
            if (Register) {
                code = 0;
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
        return data.toString();
    }
}
