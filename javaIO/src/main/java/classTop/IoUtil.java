package classTop;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class IoUtil {

    private static String path = "/usr/local/src/project/MyApplication2/app/src/main/java/com/example/myapplication2/io/soutfile";

    /**
     * @param filePath
     * @return
     */
    public static String readFile(String filePath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
            String i;
            while ((i = bufferedReader.readLine()) != null) {
                return i;
            }
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param i
     * @return
     */
    public static String intToString(int i) {
        return String.valueOf(i);
    }

    /**
     * @param filePath
     * @param t
     * @return
     */
    public static boolean writeFile(String filePath, String t) {
        try {
            BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
            fileWriter.write(t);
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @param filePath
     * @param s
     * @return
     */
    public static boolean writeOutputStream(String filePath, String s) {
        try {
            OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
            bufferedOutputStream.write(s.getBytes(StandardCharsets.UTF_8));
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @param
     * @param filePath
     * @return
     */
    public static byte[] readInputStream(String filePath) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                return bytes;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param filePath
     * @param obj
     * @return
     */
    public static boolean writeObject(String filePath, Object obj) {
        ObjectOutputStream objectOutputStream = null;
        if (obj == null) {
            return false;
        }
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * @param filePath
     * @param <T>
     * @return
     */
    public static <T> T readObject(String filePath) {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
            return (T) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }

    /**
     * @param olePath
     * @param newFile
     * @return
     */
    public static boolean copyOldToNew(String olePath, String newFile) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(olePath));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile));
            char[] chars = new char[1024];
            while (bufferedReader.read(chars) != -1) {
                bufferedWriter.write(chars);
            }
            bufferedWriter.flush();
            bufferedReader.close();
            bufferedWriter.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 速度最快读写方式
     *
     * @param srcPath
     * @param destPath
     * @return
     */
    public boolean channelCopy(String srcPath, String destPath) {
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            if (!srcFile.exists()) {
                // 源文件不存在
                return false;
            }
            if (srcFile.isDirectory() || destFile.isDirectory()) {
                return false;
            }

            FileInputStream fileInputStream = new FileInputStream(srcFile);
            FileOutputStream fileOutputStream = new FileOutputStream(destFile);
            FileChannel inputChannel = fileInputStream.getChannel();
            FileChannel outputChannel = fileOutputStream.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);
            int len;

            while ((len = inputChannel.read(byteBuffer)) != -1) {
                byteBuffer.flip();
                outputChannel.write(byteBuffer);
                byteBuffer.clear();
            }
            inputChannel.close();
            outputChannel.close();
            fileInputStream.close();
            fileOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public static void main(String[] args) {
//        String o = readFile(path+"/oooo.txt");
//        System.out.println(o);

//        System.out.println(writeFile(path+"/xxxx.txt", "2232323"));
//        System.out.println(writeInputStream(path + "/xxxx.txt","wertyu9odfjfvusahndvr8e73q4enfudhcvquievcndvadfvwdfjvaionviqwfdivndfjvans"));

        copyOldToNew(path + "/xxxx.txt", path + "/oooo.txt");
    }
}
