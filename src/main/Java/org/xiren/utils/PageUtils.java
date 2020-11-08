package org.xiren.utils;

import org.apache.ibatis.session.RowBounds;

/**
 * @author xiren
 * @version 1.0
 * @date 2020/11/3 14:09
 */
public class PageUtils {
    public static RowBounds getRb(PageDate pd) {
        int offset = (pd.getPageIndex() - 1) * pd.getPageSize();
        int limit = pd.getPageSize();
        return new RowBounds(offset, limit);
    }

}
