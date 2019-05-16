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
}
