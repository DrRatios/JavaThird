package Lesson7;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectionFieldsAndConstructors {

    public static void main(String[] args) {
        Class clazz = TestClass.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getType().getSimpleName() + " " + field.getName());
        }

        try {
            Field field = clazz.getField("name");
            System.out.println(field.getType().getSimpleName()+ " " + field.getName());
        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }

        System.out.println("---------------------------------------");


        try {
            TestClass test = new TestClass();
            System.out.println(test);
            Field field = clazz.getField("number");
            field.set(test,11);
            System.out.println(test);
            System.out.println(field.get(test));

            Field privateField = clazz.getDeclaredField("privateString");
            privateField.setAccessible(true);
            privateField.set(test,"private");

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Constructor[] constructors = clazz.getDeclaredConstructors();

        for(Constructor constructor: constructors){
            System.out.println(constructor);
        }

        try {
            Constructor constructor = clazz.getDeclaredConstructor(new Class[]{String.class, int.class});
            constructor.setAccessible(true);
            TestClass tc = (TestClass) constructor.newInstance("String", 5);
            // Field получаем по имени переменных, Конструктор по типу переменных
            System.out.println(constructor);
            System.out.println(tc);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
