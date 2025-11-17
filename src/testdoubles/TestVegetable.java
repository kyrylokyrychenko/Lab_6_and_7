package testdoubles;

import vegetables.Vegetable;

public class TestVegetable extends Vegetable {
    private double weight;
    private double caloriesPer100g;

    public boolean setWeightCalled = false;

    public TestVegetable(double weight, double calories) {
        super("TestVeg", weight, calories);
        this.weight = weight;
        this.caloriesPer100g = calories;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
        this.setWeightCalled = true;
    }
}
