package org.xiren.service;

import java.io.IOException;
import java.io.OutputStream;
/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
public interface DownloadService {
    /**
     * 文件下载
     * @param outputStream
     * @param name 路径
     * @throws IOException
     */
    void doDownload(OutputStream outputStream, String name) throws IOException;
}
