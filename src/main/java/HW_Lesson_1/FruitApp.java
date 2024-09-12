package HW_Lesson_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitApp {
    public static void main(String[] args) {
        Apple [] apples = new Apple[]{new Apple(),new Apple(),
                new Apple(),new Apple(),new Apple()};

        Fruit [] oranges = new Orange[]{new Orange(),new Orange()
                ,new Orange(),new Orange(),new Orange()};

        FruitBox<Fruit> orangeBox = new FruitBox<>(new ArrayList<>());
        FruitBox<Fruit> appleBox = new FruitBox<>(new ArrayList<>());
        orangeBox.getFRUITS().addAll(List.of(oranges));
        appleBox.getFRUITS().addAll(List.of(apples));
        System.out.println(orangeBox);
        System.out.println(appleBox);

        System.out.println(appleBox.getWeight());
        orangeBox.showType();



    }
}
