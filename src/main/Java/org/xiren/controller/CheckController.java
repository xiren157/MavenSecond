package org.xiren.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xiren.service.CheckService;
import org.xiren.utils.StringUtils;

import javax.annotation.Resource;

/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
@RestController
public class CheckController {
    @Resource
    private CheckService ck;
    @RequestMapping("/account-check.ajax")
    public String checkName(String uname){
        int state = 0;
        // 2.参数校验
        if (StringUtils.isNotEmpty(uname)) {
            // 3.调用service
            boolean name = ck.checkAccount(uname);
            if (name) {
                state = 0;
            } else {
                state = -1;
            }
        } else {
            // 空参数
            state = -2;
            System.out.println("================");
        }
        // 4.处理结果
        JSONObject data = new JSONObject();
        data.put("state", state);
        return data.toJSONString();
    }

}
