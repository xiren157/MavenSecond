package org.xiren.dao;

import org.apache.ibatis.session.RowBounds;
import org.xiren.model.Property;

import java.util.List;

/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/30 21:10
 */
public interface FormMapper {
    /**
     * 展示产品列表
     * @param rowBounds
     * @return
     */
    List<Property> getPropertyList(RowBounds rowBounds);
}
