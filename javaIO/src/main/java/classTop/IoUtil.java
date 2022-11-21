package classTop;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class IoUtil {

    private static String path="/usr/local/src/project/MyApplication2/app/src/main/java/com/example/myapplication2/io/soutfile";

    /**
     *
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
     *
     * @param i
     * @return
     */
    public static String intToString(int i) {
        return String.valueOf(i);
    }

    /**
     *
     * @param filePath
     * @param t
     * @return
     */
    public static  boolean writeFile(String filePath, String t) {
        try {
            BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream( filePath)));
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
     *
     * @param filePath
     * @param s
     * @return
     */
    public static boolean writeInputStream(String filePath,String s){
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
     *
     * @param olePath
     * @param newFile
     * @return
     */
    public static boolean copyOldToNew(String olePath,String newFile){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(olePath));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile));
            char[] chars = new char[1024];
            while (bufferedReader.read(chars)!=-1){
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

    public static void main(String[] args) {
//        String o = readFile(path+"/oooo.txt");
//        System.out.println(o);

//        System.out.println(writeFile(path+"/xxxx.txt", "2232323"));
//        System.out.println(writeInputStream(path + "/xxxx.txt","wertyu9odfjfvusahndvr8e73q4enfudhcvquievcndvadfvwdfjvaionviqwfdivndfjvans"));

        copyOldToNew(path+"/xxxx.txt",path+"/oooo.txt");
    }
}
