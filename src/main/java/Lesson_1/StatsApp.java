package Lesson_1;

public class StatsApp {
    public static void main(String[] args) {
        Stats<Integer> statsInt = new Stats<>(1,2,3);
        Stats<Integer> statsInt2 = new Stats<>(1,2,3);
        Stats<Integer> statsInt3 = new Stats<>(1,2,3,4,5);
        System.out.println(statsInt.avg());

        Stats<Double> statsDouble = new Stats<>(1.0,2.0,3.0);
        System.out.println(statsDouble.avg());
        Stats<Number> statsNumber = new Stats<>(1,2.0,3.0f,5L);

        System.out.println(statsInt.sameAvg(statsInt2));
        System.out.println(statsInt.sameAvg(statsInt3));
        System.out.println(statsInt.sameAvg((statsDouble)));

        System.out.println(statsNumber.getElements());
    }
}
