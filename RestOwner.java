import java.util.ArrayList;

public class RestOwner extends User {
    private String firstName;
    private String lastName;
    private String phoneNo;
    private ArrayList<Restaurant> restList;

    public RestOwner() {
        super();
        firstName = "";
        lastName = "";
        phoneNo = "";
        restList = new ArrayList<Restaurant>();
    }

    public RestOwner(String email, String password, String firstName, String lastName, String phoneNo) {
        super(email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        restList = new ArrayList<Restaurant>();
    }

    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public ArrayList<Restaurant> getRestList() {
        return restList;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
     public void setLastName(String lasstName) {
        this.lastName = lastName;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void  registerRestaurant(){
    }
}
