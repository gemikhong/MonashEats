import java.util.ArrayList;

/**
 * Created by HUANG JIAN on May 15, 2019
 * Edited by NHAT KHONG (Gemi) on May 25, 2019: add display() methods
 */

public class OrderList {
    private ArrayList<Order> orderList;

    public OrderList() {
        orderList = new ArrayList<Order>();
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public Order getOrder(int index){
        return orderList.get(index);
    }

    public void addOrder(Order order){
        orderList.add(order);
    }
    
    public void displayOrders(){
        System.out.println("Orders");
        for(Order o:orderList){
            System.out.println("Restaurant:  " + o.getRestaurantName());
            System.out.println("Order Time: " + o.getOrderTime());
            System.out.println("Delivery Time: " + o.getDeliveryTime());
        }
    }
    
    public void displayOrderDetails(){
        System.out.println("Orders");
        for(Order o:orderList){
            o.displayOrder();
        }
    }
    
}
