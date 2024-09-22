package HW_Lesson_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitBox<T extends Fruit> {
    private final ArrayList<T> FRUITS;


    public FruitBox(ArrayList<T> FRUITS) {
        this.FRUITS = FRUITS;
    }

    public ArrayList<T> getFRUITS() {
        return FRUITS;
    }

    @Override
    public String toString() {
        return "FruitBox{" +
                "FRUITS=" + FRUITS +
                '}';
    }

    public void showType() {
        System.out.println("FruitBox type is: " + this.getFRUITS().getClass().getName() + "contains Fruit - " + this.getFRUITS().getFirst().getClass().getName());
    }
    
    public boolean addFruitToBox(T x){
        if (x instanceof Apple && (this.getFRUITS().getFirst() instanceof Apple || this.getFRUITS().isEmpty())){
            this.getFRUITS().add(x);
            return true;
        }
        if (x instanceof Orange && (this.getFRUITS().getFirst() instanceof Orange || this.getFRUITS().isEmpty())) {
            this.getFRUITS().add(x);
            return true;
        }
        return false;
    }

    public List<?> getElements() {
        return FRUITS;
    }

    public int getWeight() {
//        if (this.getElements().getFirst().equals(new Apple())) {
        if (this.getFRUITS().getFirst() instanceof Apple) {
            return this.getFRUITS().size() * Apple.WEIGHT;
        }
        return this.getFRUITS().size() * Orange.WEIGHT;
    }

    public boolean compare(FruitBox<Fruit> y) {
        return this.getWeight() == y.getWeight();
    }

    public void changeFruitsFromBoxes(FruitBox<Fruit> y) {
        if (this.getFRUITS().getFirst() instanceof Apple && y.getFRUITS().getFirst() instanceof Apple) {
            y.getFRUITS().addAll(this.FRUITS);
            this.getFRUITS().removeAll(this.FRUITS);
        } else if
        (this.getFRUITS().getFirst() instanceof Orange && y.getFRUITS().getFirst() instanceof Orange) {
            y.getFRUITS().addAll(this.FRUITS);
            this.getFRUITS().removeAll(this.FRUITS);
        } else {
//            System.out.println("Нельзя класть в одну корзину разные фрукты " +this.getElements().getFirst().getClass().getName() + "  " + y.getElements().getFirst().getClass().getName());
            System.out.println("Нельзя класть в одну корзину разные фрукты " + this.getElements().getFirst().getClass().getName() + "  " + y.getElements().getFirst().getClass().getName());
        }
    }
}
