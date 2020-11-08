package org.xiren.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.xiren.model.Tab;
import org.xiren.model.User;

import java.util.List;

/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/28 20:08
 */
public interface AccountMapper {
    /**
     * 新增用户数据
     * @param nickname
     * @param password
     * @param dp_no
     * @param name
     * @param sex
     * @param birthday
     * @param phone
     * @param email
     * @param state
     * @return
     */
    Integer doAdd(@Param("nickname")String nickname,@Param("password")String password,@Param("dp_no")int dp_no,@Param("name")String name,@Param("sex")String sex,@Param("birthday")String birthday,@Param("phone")String phone,@Param("email")String email,@Param("state")String state);

    /**
     * 更新用户数据
     * @param no
     * @param nickname
     * @param password
     * @param dp_no
     * @param name
     * @param sex
     * @param birthday
     * @param phone
     * @param email
     * @param state
     * @return
     */
    Integer doChangeInfromation(@Param("no") int no,@Param("nickname")String nickname,@Param("password")String password,@Param("dp_no")int dp_no,@Param("name")String name,@Param("sex")String sex,@Param("birthday")String birthday,@Param("phone")String phone,@Param("email")String email,@Param("state")String state);

    /**
     * 删除用户数据
     * @param ids
     * @return
     */
    Integer doDel(@Param("ids") List<Integer> ids);

    /**
     * 更新用户状态开启
     * @param no
     * @return
     */
    Integer doChangeStateOpen(@Param("no")int no);

    /**
     * 更新用户状态开启
     * @param no
     * @return
     */
    Integer doChangeStateClose(@Param("no")int no);

    /**
     * 通过用户名更改当前用户的密码
     * @param user
     * @param password
     * @return
     */
    Integer doUpdataCodeByName(@Param("user")String user,@Param("password") int password);

    /**
     * 通过id更改当前用户的密码
     * @param user
     * @param password
     * @return
     */
    Integer doUpdataCodeById(@Param("user")String user,@Param("password") int password);

    /**
     * 展示部门表
     * @param rowBounds
     * @return
     */
    List<Tab> getTableList(RowBounds rowBounds);

    /**
     * 展示用户页
     * @param account
     * @param rowBounds
     * @return
     */
    List<User> getPersonList(@Param("account")String account,RowBounds rowBounds);

    /**
     * 搜索功能
     * @param account
     * @return
     */
    Integer countPersonList(@Param("account")String account);

}
