import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Customer extends User {
    private String firstName;
    private String lastName;
    private String phoneNO;
    private String address;
    private OrderList orderList;

    public Customer() {
        super();
        firstName = "";
        lastName = "";
        phoneNO = "";
        address = "";
        orderList = new OrderList();
    }

    public Customer(String firstName, String lastName, String phoneNO, String address,String email, String password) {
        super(email,password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNO = phoneNO;
        this.address = address;
        orderList = new OrderList();
    }

    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
     public void setLastName(String lasstName) {
        this.lastName = lastName;
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
        order.setRestId(cart.getRestId());
        getOrderList().addOrder(order);
    }

    public void showOrderList(){
        ArrayList<Order> orderList = getOrderList().getOrderList();
        int item = 0;
        for(Order order: orderList){
            item++;
            System.out.println(item+"."+"  "+"order "+item+" "+
                "order time: "+new SimpleDateFormat("dd/MM/yyyy").format(order.getOrderTime())+ 
                " Rating: "+order.isRateStatus());
        }
        
        
    }

    public int[] getOrder(int orderIndex){
        Boolean valid = false;
        ArrayList<Order> orderList = getOrderList().getOrderList();
        Order order = orderList.get(orderIndex);
        order.display();
        showRatingOption();
        int[] rating= null;
        
        while(!valid)
        {
                  String option = Input.getInput("Enter your option");
            if (option.equals("1"))
            {
                String foodRate = Input.getInput("Please Rate Food ( 1-5 )");
                int foodRating = Input.strToInt(foodRate);
                order.setRateFood(foodRating);
                String deliveryRate = Input.getInput("Please Rate Delivery ( 1-5 )");
                int deliveryRating = Input.strToInt(deliveryRate);
                order.setRateDelivery(deliveryRating);
                rating = new int[]{foodRating,deliveryRating,order.getRestId()};
                order.setRateStatus(true);                      
                valid = true;
           }
           if(option.equals("2"))
           {
               valid = true;
            }
            
        }
  
        return rating; 
        
    }

    public static void showRatingOption(){
        System.out.println("Please Select from the following options:");
        System.out.println("1. Rate Order");
        System.out.println("2. Go Back");
    }
}

