package org.xiren.service;

import org.xiren.model.Infromation;

import java.util.List;
/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
public interface IpService {
    /**
     * 添加用户登录日志
     * @param user_name
     * @param localName
     * @param localIp
     * @param localTime
     */
    void doAdd(String user_name, String localName, String localIp, String localTime);

    /**
     * 展示登录日志
     * @param index
     * @return
     */
    List<Infromation> list(int index);
}
