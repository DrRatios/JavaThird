package Lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodReflection {

    public static void main(String[] args) {
        Class clazz = TestClass.class;

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getReturnType() + " " + declaredMethod.getName()
                    +" " + Arrays.toString(declaredMethod.getParameterTypes()));
        }
        try {
            TestClass testClass = new TestClass();
            Method calcMethod = clazz.getDeclaredMethod("calculate", int.class, int.class);
            System.out.println("Method: " + calcMethod.getName());
            calcMethod.setAccessible(true);
            calcMethod.invoke(testClass,5,6);
        } catch (NoSuchMethodException |InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
