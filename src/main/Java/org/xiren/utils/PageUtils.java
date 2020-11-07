package org.xiren.utils;

import org.apache.ibatis.session.RowBounds;

/**
 * @author xiren
 * @version 1.0
 * @date 2020/11/3 14:09
 */
public class PageUtils {
    public static RowBounds getRb(Integer pageSize, Integer pageIndex) {
        int offset = (pageIndex - 1) * pageSize;
        int limit = pageSize;
        return new RowBounds(offset, limit);
    }

}
