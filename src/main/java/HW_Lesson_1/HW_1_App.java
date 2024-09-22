package HW_Lesson_1;

import java.util.List;

public class HW_1_App {
    public static void main(String[] args) {

        TypedBox <String> typedBox = new TypedBox<>("Ambush","Baby","Calm","Double","Ensure");

        String[] strings = new String[]{"Ambush","Baby","Calm","Double","Ensure"};

        System.out.println("До смены элементов массива строк\n");

        typedBox.showType();
        System.out.println(typedBox);
        System.out.println("");

        System.out.println("После смены элементов массива строк\n");

        typedBox.changeIndex(1,4);
        typedBox.showType();
        System.out.println(typedBox);

        System.out.println("");
        System.out.println("После приведения массива к ArrayList\n");

        typedBox.asArrayList();


    }
    public void changeMass(String[] z,int x, int y){
        if (x<z.length && x>=0 && y<z.length && y>=0){
            for (int i =0;i<z.length;i++){
                z[x] = z[y];
            }
        } else{
            System.out.println("Номер индекса не входит в длину массива");
        }
    }
}
