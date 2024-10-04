package Lesson_6;

import java.util.*;
import java.util.stream.Collectors;


public class HWLesson6 {
    public static void main(String[] args) {
        System.out.println(afterFourArray(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
        System.out.println(checkArrayContainsOneOrFour(new int[]{1, 2, 3, 3, 2, 3, 3, 1, 7}));
    }

//    public static List<Integer> method(int[] mass) {
//        List<Integer> list = new LinkedList<>();
//        for (int i : mass) {
//            list.add(i);
//        }
//        if (list.isEmpty()) {
//            throw new RuntimeException("Mass is empty");
//        }
//        if (!list.contains(4)) {
//            throw new RuntimeException("Mass doesn't contain 4");
//        }
//        List<Integer> list2 = list.reversed();
//        List<Integer> list3 = new LinkedList<>();
//        for (int i = 0; i < list2.size(); i++) {
//            if (list2.get(i) == 4) {
//                break;
//            }
//            list3.add(list2.get(i));
//        }
//        return list3.reversed();
//    }




    public static List<Integer> afterFourArray(int[] array) {
        List<Integer> listOriginal = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            listOriginal.add(array[i]);
        }

        if (listOriginal.isEmpty()) {
            throw new RuntimeException("Mass is empty");
        }

        if (!listOriginal.contains(4)) {
            throw new RuntimeException("Mass does not contain 4");
        }

        List<Integer> list = new LinkedList<>();
        for (int i : array) {
            list.add(i);
            if (i == 4) {
                list.clear();
            }
        }
        return list;
    }

    public static boolean checkArrayContainsOneOrFour(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list.contains(1) && list.contains(4);
    }
}
