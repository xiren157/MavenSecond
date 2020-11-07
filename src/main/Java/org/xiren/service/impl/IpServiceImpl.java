package org.xiren.service.impl;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xiren.dao.IpMapper;
import org.xiren.model.Infromation;
import org.xiren.service.IpService;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */

@Service
public class IpServiceImpl implements IpService {
    private static int pageSize = 40;
    @Resource
    private IpMapper mapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void doAdd(String user_name,String localName, String localIp, String localTime) {
        mapper.doAdd(user_name, localName, localIp, localTime);
    }

    @Override
    public List<Infromation> list(int index) {
        int offset = (index - 1) * pageSize;
        int limit = pageSize;
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<Infromation> list = mapper.getIpList(rowBounds);
        return list;
    }
}
