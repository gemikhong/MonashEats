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
        initialMenu();
        orderList = new OrderList();
    }

    public Restaurant(String name, String address, Double rating, Integer minPurchase) {
        this.name = name;
        this.address = address;
        this.rating = rating;
        foodList = new ArrayList<Food>();
        initialMenu();
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

    public void initialMenu(){
        setMinPurchase(10);
        Food food1 = new Food("food1", "decription for food1", 13d);
        Food food2 = new Food("food2", "decription for food2", 10d);
        Food food3 = new Food("food3", "decription for food3", 15d);
        getFoodList().add(food1);
        getFoodList().add(food2);
        getFoodList().add(food3);
    }

    public void displayMenu(){

        System.out.println("Restaurant Name: "+ getName());
        System.out.println("Rating: "+getRating() + "☆");
        System.out.println("Address: "+getAddress());
        System.out.println();
        int i = 0;
        for (Food food: getFoodList()){
            i++;
            System.out.println("Food item "+i);
            food.display();
        }
    }
    
     public Integer getFoodListSize(){
        return getFoodList().size();
    }
    public void calculateRating(int receivedFoodRating,int receivedDeliveryRating)
    {
        double newRating = (((receivedFoodRating + receivedDeliveryRating)/2)+ getRating())/2 ;
        setRating(newRating);
    }
}
