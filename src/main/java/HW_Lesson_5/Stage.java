package HW_Lesson_5;

public abstract class Stage {

    protected int length;
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract void go(Car c) ;
}

