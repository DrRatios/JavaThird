package Lesson_1;

public class SimpleApp {
    public static void main(String[] args) {
        //попробуем сложить в коробку числа, потом сложить эти числа
        SimpleBox box1 = new SimpleBox(42);
        SimpleBox box2 = new SimpleBox(195);
        SimpleBox box3 = new SimpleBox("195");
        int sum = (Integer) box1.getObject() + (Integer) box2.getObject();
        System.out.println(sum);

        try {
            int sum2 = (Integer) box1.getObject() + (Integer) box3.getObject();
            System.out.println(sum2);
        }catch (ClassCastException e){
            System.out.println("Один из объектов не инт");
        }
        if (box1.getObject() instanceof Integer && box3.getObject() instanceof Integer){
            int sum2 = (Integer) box1.getObject() + (Integer) box3.getObject();
            System.out.println(sum2);
        } else {
            System.out.println("Один из объектов не инт");
        }


    }
}
