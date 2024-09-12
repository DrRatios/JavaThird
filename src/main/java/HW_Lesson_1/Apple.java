package HW_Lesson_1;

public class Apple extends Fruit {
    public final int WEIGHT = 2;
    private final String NAME = "Apple";

    public Apple() {
    }

    public int getWEIGHT() {
        return WEIGHT;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + WEIGHT +
                '}';
    }
}
