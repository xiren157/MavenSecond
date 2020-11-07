package org.xiren.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.xiren.model.Infromation;

import java.util.List;

/**
 * @author xiren
 * @version 1.0
 * @date 2020/11/1 18:05
 */
public interface IpMapper {
    /**
     * 添加一条登录信息
     * @param user_name
     * @param localName
     * @param localIp
     * @param localTime
     * @return
     */
    Integer doAdd(@Param("user")String user_name, @Param("localName")String localName, @Param("localIp")String localIp,@Param("localTime")String localTime);

    /**
     * 展示登录日志
     * @param rowBounds
     * @return
     */
    List<Infromation> getIpList(RowBounds rowBounds);
}
