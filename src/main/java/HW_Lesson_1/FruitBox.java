package HW_Lesson_1;

import java.io.Serializable;
import java.util.ArrayList;

public class FruitBox <T extends Fruit>{
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
    public void showType(){
        System.out.println("FruitBox type is: " + this.getFRUITS().getClass().getName());
    }

    public int getWeight(){
        return this.getFRUITS().size();
//        if (this.getFRUITS().getFirst().getName().equals("Apple")){
//            return this.getFRUITS().size() * this.getFRUITS().getFirst().getWeight();
//        } else if (this.getFRUITS().getFirst().getName().equals("Orange")){
//            return this.getFRUITS().size() * this.getFRUITS().getFirst().getWeight();
//        }
//        return 0;
    }
}
