package testdoubles;

import salad.Salad;
import vegetables.Vegetable;

import java.util.ArrayList;
import java.util.List;

public class TestSalad extends Salad {

    public boolean sortCalled = false;
    public double caloriesToReturn = 0;
    public double min, max;
    public boolean findCalled = false;

    private final List<Vegetable> vegetables = new ArrayList<>();

    public void add(Vegetable v) {
        vegetables.add(v);
    }

    @Override
    public double getTotalCalories() {
        return caloriesToReturn;
    }

    @Override
    public void sortByCalories() {
        sortCalled = true;
    }

    @Override
    public List<Vegetable> getVegetables() {
        return vegetables;
    }

    @Override
    public void remove(int index) {
        vegetables.remove(index);
    }

    @Override
    public List<Vegetable> findByCalories(double min, double max) {
        this.min = min;
        this.max = max;
        this.findCalled = true;
        return new ArrayList<>(vegetables);
    }
}
