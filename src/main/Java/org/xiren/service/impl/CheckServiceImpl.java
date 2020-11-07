package org.xiren.service.impl;

import org.springframework.stereotype.Service;
import org.xiren.dao.CheckMapper;
import org.xiren.model.User;
import org.xiren.service.CheckService;
import org.xiren.utils.StrIsNumUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
@Service
public class CheckServiceImpl implements CheckService {

    /**
     * 用户名查重
     * @param user_name 用户名
     * @return 验证结果
     */

    @Resource
    private CheckMapper mapper;
    @Override
    public boolean checkAccount(String user_name){
        boolean type = StrIsNumUtils.checkStrIsNum(user_name);
        if(type){
            List<User> list = mapper.checkNameById(user_name);
            if(list.isEmpty()){
                return true;
            }else{
                return false;
            }
        }else {
            List<User> list = mapper.checkNameByName(user_name);
            if(list.isEmpty()){
                return true;
            }else{
                return false;
            }
        }
    }
}
