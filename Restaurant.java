import java.util.ArrayList;

public class Restaurant {
    private String name;
    private String address;
    private Double rating;
    private Integer minPurchase;
    private ArrayList<Food> foodList;
    private OrderList orderList;

    public Restaurant() {
        name = "";
        address = "";
        rating = 0d;
        minPurchase = 0;
        foodList = new ArrayList<Food>();
        orderList = new OrderList();
    }

    public Restaurant(String name, String address, Double rating, Integer minPurchase, ArrayList<Food> foodList) {
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.minPurchase = minPurchase;
        this.foodList = foodList;
        orderList = new OrderList();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Double getRating() {
        return rating;
    }

    public Integer getMinPurchase() {
        return minPurchase;
    }

    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    public OrderList getOrderList() {
        return orderList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setMinPurchase(Integer minPurchase) {
        this.minPurchase = minPurchase;
    }

    public void display(){

    }
}
