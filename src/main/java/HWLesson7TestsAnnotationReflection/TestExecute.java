package HWLesson7TestsAnnotationReflection;


import org.apache.logging.log4j.core.tools.picocli.CommandLine;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestExecute {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
            start(TestsForms.class);
    }

    public static void start(Class<?> clazz) {
        try {
            Object object = clazz.newInstance();
            Method[] methods = clazz.getDeclaredMethods();
            Annotation[] annotations = clazz.getDeclaredAnnotations();
            int afterSuiteCounter = 0;
            int beforeSuiteCounter = 0;

            for (Method method : methods) {
                if (method.isAnnotationPresent(BeforeSuite.class)) {
                    beforeSuiteCounter++;
                }
                if (method.isAnnotationPresent(AfterSuite.class)) {
                    afterSuiteCounter++;
                }
            }

            if (beforeSuiteCounter != 1) {
                throw new RuntimeException("Method with annotation @" + BeforeSuite.class.getSimpleName() +" doesn't exist");
            } else if (beforeSuiteCounter > 1) {
                throw new RuntimeException("Method with annotation @" + BeforeSuite.class.getSimpleName() +" must exists once");
            }
            if (afterSuiteCounter != 1) {
                throw new RuntimeException("Method with annotation @" + AfterSuite.class.getSimpleName() +" doesn't exist");
            } else if (beforeSuiteCounter > 1) {
                throw new RuntimeException("Method with annotation @" + AfterSuite.class.getSimpleName() +" must exists once");
            }

            for (Method method : methods) {
                if(method.isAnnotationPresent(BeforeSuite.class)) {
                    method.invoke(object);
                }
            }

            List<Method> methodsList = new ArrayList<>();
            for (Method method : methods) {
                if(method.isAnnotationPresent(Test.class)) {
                    methodsList.add(method);
                }
            }
            methodsList.sort(Comparator.comparing(c->c.getAnnotation(Test.class).value()));

            for (Method method : methodsList) {
                method.invoke(object);
            }

            for (Method method : methods) {
                if(method.isAnnotationPresent(AfterSuite.class)) {
                    method.invoke(object);
                }
            }

        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e){
            e.printStackTrace();
        }

    }


}
