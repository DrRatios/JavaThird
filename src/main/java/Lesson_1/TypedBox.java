package Lesson_1;

public class TypedBox <T>{
    private T object;

    public TypedBox(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
    public void showType(){
        System.out.println("TypedBox type is: " + object.getClass().getName());
    }
}
