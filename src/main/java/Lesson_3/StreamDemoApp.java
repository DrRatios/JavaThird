package Lesson_3;

import java.io.*;

public class StreamDemoApp {
    public static void main(String[] args) {
        String str = "My String";
        try(FileOutputStream fileOutputStream = new FileOutputStream(new File("demo.txt"))){
            fileOutputStream.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(FileInputStream fileInputStream = new FileInputStream("demo.txt")){
            byte[] bytes = new byte[10];
            fileInputStream.read(bytes);
            System.out.println(new String(bytes));
        }catch (IOException e){
            e.printStackTrace();
        }

//        byte[] bytes = {65,66,67};
//
//        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
//        int x;
//        char y;
//        while ((x = bais.read()) != -1) {
//            y = (char) x;
//            System.out.println(x + " " + y);
//
//        }
    }
}
