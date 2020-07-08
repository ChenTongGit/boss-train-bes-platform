package com.boss.xtrain.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.NameFileFilter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Collection;


@Slf4j
public class MyFileUtils  {
    private MyFileUtils(){

    }

    /**将文件读入string
     * @param filepath
     * @return
     */
    public  static String readFileToString(String filepath) {
        String str = null;
        try {
            str = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        return str;
    }

    /**将string写入文件
     * @param file
     * @param str
     */
    public static void writeStringToFile(File file,String str) {

        try {
            FileUtils.writeStringToFile(file, str, StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }

    /**强制创建文件夹
     * @param filepath
     */
    public static void forceMkdir(String filepath) {
        File file = new File(filepath);
        try {
            FileUtils.forceMkdir(file);
        } catch (IOException e) {

            log.info(e.getMessage());
        }
    }

    /**强制删除文件或者文件夹
     * @param filename
     */
    public static void forceDelete(String filename) {

        File dirOrFile = new File(filename);
        try {
            FileUtils.forceDelete(dirOrFile);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }

    /**copy文件
     * @param srcFileName
     * @param destFileName
     */
    public static void copyFile(String srcFileName,String destFileName) {
        File src = new File(srcFileName);
        File dest = new File(destFileName);
        try {
            FileUtils.copyFile(src, dest);
        }catch (IOException e){
            log.info(e.getMessage());
        }

    }

    /**copy文件夹，过滤文件名添加需要copy的文件
     * @param srcFileName
     * @param destFileName
     * @param nameOfFileFilter
     */
    public static void copyDirectory(String srcFileName,String destFileName,String nameOfFileFilter) {
        File srcDir = new File(srcFileName);
        File destDir = new File(destFileName);
        try {
            FileUtils.copyDirectory(srcDir, destDir, new NameFileFilter(nameOfFileFilter), true);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }

    /**显示文件夹下所有文件，extension后加入需要显示的后缀，如果为空的话全加入
     * @param dirName
     * @param extensions
     * @return
     */
    public static Collection<File> listFiles(String dirName,String[] extensions) {

        File dir = new File(dirName);
        boolean recursive = true;
        return FileUtils.listFiles(dir, extensions, recursive);

    }
    public static void saveBit(InputStream inputStream,String filePath) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len=inputStream.read(buffer)) != -1 ){
//用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            byteArrayOutputStream.write(buffer, 0, len);
        }
        inputStream.close();
        byte[] data = byteArrayOutputStream.toByteArray();
//new一个文件对象用来保存图片，默认保存当前工程根目录
        File imageFile = new File(filePath);
//创建输出流
        FileOutputStream fileOutStream = new FileOutputStream(imageFile);
//写入数据
        fileOutStream .write(data);

    }
}
