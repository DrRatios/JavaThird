package Lesson_3;

import java.io.File;
import java.io.IOException;

public class DemoApp {
    public static void main(String[] args) throws IOException {
        File directory = new File("fileDir");
        if (!directory.exists()) {
            directory.mkdir();
        }
        File file = new File(directory,"demo.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        System.out.println(file.getName());
        System.out.println(file.getAbsoluteFile().getName());
        System.out.println(file.getAbsolutePath());

        System.out.println(file.getParent());

        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.length());

    }
}
