import java.util.ArrayList;

public class RestOwner extends User {
    private String name;
    private String phoneNo;
    private ArrayList<Restaurant> restList;

    public RestOwner() {
        super();
        name = "";
        phoneNo = "";
        restList = new ArrayList<Restaurant>();
    }

    public RestOwner(String email, String password, String name, String phoneNo) {
        super(email, password);
        this.name = name;
        this.phoneNo = phoneNo;
        restList = new ArrayList<Restaurant>();
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public ArrayList<Restaurant> getRestList() {
        return restList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void  registerRestaurant(){
    }
}
