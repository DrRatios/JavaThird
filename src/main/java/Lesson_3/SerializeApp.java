package Lesson_3;

import java.io.*;
import java.util.Arrays;

public class SerializeApp {
    public static void main(String[] args) {

        File file = new File("demo.txt");
        Bike bike = new Bike("Java");
        bike.setSerialNo("11111111111");

        System.out.println("Наш велосипед " + bike);
        byte[] bytes = null;

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {

            objectOutputStream.writeObject(bike);
            bytes = byteArrayOutputStream.toByteArray();
            System.out.println("Наш сериализованный велосипед " + Arrays.toString(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
             ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            Bike deSerializedBike = (Bike) objectInputStream.readObject();
            System.out.println("Велосипед, считанный из файла " + deSerializedBike);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
