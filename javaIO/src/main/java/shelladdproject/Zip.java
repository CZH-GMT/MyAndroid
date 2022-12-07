package shelladdproject;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * Created by xiang on 2017/5/17.
 */

public class Zip {

    public static void unZip(File zipFile,File newFile) throws Exception {
        newFile.delete();
        ZipFile zipFile1 = new ZipFile(zipFile);
        //返回目录枚举 循环获取压缩包里面文件
        Enumeration<? extends ZipEntry> entries = zipFile1.entries();
        //如果有很多文件
        while (entries.hasMoreElements()){
            //挨个获取文件名字
            ZipEntry zipEntry = entries.nextElement();
            String name = zipEntry.getName();
            if (name.equals("META-INF/CERT.RSA") || name.equals("META-INF/CERT.SF") || name
                    .equals("META-INF/MANIFEST.MF")) {
                continue;
            }
            //当前不是文件夹
            if (!zipEntry.isDirectory()){
                File file = new File(newFile, name);
                if (!file.getParentFile().exists())file.getParentFile().mkdirs();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                InputStream inputStream = zipFile1.getInputStream(zipEntry);
                byte[] bytes = new byte[1024];
                int len;
                while ((len=inputStream.read(bytes))!=-1){
                    fileOutputStream.write(bytes,0,len);
                }
                //只有buffer才需要flush其他的不需要  因为buffer读的时候是一片 不到一片不显示 所以刷
                fileOutputStream.close();
                inputStream.close();
            }
        }
        zipFile1.close();
    }
    public static void zip(File dir, File zip) throws Exception {
        zip.delete();
        // 对输出文件做CRC32校验
        CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(
                zip), new CRC32());
        ZipOutputStream zos = new ZipOutputStream(cos);
        compress(dir, zos, "");
        zos.flush();
        zos.close();
    }

    private static void compress(File srcFile, ZipOutputStream zos,
                                 String basePath) throws Exception {
        if (srcFile.isDirectory()) {
            compressDir(srcFile, zos, basePath);
        } else {
            compressFile(srcFile, zos, basePath);
        }
    }

    private static void compressDir(File dir, ZipOutputStream zos,
                                    String basePath) throws Exception {
        File[] files = dir.listFiles();
        // 构建空目录
        if (files.length < 1) {
            ZipEntry entry = new ZipEntry(basePath + dir.getName() + "/");
            zos.putNextEntry(entry);
            zos.closeEntry();
        }
        for (File file : files) {
            // 递归压缩
            compress(file, zos, basePath + dir.getName() + "/");
        }
    }

    private static void compressFile(File file, ZipOutputStream zos, String dir)
            throws Exception {


        String dirName = dir + file.getName();

        String[] dirNameNew = dirName.split("/");

        StringBuffer buffer = new StringBuffer();

        if (dirNameNew.length > 1) {
            for (int i = 1; i < dirNameNew.length; i++) {
                buffer.append("/");
                buffer.append(dirNameNew[i]);

            }
        } else {
            buffer.append("/");
        }

        ZipEntry entry = new ZipEntry(buffer.toString().substring(1));
        zos.putNextEntry(entry);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
                file));
        int count;
        byte data[] = new byte[1024];
        while ((count = bis.read(data, 0, 1024)) != -1) {
            zos.write(data, 0, count);
        }
        bis.close();
        zos.closeEntry();
    }
}
