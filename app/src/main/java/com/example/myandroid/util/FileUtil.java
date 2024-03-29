package com.example.myandroid.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import android.widget.Toast;

import com.example.myandroid.VideoInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 文件操作工具类
 */
public class FileUtil {
    private static String TAG = "FileUtil";
    private static final String[][] MIME_MapTable =
            {
                    // {后缀名， MIME类型}
                    {".3gp", "video/3gpp"}, {".apk", "application/vnd.android.package-archive"},
                    {".asf", "video/x-ms-asf"}, {".avi", "video/x-msvideo"},
                    {".bin", "application/octet-stream"}, {".bmp", "image/bmp"}, {".c", "text/plain"},
                    {".class", "application/octet-stream"}, {".conf", "text/plain"}, {".cpp", "text/plain"},
                    {".doc", "application/msword"},
                    {".docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"},
                    {".xls", "application/vnd.ms-excel"},
                    {".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"},
                    {".exe", "application/octet-stream"}, {".gif", "image/gif"},
                    {".gtar", "application/x-gtar"}, {".gz", "application/x-gzip"}, {".h", "text/plain"},
                    {".htm", "text/html"}, {".html", "text/html"}, {".jar", "application/java-archive"},
                    {".java", "text/plain"}, {".jpeg", "image/jpeg"}, {".jpg", "image/jpeg"},
                    {".js", "application/x-javascript"}, {".log", "text/plain"}, {".m3u", "audio/x-mpegurl"},
                    {".m4a", "audio/mp4a-latm"}, {".m4b", "audio/mp4a-latm"}, {".m4p", "audio/mp4a-latm"},
                    {".m4u", "video/vnd.mpegurl"}, {".m4v", "video/x-m4v"}, {".mov", "video/quicktime"},
                    {".mp2", "audio/x-mpeg"}, {".mp3", "audio/x-mpeg"}, {".mp4", "video/mp4"},
                    {".mpc", "application/vnd.mpohun.certificate"}, {".mpe", "video/mpeg"},
                    {".mpeg", "video/mpeg"}, {".mpg", "video/mpeg"}, {".mpg4", "video/mp4"},
                    {".mpga", "audio/mpeg"}, {".msg", "application/vnd.ms-outlook"}, {".ogg", "audio/ogg"},
                    {".pdf", "application/pdf"}, {".png", "image/png"},
                    {".pps", "application/vnd.ms-powerpoint"}, {".ppt", "application/vnd.ms-powerpoint"},
                    {".pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation"},
                    {".prop", "text/plain"}, {".rc", "text/plain"}, {".rmvb", "audio/x-pn-realaudio"},
                    {".rtf", "application/rtf"}, {".sh", "text/plain"}, {".tar", "application/x-tar"},
                    {".tgz", "application/x-compressed"}, {".txt", "text/plain"}, {".wav", "audio/x-wav"},
                    {".wma", "audio/x-ms-wma"}, {".wmv", "audio/x-ms-wmv"},
                    {".wps", "application/vnd.ms-works"}, {".xml", "text/plain"},
                    {".z", "application/x-compress"}, {".zip", "application/x-zip-compressed"}, {"", "*/*"}
            };


    /**
     * 获取目录下所有文件(按时间排序)
     *
     * @param path
     * @return
     */
    public static List<File> listFileSortByModifyTime(String path) {
        List<File> list = getFilesye(path, new ArrayList<File>());
        if (list != null && list.size() > 0) {
            Collections.sort(list, new Comparator<File>() {
                public int compare(File file, File newFile) {
                    if (file.lastModified() < newFile.lastModified()) {
                        return -1;
                    } else if (file.lastModified() == newFile.lastModified()) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });
        }
        return list;
    }

    /**
     * 获取目录下所有文件
     *
     * @param realpath
     * @param files
     * @return
     */
    public static List<File> getFilesye(String realpath, List<File> files) {
        File realFile = new File(realpath);
        Log.e(TAG, "getFilesye: 1");
        if (realFile.isDirectory()) {
            Log.e(TAG, "getFilesye: 2");
            File[] subfiles = realFile.listFiles();
            for (File file : subfiles) {
                if (file.isDirectory()) {
                    Log.e(TAG, "getFilesye: 3");
                    getFilesye(file.getAbsolutePath(), files);
                } else {
                    Log.e(TAG, "getFilesye: 4");
                    files.add(file);
                }
            }
        }
        return files;
    }

    /**
     * 格式化取当前时间
     *
     * @return
     */
    public static String getThisDateTime(long l) {
        return new SimpleDateFormat("yyyy-MM-dd").format(l);
    }


    /**
     * 检测内存大小
     *
     * @return 返回为MB
     */
    public static long getFreeSpace(String path) {
        StatFs stat = new StatFs(path);
        long blockSize = stat.getBlockSizeLong();
        long availableBlocks = stat.getAvailableBlocksLong();
        return availableBlocks * blockSize / 1000000;
    }

    /**
     * 获取指定文件夹下所有视频文件
     *
     * @param context
     * @param fileAbsolutePath
     * @return
     */
    public static List<VideoInfo> getVideo(Context context, String fileAbsolutePath) {
        ArrayList<VideoInfo> list = new ArrayList<>();
        File file = new File(fileAbsolutePath);
        if (!file.exists()) {
            Toast.makeText(context, "文件夹不存在", Toast.LENGTH_SHORT).show();
            return null;
        }
        File[] subFile = file.listFiles();
        for (int i = 0; i < subFile.length; i++) {
            VideoInfo info = new VideoInfo(); //必须放在for循环里面，不然会显示几个一样的
            // 判断是否为文件夹
            if (!subFile[i].isDirectory()) {
                String filename = subFile[i].getName();
                Log.d(TAG, filename);
                // 判断是否为MP4结尾
                if (filename.trim().toLowerCase().endsWith(".mp4") || filename.trim().toLowerCase().endsWith(".3gp") ||
                        filename.trim().toLowerCase().endsWith(".avi") || filename.trim().toLowerCase().endsWith(".flv")) {
                    Log.e(TAG, "VideoInfo: videoName:" + subFile[i].getName() + "videoPath:" + subFile[i].getPath() + "videoTime" + getVideoDuration(subFile[i].getPath()));
                    // 设置文件路径
                    info.setPath(subFile[i].getPath());
                    Log.e(TAG, "videoPath" + subFile[i].getPath());

                    // 设置视频名称
                    info.setName(subFile[i].getName());
                    Log.e(TAG, "videoName" + subFile[i].getName());

                    //设置文件时长
                    info.setDuration(getVideoDuration(subFile[i].getPath()));
                    Log.d(TAG, "videoTime" + subFile[i].getPath());

                    //根据路径获得视频缩略图
                    info.setCover(getVideoCover(subFile[i].getPath()));
                    list.add(info);
                    //onCreate: 2...Health20211229083327complete.mp4
                }
            }
        }
        return list;
    }

    /**
     * 根据视频长度格式化时间
     *
     * @param path
     * @return
     */
    public static String getVideoDuration(String path) {
        int seconds = 0;
        String standardTime;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            FileInputStream inputStream = new FileInputStream(new File(path).getAbsolutePath());
            mediaMetadataRetriever.setDataSource(inputStream.getFD());
            seconds = Integer.parseInt(mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)) / 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (seconds <= 0) {
            standardTime = "00:00";
        } else if (seconds < 60) {
            standardTime = String.format(Locale.getDefault(), "00:%02d", seconds % 60);
        } else if (seconds < 3600) {
            standardTime = String.format(Locale.getDefault(), "%02d:%02d", seconds / 60, seconds % 60);
        } else {
            standardTime = String.format(Locale.getDefault(), "%02d:%02d:%02d", seconds / 3600, seconds % 3600 / 60, seconds % 60);
        }
        mediaMetadataRetriever.release();
        return standardTime;
    }

    /**
     * 根据路径获取图片
     *
     * @param imagePath
     * @return
     */
    public Bitmap getImage(String imagePath) {
        return BitmapFactory.decodeFile(imagePath);
    }

    /**
     * 获取视频缩略图
     *
     * @param filePath
     * @return
     */
    public static Bitmap getVideoCover(String filePath) {
        Bitmap b = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            FileInputStream inputStream = new FileInputStream(new File(filePath).getAbsolutePath());
            retriever.setDataSource(inputStream.getFD());
            b = retriever.getFrameAtTime();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                retriever.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return b;
    }

    /**
     * 获取目标目录
     *
     * @param usbPath  USB根路径
     * @param srcPath  复制文件的路径
     * @param destPath 目标根路径
     * @return
     */
    public static String getTargetDirectory(String usbPath, String srcPath, String destPath) {
        String targetDir = null;
        StringBuilder splicingStr = null;
        try {
            Log.e(TAG, "getTargetDirectory: usbPath--" + usbPath + ",  srcPath--" + srcPath + ", destPath--" + destPath);
            int length = usbPath.length();
            String string = srcPath.substring(length + 1);
            Log.e(TAG, "getTargetDirectory: 截取的路径--" + string);
            String[] split = string.split("/");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < split.length; i++) {
                Log.e(TAG, "getTargetDirectory: 分割的--" + split[i]);
                if (i <= 2) {
                    splicingStr = stringBuilder.append("/" + split[i]);
                    Log.e(TAG, "getTargetDirectory: 拼接的第-" + i + "-个，结果是--" + splicingStr.toString());
                }
            }
            String s = splicingStr.toString();
            Log.e(TAG, "getTargetDirectory: 拼接完成--" + s);
            targetDir = destPath + s;
            Log.e(TAG, "getTargetDirectory: 组成目录为--" + targetDir);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return targetDir;
    }

    /**
     * 获取目标目录
     *
     * @param usbPath  USB根路径
     * @param srcPath  复制文件的路径
     * @param destPath 目标根路径
     * @return
     */
    public static String getTargetDirectory2(String usbPath, String srcPath, String destPath) {
        Log.e(TAG, "getTargetDirectory: usbPath--" + usbPath + ",  srcPath--" + srcPath + ", destPath--" + destPath);
        int length = usbPath.length();
        String string = srcPath.substring(length + 1);
        String dirName = FileUtil.getDirName(string);
        String targetDirs = string.substring(0, string.length() - (dirName.length() + 1));
        Log.e(TAG, "getTargetDirectory: 截掉剩余的--" + targetDirs);
        String targetDir = destPath + File.separator + targetDirs;
        Log.e(TAG, "getTargetDirectory: 组成目录为--" + targetDir);
        return targetDir;
    }


    /**
     * 根据文件后缀名获得对应的MIME类型
     *
     * @param file 文件对象
     */
    public static String getMIMEType(File file) {
        String type = "*/*";
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf("."); // 获取后缀名前的分隔符"."在fileName中的位置
        if (dotIndex < 0) {
            return type;
        }

        String end = fileName.substring(dotIndex, fileName.length()).toLowerCase(Locale.getDefault()); // 获取文件的后缀名
        if (end.length() == 0) {
            return type;
        }

        // 在MIME和文件类型的匹配表中找到对应的MIME类型
        for (int i = 0; i < MIME_MapTable.length; i++) {
            if (end.equals(MIME_MapTable[i][0])) {
                type = MIME_MapTable[i][1];
            }
        }
        return type;
    }

    /**
     * 创建文件
     *
     * @param path     文件所在目录的目录名，如/java/test/0.txt,要在当前目录下创建一个文件名为1.txt的文件，<br>
     *                 则path为/java/test，fileName为1.txt
     * @param fileName 文件名
     * @return 文件新建成功则返回true
     */
    public static boolean createFile(String path, String fileName) {
        File file = new File(path + File.separator + fileName);
        if (file.exists()) {
            Log.w(TAG, "新建文件失败：file.exist()=" + file.exists());
            return false;
        } else {
            try {
                boolean isCreated = file.createNewFile();
                return isCreated;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 删除单个文件
     *
     * @param file 要删除的文件对象
     * @return 文件删除成功则返回true
     */
    public static boolean deleteFile(File file) {
        if (file.exists()) {
            boolean isDeleted = file.delete();
            Log.w(TAG, file.getName() + "删除结果：" + isDeleted);
            return isDeleted;
        } else {
            Log.w(TAG, "文件删除失败：文件不存在！");
            return false;
        }
    }

    /**
     * 删除单个文件
     *
     * @param path     文件所在路径名
     * @param fileName 文件名
     * @return 删除成功则返回true
     */
    public static boolean deleteFile(String path, String fileName) {
        File file = new File(path + File.separator + fileName);
        if (file.exists()) {
            boolean isDeleted = file.delete();
            return isDeleted;
        } else {
            return false;
        }
    }

    /**
     * 复制文件
     *
     * @param srcPath 源文件绝对路径
     * @param destDir 目标文件所在目录
     * @return boolean
     */
    public static boolean copyFile(String srcPath, String destDir) {
        boolean flag = false;
        File srcFile = new File(srcPath); // 源文件
        if (!srcFile.exists()) {
            // 源文件不存在
            Log.e(TAG, "源文件不存在");
            return false;
        }
        // 获取待复制文件的文件名
        String fileName = srcPath.substring(srcPath.lastIndexOf(File.separator));
        String destPath = destDir + fileName;
        if (destPath.equals(srcPath)) {
            // 源文件路径和目标文件路径重复
            Log.e(TAG, "源文件路径和目标文件路径重复!");
            return false;
        }
        File destFile = new File(destPath); // 目标文件
        if (destFile.exists() && destFile.isFile()) {
            // 该路径下已经有一个同名文件
            Log.e(TAG, "目标目录下已有同名文件!");
            return false;
        }
        File destFileDir = new File(destDir);
        destFileDir.mkdirs();
        try {
            FileInputStream fis = new FileInputStream(srcPath);
            FileOutputStream fos = new FileOutputStream(destFile);
            byte[] buf = new byte[1024];
            int c;
            while ((c = fis.read(buf)) != -1) {
                fos.write(buf, 0, c);
            }
            fis.close();
            fos.close();

            flag = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (flag) {
            Log.e(TAG, "复制文件成功!");
        }
        return flag;
    }

    /**
     * 根据文件名获得文件的扩展名
     *
     * @param fileName 文件名
     * @return 文件扩展名（不带点）
     */
    public static String getFileSuffix(String fileName) {
        int index = fileName.lastIndexOf(".");
        String suffix = fileName.substring(index + 1, fileName.length());
        return suffix;
    }

    /**
     * 重命名文件
     *
     * @param oldPath 旧文件的绝对路径
     * @param newPath 新文件的绝对路径
     * @return 文件重命名成功则返回true
     */
    public static boolean renameTo(String oldPath, String newPath) {
        if (oldPath.equals(newPath)) {
            Log.w(TAG, "文件重命名失败：新旧文件名绝对路径相同！");
            return false;
        }
        File oldFile = new File(oldPath);
        File newFile = new File(newPath);

        boolean isSuccess = oldFile.renameTo(newFile);
        Log.w(TAG, "文件重命名是否成功：" + isSuccess);
        return isSuccess;
    }

    /**
     * 重命名文件
     *
     * @param oldFile 旧文件对象
     * @param newFile 新文件对象
     * @return 文件重命名成功则返回true
     */
    public static boolean renameTo(File oldFile, File newFile) {
        if (oldFile.equals(newFile)) {
            Log.w(TAG, "文件重命名失败：旧文件对象和新文件对象相同！");
            return false;
        }
        boolean isSuccess = oldFile.renameTo(newFile);
        Log.w(TAG, "文件重命名是否成功：" + isSuccess);
        return isSuccess;
    }

    /**
     * 重命名文件
     *
     * @param oldFile 旧文件对象，File类型
     * @param newName 新文件的文件名，String类型
     * @return 重命名成功则返回true
     */
    public static boolean renameTo(File oldFile, String newName) {
        File newFile = new File(oldFile.getParentFile() + File.separator + newName);
        boolean flag = oldFile.renameTo(newFile);
        System.out.println(flag);
        return flag;
    }

    /**
     * 计算某个文件的大小
     *
     * @param file 文件对象
     * @return 文件大小，如果file不是文件，则返回-1
     */
    public static long getFileSize(File file) {
        if (file.isFile()) {
            return file.length();
        } else {
            return -1;
        }
    }

    /**
     * 计算某个文件的大小
     *
     * @param path 文件的绝对路径
     * @return
     */
    public static long getFileSize(String path) {
        File file = new File(path);
        long size = file.length();
        return size;
    }

    /**
     * 文件大小的格式化
     *
     * @param size 文件大小，单位为byte
     * @return 文件大小格式化后的文本
     */
    public static String formatSize(long size) {
        DecimalFormat df = new DecimalFormat("####.00");
        if (size < 1024) // 小于1KB
        {
            return size + "Byte";
        } else if (size < 1024 * 1024) // 小于1MB
        {
            float kSize = size / 1024f;
            return df.format(kSize) + "KB";
        } else if (size < 1024 * 1024 * 1024) // 小于1GB
        {
            float mSize = size / 1024f / 1024f;
            return df.format(mSize) + "MB";
        } else if (size < 1024L * 1024L * 1024L * 1024L) // 小于1TB
        {
            float gSize = size / 1024f / 1024f / 1024f;
            return df.format(gSize) + "GB";
        } else {
            return "size: error";
        }
    }

    /**
     * 格式化文件最后修改时间字符串
     *
     * @param time
     * @return
     */
    public static String formatTime(long time) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss", Locale.getDefault());
        String formatedTime = sdf.format(date);
        return formatedTime;
    }

    /**
     * 获取某个路径下的文件列表
     *
     * @param path 文件路径
     * @return 文件列表File[] files
     */
    public static File[] getFileList(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                return files;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 获取某个目录下的文件列表
     *
     * @param directory 目录
     * @return 文件列表File[] files
     */
    public static File[] getFileList(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            return files;
        } else {
            return null;
        }
    }

    /**
     * 获得根目录文件列表
     *
     * @param showHidden
     * @param
     * @param showHidden 是否显示隐藏文件
     * @return
     */
    public static List<File> getSDCardFileList(boolean showHidden) {
        List<File> list = new ArrayList<>();
        File files[];
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File extDir = Environment.getExternalStorageDirectory();
            files = extDir.listFiles();
            for (File file : files) {
                list.add(file);
            }
            if (showHidden) {
                //
            } else {
                for (int i = 0; i < list.size(); i++) {
                    File file = list.get(i);
                    if (file.isHidden() || file.getName().startsWith(".")) {
                        list.remove(file);
                    }
                }
            }
        } else {
            Log.e(TAG, "SD卡未挂载！");
        }
        return list;
    }

    /**
     * 新建目录
     *
     * @param path 目录的绝对路径
     * @return 创建成功则返回true
     */
    public static boolean createFolder(String path) {
        File file = new File(path);
        boolean isCreated = file.mkdir();
        return isCreated;
    }

    /**
     * 新建目录
     *
     * @param file
     * @return
     */
    public static boolean createFolder(File file) {
        boolean isCreated = file.mkdir();
        return isCreated;
    }

    /**
     * 删除文件夹及其包含的所有文件
     *
     * @param file
     * @return
     */
    public static boolean deleteFolder(File file) {
        boolean flag = false;
        File files[] = file.listFiles();
        if (files != null && files.length >= 0) // 目录下存在文件列表
        {
            for (int i = 0; i < files.length; i++) {
                File f = files[i];
                if (f.isFile()) {
                    // 删除子文件
                    flag = deleteFile(f);
                    if (flag == false) {
                        return flag;
                    }
                } else {
                    // 删除子目录
                    flag = deleteFolder(f);
                    if (flag == false) {
                        return flag;
                    }
                }
            }
        }
        flag = file.delete();
        if (flag == false) {
            return flag;
        } else {
            return true;
        }
    }

    /**
     * 复制目录
     *
     * @param srcPath 源文件夹路径
     * @param destDir 目标文件夹所在目录
     * @return 复制成功则返回true
     */
    public static boolean copyFolder(String srcPath, String destDir) {
        Log.e(TAG, "复制文件夹开始!");
        boolean flag = false;

        File srcFile = new File(srcPath);
        if (!srcFile.exists()) {
            // 源文件夹不存在
            Log.e(TAG, "源文件夹不存在");
            return false;
        }
        String dirName = getDirName(srcPath); // 获得待复制的文件夹的名字，比如待复制的文件夹为"E://dir"则获取的名字为"dir"

        String destPath = destDir + File.separator + dirName; // 目标文件夹的完整路径
        //Log.e("目标文件夹的完整路径为：" + destPath);
        if (destPath.equals(srcPath)) {
            Log.e(TAG, "目标文件夹与源文件夹重复");
            return false;
        }
        File destDirFile = new File(destPath);
        if (destDirFile.exists()) {
            // 目标位置有一个同名文件夹
            Log.e(TAG, "目标位置已有同名文件夹!");
            return false;
        }
        destDirFile.mkdirs(); // 生成目录

        File[] files = srcFile.listFiles(); // 获取源文件夹下的子文件和子文件夹
        if (files.length == 0) {
            // 如果源文件夹为空目录则直接设置flag为true，这一步非常隐蔽，debug了很久
            flag = true;
        } else {
            for (File temp : files) {
                if (temp.isFile()) {
                    // 文件
                    flag = copyFile(temp.getAbsolutePath(), destPath);
                } else if (temp.isDirectory()) {
                    // 文件夹
                    flag = copyFolder(temp.getAbsolutePath(), destPath);
                }
                if (!flag) {
                    break;
                }
            }
        }
        if (flag) {
            Log.e(TAG, "复制文件夹成功!");
        }
        return flag;
    }

    /**
     * 获取待复制文件夹的文件夹名
     *
     * @param dir
     * @return String
     */
    public static String getDirName(String dir) {
        if (dir.endsWith(File.separator)) {
            // 如果文件夹路径以"//"结尾，则先去除末尾的"//"
            dir = dir.substring(0, dir.lastIndexOf(File.separator));
        }
        return dir.substring(dir.lastIndexOf(File.separator) + 1);
    }

    /**
     * 计算某个目录包含的文件数量
     *
     * @param directory
     * @return
     */
    public static int getFileCount(File directory) {
        File[] files = directory.listFiles();
        int count = files.length;
        return count;
    }

    /**
     * 计算某个路径下所包含的文件数量
     *
     * @param path
     * @return
     */
    public static int getFileCount(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        int count = files.length;
        return count;
    }

    /**
     * 计算某个目录的大小
     *
     * @param directory
     * @return
     */
    public static long getFolderSize(File directory) {
        File[] files = directory.listFiles();
        if (files != null && files.length >= 0) {
            long size = 0;
            for (File f : files) {
                if (f.isFile()) {
                    // 获得子文件的大小
                    size = size + getFileSize(f);
                } else {
                    // 获得子目录的大小
                    size = size + getFolderSize(f);
                }
            }
            return size;
        }
        return -1;
    }

    /**
     * 获得某个文件或目录的大小
     *
     * @param file
     * @return
     */
    public static long getFileOrFolderSize(File file) {
        long size = 0;
        if (file.isDirectory()) {
            size = getFolderSize(file);
        } else {
            size = getFileSize(file);
        }
        return size;
    }
}