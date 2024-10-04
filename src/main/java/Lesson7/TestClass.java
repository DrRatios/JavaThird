package Lesson7;

import Lesson_2.Bike;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@MarkingAnnotation(5)
public class TestClass implements Serializable, AutoCloseable {
    public String name;
    public int number;
    public Bike bike;
    private String privateString;

    public TestClass(String name) {
        this.name = name;
    }

    private TestClass(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public TestClass(String name, int number, Bike bike, String privateString) {
        this.name = name;
        this.number = number;
        this.bike = bike;
        this.privateString = privateString;
    }

    public TestClass() {
    }

    @MarkingAnnotation(12)
    private int calculate(int a, int b){
        System.out.println("Calculating... ");
        return number;
    }
    @MarkingAnnotation(1)
    public String getPrivateString(){
        return privateString;
    }
    public void info(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", bike=" + bike +
                ", privateString='" + privateString + '\'' +
                '}';
    }

    @Override
    public void close() throws Exception {

    }
}
