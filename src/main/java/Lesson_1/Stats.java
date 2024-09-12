package Lesson_1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

// можно экстендиться классами и интерфейсами, класс экстендится ранее интерфейсов!

public class Stats<T extends Number & Serializable> {
    private static final double EPSILON = 0.00001;
    private final T[] numbers;
//    private "static" final T x; так делать нельзя

    public Stats(T... numbers) {
        this.numbers = numbers;
    }

    double avg() {
        double sum = 0.0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i].doubleValue();
        }
        return sum/numbers.length;
    }
    // ? - Wild Cart, означает, что ожидает на вход один из возможных типов (в данном случае любой тип числа(int,f,d,L))
    public boolean sameAvg(Stats<?> another){

        return Math.abs(this.avg() - another.avg())< EPSILON;
    }
    public List<? extends Number> getElements(){
        return Arrays.asList(numbers);
    }
    //    private "static" T someMethod(){
    //
    //    }; так делать нельзя

    // T t = new T(); так делать нельзя

    //PECS - Producer Extends Consumer Super


}
