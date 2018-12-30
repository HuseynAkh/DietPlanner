import java.util.ArrayList;

public class Reader {

    APIConnector api = new APIConnector();
    ArrayList<Food> foodList = new ArrayList<Food>();

    public void findDish(String name) {
        System.out.println(name);
        api.getDish(name);
        
        for (int i = 0; i < api.json.getJSONArray("hits").length(); i++) {
            foodList.add(new Food());
            foodList.get(i).setLabel(((String.valueOf(api.json.getJSONArray("hits").getJSONObject(i).getJSONObject("recipe").get("label")))));
            foodList.get(i).setCalories(Double.parseDouble(String.valueOf(api.json.getJSONArray("hits").getJSONObject(i).getJSONObject("recipe").getJSONObject("totalNutrients").getJSONObject("ENERC_KCAL").getDouble("quantity"))));
            foodList.get(i).setFat(Double.parseDouble(String.valueOf(api.json.getJSONArray("hits").getJSONObject(i).getJSONObject("recipe").getJSONObject("totalNutrients").getJSONObject("FAT").getDouble("quantity"))));
            foodList.get(i).setCarb(Double.parseDouble(String.valueOf(api.json.getJSONArray("hits").getJSONObject(i).getJSONObject("recipe").getJSONObject("totalNutrients").getJSONObject("CHOCDF").getDouble("quantity"))));
            foodList.get(i).setProtein(Double.parseDouble(String.valueOf(api.json.getJSONArray("hits").getJSONObject(i).getJSONObject("recipe").getJSONObject("totalNutrients").getJSONObject("PROCNT").getDouble("quantity"))));
            foodList.get(i).setWeight(Double.parseDouble(String.valueOf(api.json.getJSONArray("hits").getJSONObject(i).getJSONObject("recipe").getDouble("totalWeight"))));
            System.out.println(foodList.get(i).getCalories());

        }

    }
}