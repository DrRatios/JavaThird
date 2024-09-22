package HW_Lesson_1;

public class Orange extends Fruit {
    public static final int WEIGHT = 3;
    public static final String NAME = "Orange";

    public Orange() {
    }

    public int getWEIGHT() {
        return WEIGHT;
    }

    @Override
    public String toString() {
        return "Orange{" +
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
