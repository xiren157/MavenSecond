package org.xiren.service;
/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
public interface LoginService {

    /**
     * 登录验证
     *
     * @param user_name 用户名
     * @param pwd   密码
     * @return 验证结果
     */
    boolean doLogin(String user_name, String pwd);

}
