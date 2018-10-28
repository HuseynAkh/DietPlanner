import java.util.ArrayList;

public class Reader {

    APIConnector api = new APIConnector();
    ArrayList<Food> foodList = new ArrayList<Food>();

    public void findDish(String name) {
        System.out.println(name);
        api.getDish(name);
        
        for (int i = 0; i < api.json.getJSONArray("hits").length(); i++) {
            Food food = new Food();
            food.setLabel(((String.valueOf(api.json.getJSONArray("hits").getJSONObject(i).getJSONObject("recipe").get("label")))));
            food.setCalories(Double.parseDouble(String.valueOf(api.json.getJSONArray("hits").getJSONObject(i).getJSONObject("recipe").getJSONObject("totalNutrients").getJSONObject("ENERC_KCAL").getDouble("quantity"))));
            food.setFat(Double.parseDouble(String.valueOf(api.json.getJSONArray("hits").getJSONObject(i).getJSONObject("recipe").getJSONObject("totalNutrients").getJSONObject("FAT").getDouble("quantity"))));
            food.setCarb(Double.parseDouble(String.valueOf(api.json.getJSONArray("hits").getJSONObject(i).getJSONObject("recipe").getJSONObject("totalNutrients").getJSONObject("CHOCDF").getDouble("quantity"))));
            food.setProtein(Double.parseDouble(String.valueOf(api.json.getJSONArray("hits").getJSONObject(i).getJSONObject("recipe").getJSONObject("totalNutrients").getJSONObject("PROCNT").getDouble("quantity"))));
            food.setWeight(Double.parseDouble(String.valueOf(api.json.getJSONArray("hits").getJSONObject(i).getJSONObject("recipe").getDouble("totalWeight"))));
            foodList.add(food);
            System.out.println(foodList.get(i).getCalories());

        }

    }
}