package Lesson_6;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Repeats {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        int maxSize = 2;
        list.add("0");
        list.add("3");
        list.add("2");
        list.add("1");
        list.add("4");
        list.add("6");
        list.add("5");

        List<String> list2 = list.stream().sorted().collect(Collectors.toList());
        System.out.println(list2);
        int size = list2.size();

        for (int i = 1; i < size; i++) {
            if (list2.size() > maxSize) {
                list2.removeFirst();
            }
        }
        System.out.println(list2);


    }
}
