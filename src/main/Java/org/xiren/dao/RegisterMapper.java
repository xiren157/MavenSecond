package org.xiren.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author xiren
 * @version 1.0
 * @date 2020/11/1 20:04
 */
public interface RegisterMapper {
    /**
     * 用户注册
     * @param user_name
     * @param pwd
     * @param email
     * @return
     */
    Integer doRegister(@Param("nickname")String user_name,@Param("password")String pwd,@Param("email")String email);
}
