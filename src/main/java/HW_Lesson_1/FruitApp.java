package HW_Lesson_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitApp {
    public static void main(String[] args) {
        Apple[] apples = new Apple[]{new Apple(), new Apple(),
                new Apple(), new Apple(), new Apple(), new Apple(), new Apple(),
                new Apple(), new Apple(), new Apple(), new Apple(), new Apple(),
                new Apple(), new Apple(), new Apple()};

        Fruit[] oranges = new Orange[]{new Orange(), new Orange()
                , new Orange(), new Orange(), new Orange(), new Orange(), new Orange()
                , new Orange(), new Orange(),new Orange()};

        FruitBox<Fruit> orangeBox = new FruitBox<>(new ArrayList<>());
        FruitBox<Fruit> orangeBox2 = new FruitBox<>(new ArrayList<>());
        FruitBox<Fruit> orangeBox3 = new FruitBox<>(new ArrayList<>());
        FruitBox<Fruit> appleBox = new FruitBox<>(new ArrayList<>());
        FruitBox<Fruit> appleBox2 = new FruitBox<>(new ArrayList<>());
        FruitBox<Fruit> appleBox3 = new FruitBox<>(new ArrayList<>());

        appleBox.getFRUITS().addAll(List.of(apples));
        appleBox2.getFRUITS().addAll(List.of(apples));
        appleBox3.getFRUITS().addAll(List.of(apples));
        orangeBox.getFRUITS().addAll(List.of(oranges));
        orangeBox2.getFRUITS().addAll(List.of(oranges));
        orangeBox3.getFRUITS().addAll(List.of(oranges));

        System.out.println("До переброса фруктов\n");

        System.out.println(appleBox);
        System.out.println(appleBox2);
        System.out.println(appleBox3);

        System.out.println(orangeBox);
        System.out.println(orangeBox2);
        System.out.println(orangeBox3);


//        orangeBox.changeFruitsFromBoxes(orangeBox2);
//        appleBox.changeFruitsFromBoxes(appleBox2);


        System.out.println();
//        orangeBox.showType();
//
        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());

//        System.out.println(appleBox.compare(orangeBox));

        System.out.println("После переброса фруктов");
        appleBox3.changeFruitsFromBoxes(orangeBox3);

        System.out.println(appleBox);
        System.out.println(appleBox2);
        System.out.println(appleBox3);

        System.out.println(orangeBox);
        System.out.println(orangeBox2);
        System.out.println(orangeBox3);


    }



}
