import java.util.ArrayList;

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

    public void display(){

    }
}
