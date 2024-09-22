package HW_Lesson_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TypedBox<T> {
    private T[] object;

    public TypedBox(T... object) {
        this.object = object;
    }

    public T[] getObject() {
        return object;
    }

    public void setObject(T[] object) {
        this.object = object;
    }

    public void showType() {
        System.out.println("TypedBox type is: " + object.getClass().getName());
    }

    @Override
    public String toString() {
        return "TypedBox{" +
                "object=" + Arrays.toString(object) +
                '}';
    }

    public void changeIndex(int x, int y) {
        if (x < this.getObject().length && x >= 0 && y < this.getObject().length && y >= 0) {
            for (int i = 0; i < this.getObject().length; i++) {
                T z = this.getObject()[x];
                this.getObject()[x] = this.getObject()[y];
                this.getObject()[y] = z;
            }
        } else {
            System.out.println("Номер индекса не входит в длину массива");
        }
    }
    public void asArrayList() {
        List<T> list = new ArrayList<>(Arrays.asList(this.getObject()));
        System.out.println(list.getClass().getName() + "\n" + list);

    }
}
