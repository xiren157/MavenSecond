package org.xiren.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @author xiren
 * @version 1.0
 * @date 2020/11/7 14:44
 * 返回值处理工具
 */
public class WebUtils {
    public static String returnData(Object obj) {
        JSONObject data = (JSONObject) JSONObject.toJSON(obj);
        return data.toString();
    }
}
