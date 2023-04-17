package data;
import entity.Restaurant;
import java.util.ArrayList;

public class Restaurants {
    private static ArrayList<Restaurant>restaurants = new ArrayList<Restaurant>();
    public static ArrayList<Restaurant> getListRestaurant(){
        return restaurants;
    }
}
