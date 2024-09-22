package Lesson_3;

import java.io.*;

public class DataStreamApp {
    public static void main(String[] args) {
        File file = new File("demo.txt");
        try(DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file))) {
            dataOutputStream.writeUTF("WriteUTF");
            dataOutputStream.writeInt(42);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
