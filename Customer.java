import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Customer extends User {
    private String name;
    private String phoneNO;
    private String address;
    private OrderList orderList;

    public Customer() {
        super();
        name = "";
        phoneNO = "";
        address = "";
        orderList = new OrderList();

    }

    public Customer(String name, String phoneNO, String address,String email, String password) {
        super(email,password);
        this.name = name;
        this.phoneNO = phoneNO;
        this.address = address;
        orderList = new OrderList();
    }

    public String getName() {
        return name;
    }

    public String getPhoneNO() {
        return phoneNO;
    }

    public String getAddress() {
        return address;
    }

    public OrderList getOrderList() {
        return orderList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNO(String phoneNO) {
        this.phoneNO = phoneNO;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addOrder(Cart cart, String payMethod){
        Order order = new Order();
        order.setFoodItems(cart.getFoodItems());
        order.setCustomerName(cart.getCustomerName());
        order.setRestaurantName(cart.getRestaurantName());
        order.finalizeTotalPrice();
        order.setOrderTime(new Date());
        order.setDeliveryTime(new Date());
        order.setOrderStatus("finished");
        order.setPayMethod(payMethod);
        order.setRateStatus(false);
        getOrderList().addOrder(order);
    }

    public void displayOrderList(){
        ArrayList<Order> orderList = getOrderList().getOrderList();
        int item = 0;
        for(Order order: orderList){
            item++;
            System.out.println("order"+item+" "+
                    "order time: "+new SimpleDateFormat("dd/MM/yyyy").format(order.getOrderTime())+ 
                    " Rating: "+order.isRateStatus());
        }
    }

}
