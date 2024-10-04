package Lesson_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionsApp {

    public static void main(String[] args) {

        List<String> list = Collections.synchronizedList(new ArrayList<>());
        Map<String, String> map = new ConcurrentHashMap<>();
        List<String> list2 = new CopyOnWriteArrayList<>();
    }
}
