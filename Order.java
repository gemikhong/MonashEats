import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class Order extends Cart {
    private Date orderTime;
    private String orderStatus;
    private Date deliveryTime;
    private String payMethod;
    private int rateFood;
    private int rateDelivery;
    private boolean rateStatus;

    public Order() {
        super();
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public int getRateFood() {
        return rateFood;
    }

    public int getRateDelivery() {
        return rateDelivery;
    }

    public boolean isRateStatus() {
        return rateStatus;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public void setRateFood(int rateFood) {
        this.rateFood = rateFood;
    }

    public void setRateDelivery(int rateDelivery) {
        this.rateDelivery = rateDelivery;
    }

    public void setRateStatus(boolean rateStatus) {
        this.rateStatus = rateStatus;
    }

    public void display(){
     System.out.println("Restaurant:  "+getRestaurantName());
     System.out.println("Order Time: "+ getOrderTime());
     System.out.println("Delivery Time: "+ getDeliveryTime());
     HashMap<Food, Integer> foodItems = getFoodItems();
     List<Food> list = new ArrayList<>();
     showFoodItems(foodItems,list);
    }
}
