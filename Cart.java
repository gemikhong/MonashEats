import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private String customerName;
    private String restaurantName;
    private ArrayList<HashMap<Food,Integer>> foodItems;
    private Double totalPrice;

    public Cart() {
        foodItems = new ArrayList<HashMap<Food,Integer>>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public ArrayList<HashMap<Food, Integer>> getFoodItems() {
        return foodItems;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void addFoodItem(Food food, int num) {
        Map<Food, Integer> map = new HashMap<Food, Integer>();
        map.put(food,num);

        foodItems.add((HashMap<Food, Integer>) map);
    }

    public void removeFoodItem(int index){
        foodItems.remove(index);
    }
}
