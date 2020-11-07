package org.xiren.service.impl;

import org.springframework.stereotype.Service;
import org.xiren.service.DownloadService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
@Service
public class DownloadServiceImpl implements DownloadService {
    /**
     * 文件下载
     * @param outputStream
     * @param name 路径
     * @throws IOException
     */
    @Override
    public void doDownload(OutputStream outputStream, String name) throws IOException {
        FileInputStream fis = new FileInputStream(new File(name));
        byte[] b = new byte[1024];
        int num = 0;
        while ((num = fis.read(b)) != -1) {
            outputStream.write(b);
        }
        fis.close();
        outputStream.close();
    }
}
