public class Food {

    private float initialCalories;
    private float multiplierCalories;

    public float getMultiplierCalories() {
        return multiplierCalories;
    }

    public void setMultiplierCalories(float multiplierCalories) {
        this.multiplierCalories = multiplierCalories;
    }

    public float getInitialCalories() {
        return initialCalories;
    }

    public void setInitialCalories(float initialcalories) {
        this.initialCalories = initialcalories;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getCarb() {
        return carb;
    }

    public void setCarb(float carb) {
        this.carb = carb;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    private String label;
    private float weight;
    private float carb;
    private float fat;
    private float protein;

    public float getYield() {
        return yield;
    }

    public void setYield(float yield) {
        this.yield = yield;
    }


    private float yield;



}