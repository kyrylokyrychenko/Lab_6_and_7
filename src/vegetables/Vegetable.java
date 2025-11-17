package vegetables;

public abstract class Vegetable {
    private String name;
    private double weight;    // г
    private double calories;  // ккал на 100г

    public Vegetable(String name, double weight, double calories) {
        this.name = name;
        this.weight = weight;
        this.calories = calories;
    }

    public double getTotalCalories() {
        return (weight / 100.0) * calories;
    }

    public String getName() { return name; }
    public double getWeight() { return weight; }
    public double getCalories() { return calories; }

    public void setWeight(double weight) { this.weight = weight; }

    @Override
    public String toString() {
        return name + " (" + weight + " г, " + calories + " ккал/100г)";
    }
}

