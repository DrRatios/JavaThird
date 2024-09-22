package HW_Lesson_1;

import java.util.Objects;

public class Apple extends Fruit {
    public static final int WEIGHT = 2;
    public static final String NAME = "Apple";

    public Apple() {
    }

    @Override
    public String toString() {
        return  "Apple{" +
                "weight=" + WEIGHT +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }
}
