package Lesson7;

import Lesson_2.Bike;

import java.lang.reflect.Modifier;

public class SimpleReflectionApp {

    public static void main(String[] args) {

        Class clazz = "String".getClass();
        Class integerClass = Integer.class;
        Class stringClass = String.class;
        Class intClass = int.class;
        Class voidClass = void.class;
        Class arrayInt = int[].class;

        Class sqlClass;
        try {
            sqlClass = Class.forName("org.sqlite.JDBC");
            System.out.println(sqlClass.getSimpleName());
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Class bike = Bike.class;
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());

        int modifiers = clazz.getModifiers();
        if (Modifier.isPublic(modifiers)){
            System.out.println(clazz.getSimpleName() + " is public");
        }
        if (Modifier.isAbstract(modifiers)){
            System.out.println(clazz.getSimpleName() + " is abstract");
        }
        if (Modifier.isFinal(modifiers)){
            System.out.println(clazz.getSimpleName() + " is final");
        }
        Class interfaceClass = TestClass.class;
        Class[] interfaces = interfaceClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface.getSimpleName());
        }

        Class parentClass = TestTestClass.class;
        //Вывод дерева наследования
        while (parentClass != null){
            System.out.println(parentClass.getName());
            parentClass = parentClass.getSuperclass();
        }

    }
}
