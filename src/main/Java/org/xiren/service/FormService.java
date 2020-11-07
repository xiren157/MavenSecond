package org.xiren.service;

import org.xiren.model.Property;

import java.util.List;
/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
public interface FormService {
    /**
     * 展示property表格
     * @param index
     * @return list
     */
    List<Property> list(int index);
}
