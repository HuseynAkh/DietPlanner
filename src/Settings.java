public class Settings {

    private int height;
    private int weight;
    private enum goal {LOSEMASS, GAINMASS, MAINTAINMASS};
    private enum activityLevel {NONACTIVE, ACTIVE, VERYACTIVE};
    private int age;
    private int days; //to be changed later

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    Counter counter = new Counter();

    public void goalSelect(goal goal){
        if(goal == goal.LOSEMASS) {
            counter.setCalorieRequirement(counter.getCalorieRequirement() - 150); //change the values
        }else if (goal == goal.GAINMASS) {
            counter.setCalorieRequirement(counter.getCalorieRequirement() + 150);
        }else if (goal == goal.MAINTAINMASS) {
            counter.setCalorieRequirement(counter.getCalorieRequirement() + 0);
        }
    }

    public void activityLevel(activityLevel activityLevel){
        if(activityLevel == activityLevel.NONACTIVE) {
            counter.setCalorieRequirement(counter.getCalorieRequirement() - 150); //change the values
        }else if (activityLevel == activityLevel.ACTIVE) {
            counter.setCalorieRequirement(counter.getCalorieRequirement() + 0);
        }else if (activityLevel == activityLevel.VERYACTIVE) {
            counter.setCalorieRequirement(counter.getCalorieRequirement() -150); //
        }
    }

}

