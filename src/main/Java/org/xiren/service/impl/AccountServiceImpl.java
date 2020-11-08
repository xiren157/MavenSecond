package org.xiren.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.annotation.Transactional;
import org.xiren.dao.AccountMapper;
import org.xiren.model.Tab;
import org.xiren.model.User;
import org.xiren.service.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.xiren.utils.PageDate;
import org.xiren.utils.PageUtils;
import org.xiren.utils.StrIsNumUtils;
import org.xiren.utils.TableData;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper mapper;

    @Override
    public TableData<User> list(PageDate pd) {
        /** 构造结果数据*/
        TableData<User> td = new TableData<>(pd);
        /** 获取参数*/
        String account = null;
        JSONObject sd = pd.getSearchData();
        if(sd != null){
            account = sd.getString("account");
        }
        /** 调用Dao*/
        Integer count = mapper.countPersonList(account);
        td.setDataCount(count);
        if (count > 0) {
            List<User> list = mapper.getPersonList(account, PageUtils.getRb(pd));
            td.setDataList(list);
        }
        return td;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void doDel(List<Integer> idList) {
        mapper.doDel(idList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void doModify(int no, String nickname, String password, int dp_no, String name, String sex, String birthday, String phone, String email,String state) {
        if(no >0){
            mapper.doChangeInfromation(no, nickname, password, dp_no, name, sex, birthday, phone, email, state);
        }else {
            mapper.doAdd(nickname,password,dp_no,name,sex,birthday,phone,email,state);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void doChange(int state, int no) {
        if(state == 0){
            mapper.doChangeStateOpen(no);
        }else{
            mapper.doChangeStateClose(no);
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void doUpLoad(String user, int passwd) {
        boolean type = StrIsNumUtils.checkStrIsNum(user);
        if(type){
            mapper.doUpdataCodeById(user, passwd);
        }else{
            mapper.doUpdataCodeByName(user, passwd);
        }
    }

    @Override
    public List<Tab> list(int index) {
        int offset = (index - 1) * 4;
        int limit = 4;
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<Tab> list = mapper.getTableList(rowBounds);
        return list;
    }

}
