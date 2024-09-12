package HW_Lesson_1;

public class Orange extends Fruit {
    public final int WEIGHT = 3;
    private final String NAME = "Orange";

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
}
