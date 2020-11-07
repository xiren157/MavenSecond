package org.xiren.dao;

import org.apache.ibatis.annotations.Param;
import org.xiren.model.User;

import java.util.List;

/**
 * @author xiren
 * @version 1.0
 * @date 2020/11/1 13:11
 */
public interface CheckMapper {

    /**
     * 验证用户id是否重复
     * @param user_name
     * @return
     */
    List<User> checkNameById(@Param("user")String user_name);

    /**
     * 验证用户Name是否重复
     * @param user_name
     * @return
     */
    List<User> checkNameByName(@Param("user")String user_name);
}
