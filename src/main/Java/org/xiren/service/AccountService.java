package org.xiren.service;

import org.xiren.model.Tab;
import org.xiren.model.User;
import org.xiren.utils.TableData;

import java.util.List;
/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
public interface AccountService {
    /**
     * 展示用户列表带搜索
     * @param index
     * @param account
     * @return list
     */
    TableData<User> list(int index, String account);

    /**
     * 删除账户
     * @param id
     */
    void doDel(int id);

    /**
     * 新增修改账户
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
     */
    void doModify(int no, String nickname, String password, int dp_no, String name, String sex, String birthday, String phone, String email, String state);

    /**
     * 用户状态修改
     * @param state
     * @param no
     */
    void doChange(int state, int no);

    /**
     * 更改登录账户密码
     * @param user
     * @param passwd
     */
    void doUpLoad(String user, int passwd);

    /**
     * 展示部门分页
     * @param index
     * @return
     */
    List<Tab> list(int index);

}
