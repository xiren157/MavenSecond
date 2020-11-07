package org.xiren.service;
/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
public interface CheckService {

    /**
     * 用户名查重
     *
     * @param user_name 用户名
     * @return 验证结果
     */
    boolean checkAccount(String user_name);
}
