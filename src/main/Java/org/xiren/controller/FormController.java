package org.xiren.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xiren.model.Property;
import org.xiren.service.FormService;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
@RestController
public class FormController {
    @Resource
    private FormService dp;
    @RequestMapping("/property.ajax")
    public String propertyList(Integer index){
        if(index == null || index <= 0) {
            index = 1;
        }
        List<Property> list = dp.list(index);

        JSONObject data = new JSONObject();
        data.put("list", list);
        return data.toString();
    }
}
