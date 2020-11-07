package org.xiren.service.impl;

import org.springframework.stereotype.Service;
import org.xiren.dao.LoginMapper;
import org.xiren.model.User;
import org.xiren.service.LoginService;
import org.xiren.utils.StrIsNumUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
@Service
public class LoginServiceImpl implements LoginService {

    /**
     * 登录验证
     *
     * @param user_name 用户名
     * @param pwd   密码
     * @return 验证结果
     */
    @Resource
    private LoginMapper mapper;

    @Override
    public boolean doLogin(String user_name, String pwd) {
        boolean type = StrIsNumUtils.checkStrIsNum(user_name);
        if(type){
            List<User> list = mapper.doLoginById(user_name,pwd);
            if(list.isEmpty()){
                return false;
            }else{
                return true;
            }
        }else {
            List<User> list = mapper.doLoginByName(user_name,pwd);
            if(list.isEmpty()){
                return false;
            }else{
                return true;
            }
        }
    }
}
