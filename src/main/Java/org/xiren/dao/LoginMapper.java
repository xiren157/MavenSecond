package org.xiren.dao;

import org.apache.ibatis.annotations.Param;
import org.xiren.model.User;

import java.util.List;

/**
 * @author xiren
 * @version 1.0
 * @date 2020/11/1 19:16
 */
public interface LoginMapper {
    /**
     * 用户id登录
     * @param user_no
     * @param pwd
     * @return
     */
    List<User> doLoginById(@Param("no") String user_no,@Param("password")String pwd);

    /**
     * 用户名登录
     * @param user_name
     * @param pwd
     * @return
     */
    List<User> doLoginByName(@Param("name")String user_name,@Param("password")String pwd);

}
