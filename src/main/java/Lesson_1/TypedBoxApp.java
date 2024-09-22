package Lesson_1;

public class TypedBoxApp {

    // T - type
    // E - element
    // V - value
    // K - key
    // S, U, V неважно какую букву использовать
    public static void main(String[] args) {
        TypedBox<Integer> tbox1 = new TypedBox<>(42);
        TypedBox<Integer> tbox2 = new TypedBox<>(195);

        int sum = tbox1.getObject()+tbox2.getObject();
        System.out.println(sum);

        TypedBox<String> stringTypedBox = new TypedBox<>("195");
        tbox1.showType();
        stringTypedBox.showType();
        TypedBox<SimpleBox> simpleBoxTypedBox = new TypedBox<>(new SimpleBox(42));

        TwoTypedBox<Integer,String> twoTypedBox = new TwoTypedBox<>(42,"195");
        TwoTypedBox<Integer,Integer> twoTypedBox2 = new TwoTypedBox<>(42,195);
        twoTypedBox.showTypes();
        System.out.println("");
        twoTypedBox2.showTypes();
    }
}
