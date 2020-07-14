package com.boss.xtrain.common.util.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.*;

public class OssUtilsTest {

    @Test
    public void downLoading() {
        OSSClient ossClient = OssUtils.getOSSClient();
        try
        {
            URL url = new URL(OssUtils.getUrl(OssConstant.BUCKET_NAME,OssConstant.FOLDER,"boss.jpg"));
            System.out.println("URL 为：" + url.toString());
            System.out.println("协议为：" + url.getProtocol());
            System.out.println("验证信息：" + url.getAuthority());
            System.out.println("文件名及请求参数：" + url.getFile());
            System.out.println("主机名：" + url.getHost());
            System.out.println("路径：" + url.getPath());
            System.out.println("端口：" + url.getPort());
            System.out.println("默认端口：" + url.getDefaultPort());
            System.out.println("请求参数：" + url.getQuery());
            System.out.println("定位位置：" + url.getRef());
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}