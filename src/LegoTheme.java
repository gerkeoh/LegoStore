import java.util.ArrayList;
import java.util.List;

public class LegoTheme {
    private String name;
    private List<LegoSet> sets;

    public LegoTheme(String name) {
        this.name = name;
        this.sets = new ArrayList<>();
    }

    public void addSet(LegoSet legoSet) {
        sets.add(legoSet);
    }

    public String getName() {
        return name;
    }

    public List<LegoSet> getSets() {
        return sets;
    }
}