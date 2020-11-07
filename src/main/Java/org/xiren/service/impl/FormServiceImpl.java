package org.xiren.service.impl;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.xiren.dao.FormMapper;
import org.xiren.model.Property;
import org.xiren.service.FormService;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */

@Service
public class FormServiceImpl implements FormService {
    private static int pageSize = 10;
    @Resource
    private FormMapper mapper;

    @Override
    public List<Property> list(int index) {
        int offset = (index - 1) * pageSize;
        int limit = pageSize;
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<Property> list = mapper.getPropertyList(rowBounds);
        return list;
    }
}
