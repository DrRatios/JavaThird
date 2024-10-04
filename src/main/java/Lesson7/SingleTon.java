package Lesson7;

public class SingleTon {
    static SingleTon instance;
    private SingleTon() {

    }
    public static SingleTon getInstance() {
        if (instance == null) {
            instance = new SingleTon();
        }
        return instance;
    }
}
