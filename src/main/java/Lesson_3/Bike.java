package Lesson_3;

import java.io.Serializable;

public class Bike implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String serialNo;

    public Bike(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "name='" + name + '\'' +
                ", serialNo='" + serialNo + '\'' +
                '}';
    }
}
