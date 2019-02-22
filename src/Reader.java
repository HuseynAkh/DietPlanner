import java.util.ArrayList;

public class Reader {


    private APIConnector api = new APIConnector(); //Creates the API for the retrieval of data
    private ArrayList<Food> foodList = new ArrayList<Food>(); //Used to store all the data for each food that was found by the APIConnector



    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    //Searches for the dish in the API and fills in the results into food objects
    public void findDish(String name) {
        api.getDish(name);
        
        for (int i = 0; i < api.getJson().getJSONArray("hits").length(); i++) {
            foodList.add(new Food());
            foodList.get(i).setYield(Float.parseFloat(String.valueOf(api.getJson().getJSONArray("hits").getJSONObject(i).getJSONObject("recipe").get("yield"))));
            double yield = foodList.get(i).getYield();
            foodList.get(i).setLabel(((String.valueOf(api.getJson().getJSONArray("hits").getJSONObject(i).getJSONObject("recipe").get("label")))));
            foodList.get(i).setInitialCalories(Float.parseFloat(String.valueOf(api.getJson().getJSONArray("hits").getJSONObject(i).getJSONObject("recipe").getJSONObject("totalNutrients").getJSONObject("ENERC_KCAL").getDouble("quantity")/yield)));
            foodList.get(i).setFat(Float.parseFloat(String.valueOf(api.getJson().getJSONArray("hits").getJSONObject(i).getJSONObject("recipe").getJSONObject("totalNutrients").getJSONObject("FAT").getDouble("quantity")/yield)));
            foodList.get(i).setCarb(Float.parseFloat(String.valueOf(api.getJson().getJSONArray("hits").getJSONObject(i).getJSONObject("recipe").getJSONObject("totalNutrients").getJSONObject("CHOCDF").getDouble("quantity")/yield)));
            foodList.get(i).setProtein(Float.parseFloat(String.valueOf(api.getJson().getJSONArray("hits").getJSONObject(i).getJSONObject("recipe").getJSONObject("totalNutrients").getJSONObject("PROCNT").getDouble("quantity")/yield)));
            foodList.get(i).setWeight(Float.parseFloat(String.valueOf(api.getJson().getJSONArray("hits").getJSONObject(i).getJSONObject("recipe").getDouble("totalWeight")/yield)));


        }

    }
}