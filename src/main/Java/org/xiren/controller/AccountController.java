package org.xiren.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.xiren.model.Tab;
import org.xiren.model.User;
import org.xiren.service.AccountService;
import org.xiren.utils.PageDate;
import org.xiren.utils.StringUtils;
import org.xiren.utils.TableData;
import org.xiren.utils.WebUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
@RestController
public class AccountController {
    @Resource
    private AccountService as;

    @RequestMapping("/account-list.ajax")
    public String accountList(PageDate pd){
        TableData<User> td = as.list(pd);
        return WebUtils.returnData(td);
    }

    @RequestMapping("/account-del.ajax")
    public String accountDel(String ids){
        JSONObject data = new JSONObject();
        if (StringUtils.isEmpty(ids)) {
            data.put("type", -1);
            return data.toString();
        }

        // 参数转换
        String[] idArr = ids.split(",");
        List<Integer> idList = new ArrayList<>();
        for (String id : idArr) {
            int i = Integer.parseInt(id);
            idList.add(i);
        }
        // 调用Service
        as.doDel(idList);
        data.put("type", 0);
        return data.toString();
    }

    @RequestMapping("/account-save.ajax")
    public String accountSave(Integer person_no, String person_nickname, String person_password, Integer department_no, String person_name, String person_sex, String person_birthday, String person_phone, String person_email,String person_state){
            as.doModify(person_no, person_nickname, person_password,department_no,person_name,person_sex,person_birthday,person_phone,person_email,person_state);

            JSONObject data = new JSONObject();
            data.put("as", as);
            return data.toJSONString();
    }

    @RequestMapping("/department.ajax")
    public String departmentList(Integer index){
        if(index == null || index <= 0) {
            index = 1;
        }
        List<Tab> list = as.list(index);
        // 返回值处理
        JSONObject data = new JSONObject();
        data.put("list", list);
        return data.toJSONString();
    }

    @RequestMapping("/change.state.ajax")
    public String stateChange(Integer no, Integer state){
        as.doChange(state,no);

        JSONObject data = new JSONObject();
        data.put("as", as);
        return data.toJSONString();
    }
}
