import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Created by HUANG JIAN on May 15, 2019
 * Edited by NHAT KHONG (Gemi) on May 26, 2019: add displayReceipt() method
 */

public class Order extends Cart {
    private String orderStatus;
    private Date orderTime;
    private Date deliveryTime;
    private String payMethod;
    private int rateFood;
    private int rateDelivery;
    private String rateStatus;

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

    public String getRateStatus() {
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

    public void setRateStatus(String rateStatus) {
        this.rateStatus = rateStatus;
    }
    
    public void displayOrder(){
        System.out.println("Restaurant:  "+getRestaurantName());
        if(getOrderStatus().equals("Delivered")){
            System.out.println("Delivery Time: "+ getDeliveryTime());
        }
        else {
            System.out.println("Order Time: "+ getOrderTime());
            System.out.println("Expected Delivery Time: "+ getDeliveryTime());
        }
        System.out.println("Order Status: "+ getOrderStatus());
        showFoodItems(getFoodItems(), new ArrayList<>());
        System.out.println("------------------------------------------------------");
        finalizeTotalPrice();
        System.out.println("Total price (GST included): "+ getTotalPrice());
    }
    
    public void displayReceipt(){
        System.out.println("Restaurant:  "+getRestaurantName());
        System.out.println("Order Time: "+ getOrderTime());
        showFoodItems(getFoodItems(), new ArrayList<>());
        System.out.println("------------------------------------------------------");
        finalizeTotalPrice();
        System.out.println("Total price (GST included): "+ getTotalPrice());
    }
}
