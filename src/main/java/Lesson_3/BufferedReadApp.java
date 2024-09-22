package Lesson_3;

import java.io.*;
import java.util.Arrays;

public class BufferedReadApp {
    public static void main(String[] args) {
        byte[] bytes = new byte[1024*1024];
        Arrays.fill(bytes, (byte)65);

        File file = new File("demo.txt");
        try(FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            for (byte aByte : bytes) {
                bos.write(aByte);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            int x;
            while ((x = bis.read())!=-1){
                System.out.println(x);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
