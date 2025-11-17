package salad;

import vegetables.Vegetable;
import java.util.*;

public class Salad {

    private List<Vegetable> vegetables = new ArrayList<>();

    public void add(Vegetable v) { vegetables.add(v); }

    public List<Vegetable> getVegetables() { return vegetables; }

//    public int getsize() {
//        int size = vegetables.size();
//        return size;
//    }

    public void remove(int index) {

            vegetables.remove(index);
    }

    public double getTotalCalories() {
        return vegetables.stream().mapToDouble(Vegetable::getTotalCalories).sum();
    }

    public void sortByCalories() {
        vegetables.sort(Comparator.comparing(Vegetable::getTotalCalories));
    }

    public List<Vegetable> findByCalories(double min, double max) {
        List<Vegetable> res = new ArrayList<>();
        for (Vegetable v : vegetables) {
            double cal = v.getTotalCalories();
            if (cal >= min && cal <= max) res.add(v);
        }
        return res;
    }
}
