package shelladdproject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;

/**
 * 代码中的apk是app构建产生的  aar是app给关联的library构建产生的
 * 此项目运行需要电脑配置dex环境
 */
public class MyMain {
    public static void main(String[] args) throws Exception {
        File file = new File("D:/MyAndroid/javaIO/sources/apk/temp");
        if (file.exists()){
            //返回的是该目录中的文件和目录
            File[] files = file.listFiles();
            for (File file1 : files) {
                if (file1.isFile()){
                    file1.delete();
                }
            }
        }

        File tempFile = new File("D:/MyAndroid/javaIO/sources/aar/temp");
        if (tempFile.exists()){
            for (File listFile : tempFile.listFiles()) {
                if (listFile.isFile()){
                    listFile.delete();
                }
            }
        }
        /**
         * 第一步对原始APK加密
         */
        AES.init(AES.DEFAULT_PWD);
        //解压apk
        File apkPath = new File("D:/MyAndroid/javaIO/sources/apk/app-debug.apk");
        //newApkFile用于临时存储解压缩文件的文件夹
        File newApkFile = new File(apkPath.getParent() + File.separator + "temp");
        if (!newApkFile.exists()){
            newApkFile.mkdirs();
        }
        //将原来apk里面的dex文件解压到新的apk文件
        Zip.unZip(apkPath,newApkFile);
        //给dex文件加密
        File mainDexFile = AES.encryptAPKFile(apkPath, newApkFile);

        if (newApkFile.isDirectory()) {
            File[] listFiles = newApkFile.listFiles();
            for (File files : listFiles) {
                if (files.isFile()) {
                    if (files.getName().endsWith(".dex")) {
                        String name = files.getName();
                        System.out.println("rename step1:"+name);
                        int cursor = name.indexOf(".dex");
                        String newName = files.getParent()+ File.separator + name.substring(0, cursor) + "_" + ".dex";
                        System.out.println("rename step2:"+newName);
                        files.renameTo(new File(newName));
                    }
                }
            }
        }
        /**
         * 第二步处理aar文件 获得dex
         */
        File aarFile = new File("D:/MyAndroid/javaIO/sources/aar/mylibrary-debug.aar");
        File file1 = Dx.jar2Dex(aarFile);
        //将里面的jar转换成dex文件
        File tempMainDex = new File(newApkFile.getPath() + File.separator + "classes.dex");
        if (!tempMainDex.exists()) {
            tempMainDex.createNewFile();
        }
//        System.out.println("MyMain" + tempMainDex.getAbsolutePath());
        FileOutputStream fos = new FileOutputStream(tempMainDex);
        byte[] fbytes = Utils.getBytes(file1);
        fos.write(fbytes);
        fos.flush();
        fos.close();

        /**
         * 第3步 打包签名
         */
        File unsignedApk = new File("D:/MyAndroid/javaIO/result/apk-unsigned.apk");
        unsignedApk.getParentFile().mkdirs();
//        File disFile = new File(apkFile.getAbsolutePath() + File.separator+ "temp");
        Zip.zip(newApkFile, unsignedApk);
        //不用插件就不能自动使用原apk的签名...
        File signedApk = new File("D:/MyAndroid/javaIO/result/apk-signed.apk");
        Signature.signature(unsignedApk, signedApk);
    }

    private static File getMainDexFile(File apkFile) throws Exception {
        // TODO Auto-generated method stub
        File disFile = new File(apkFile.getAbsolutePath() + "unzip");
        Zip.unZip(apkFile, disFile);
        File[] files = disFile.listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(".dex")) {
                    return true;
                }
                return false;
            }
        });
        for (File file: files) {
            if (file.getName().endsWith("classes.dex")) {
                return file;
            }
        }
        return null;
    }

}
