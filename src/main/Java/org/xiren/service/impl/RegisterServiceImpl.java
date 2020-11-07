package org.xiren.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xiren.dao.RegisterMapper;
import org.xiren.service.RegisterService;

import javax.annotation.Resource;

/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {
    /**
     * 用户注册
     * @param user_name
     * @param pwd
     * @param email
     * @return
     */
    @Resource
    private RegisterMapper mapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean doRegister(String user_name, String pwd, String email) {
        Integer doRegister = mapper.doRegister(user_name, pwd, email);
        if(doRegister > 0){
            return true;
        }else{
            return false;
        }
    }
}
