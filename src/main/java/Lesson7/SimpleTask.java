package Lesson7;

public class SimpleTask {

    // выведет максимум из массива. Если максимум отрицательный, то кинет исключение.
    // если массив пустой - тоже исключение


    public static void main(String[] args) {

        if (method1(true) | method2(true)){
            System.out.println("true");
        }
        System.out.println("---------------");
        if (method1(true) || method2(true)){
            System.out.println("true");
        }
        System.out.println("---------------");
        if (method1(false) & method2(true)){
            System.out.println("true");
        }
        System.out.println("---------------");
        if (method1(false) && method2(true)){
            System.out.println("true");
        }

    }

    static boolean method1(boolean bool){
        System.out.println("method 1");
        return bool;
    }
    static boolean method2(boolean bool){
        System.out.println("method 2");
        return bool;
    }

    public int findMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив пустой");
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        if (max < 0) {
            throw new IllegalStateException("Максимальное значение элемента массива отрицательное");
        }
        return max;
    }
}
