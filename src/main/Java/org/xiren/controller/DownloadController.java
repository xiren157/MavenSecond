package org.xiren.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xiren.service.DownloadService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
@RestController
public class DownloadController {
    @Resource
    private DownloadService dw;
    @RequestMapping("/download")
    public void downloadDocument(String fn, HttpServletResponse response) throws IOException {
        // 告诉浏览器我是一个文件，你要下载不是打开
        response.setContentType("application/x-msdownload");
        // 转码文件名
        String encode = URLEncoder.encode(fn, "utf-8");
        // 告诉浏览器文件名
        response.setHeader("content-disposition", "attachment;filename=" + encode);
        //3.调用service
        //根据参数设置文件路径
        String road = "F:\\project\\web\\document\\" + fn ;
        OutputStream outputStream = response.getOutputStream();
        // 读文件
        dw.doDownload(outputStream,road);
    }

}
