package org.xiren.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xiren.model.Infromation;
import org.xiren.model.Space;
import org.xiren.service.impl.IpServiceImpl;
import org.xiren.service.IpService;
import org.xiren.utils.IpUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
@RestController
public class IpController {
    @Resource
    private IpService dp;
    @RequestMapping("/space.ajax")
    public String spaceList(){
        List<Space> list = new ArrayList<>();

        File c = new File("C:/");
        long freeSpaceC = c.getFreeSpace();
        long totalSpaceC = c.getTotalSpace();
        long UsableSpaceC = totalSpaceC -  freeSpaceC;

        File e = new File("E:/");
        long freeSpaceE = e.getFreeSpace();
        long totalSpaceE = e.getTotalSpace();
        long UsableSpaceE = totalSpaceE -  freeSpaceE;

        File f = new File("f:/");
        long freeSpaceF = f.getFreeSpace();
        long totalSpaceF = f.getTotalSpace();
        long UsableSpaceF = totalSpaceF -  freeSpaceF;

        Space sp1 = new Space(freeSpaceC,UsableSpaceC);
        Space sp2 = new Space(freeSpaceE,UsableSpaceE);
        Space sp3 = new Space(freeSpaceF,UsableSpaceF);

        list.add(sp1);
        list.add(sp2);
        list.add(sp3);

        JSONObject data = new JSONObject();
        data.put("list", list);
        return data.toString();
    }

    @RequestMapping("/index.ajax")
    public String getLocalIp(Integer index, HttpServletRequest request){
        Object displayName = request.getSession().getAttribute("displayName");
        String LocalIp = IpUtils.getIpAddr(request);
        String LocalName = null;
        try {
            LocalName = IpUtils.getLocalName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String LocalTime = IpUtils.getLocalTime();

        IpService information = new IpServiceImpl();
        information.doAdd((String) displayName,LocalName,LocalIp,LocalTime);
        List<Infromation> list = dp.list(index);
        // 返回值处理
        JSONObject data = new JSONObject();
        data.put("list", list);
        return data.toJSONString();
    }
}
