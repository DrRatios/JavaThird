package HW_Lesson_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Race {
    private List<Stage> stages;
    private ArrayList<Stage> x;

    public List<Stage> getStages() {
        return stages;
    }

    public Race(Stage... stages) {
        this.stages = Collections.synchronizedList(new ArrayList<>(Arrays.asList(stages)));
    }


}
