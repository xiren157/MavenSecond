package org.xiren.service;
/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
public interface RegisterService {
    /**
     * 用户注册
     * @param user_name
     * @param pwd
     * @param email
     * @return
     */
    boolean doRegister(String user_name, String pwd, String email);
}
