package Lesson_1;

public class TwoTypedBox <T, U> {
    private T first;
    private U second;

    public TwoTypedBox(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }
    public void showTypes(){
        System.out.println("Type of T: " + first.getClass().getName());
        System.out.println("Type of U: " + second.getClass().getName());
    }
}
