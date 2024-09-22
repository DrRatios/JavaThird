package Lesson_2;

public class Bike {

    private final int id;
    private final String model;
    private final String serialNumber;

    public Bike(int id, String model, String serialNumber) {
        this.id = id;
        this.model = model;
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
