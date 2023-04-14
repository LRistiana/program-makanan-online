package data;
import entity.Restaurant;
import java.util.ArrayList;

public class Restaurants {
    private static ArrayList<Restaurant>Restaurants = new ArrayList<Restaurant>();
    public static ArrayList<Restaurant> getListRestaurant(){
        return Restaurants;
    }
}
