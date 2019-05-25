import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HUANG JIAN on May 15, 2019
 * Edited by NHAT KHONG (Gemi) on May 25, 2019: move the validations to a separate class
 */
public class MonashEats {
    private List<User> userList;
    private User currentUser;
    private List<Restaurant> restaurantList;

    private static final String INPUT_MSG = "Please Enter your choice:";

    private void initiateMoashEats(){
        this.userList = new ArrayList<User>();
        Customer eric = new Customer("Eric", "Huang", "0434665333", "7 park ave", "jhua074@gmail.com", "123456");
        userList.add(eric);

        Customer girish = new Customer("Girish", "Lion", "0434665333", "7 park ave", "girish@gmail.com", "654321");
        userList.add(girish);

        RestOwner gemi = new RestOwner("gemi@gmail.com", "0434665333", "Gemi", "Kong", "654321");
        userList.add(gemi);

        this.restaurantList = new ArrayList<Restaurant>();
        Restaurant r1 = new Restaurant();
        r1.setName("restaurant1");
        r1.setRating(3.5);
        Restaurant r2 = new Restaurant();
        r2.setName("restaurant2");
        r2.setRating(4.0);
        Restaurant r3 = new Restaurant();
        r3.setName("restaurant3");
        r3.setRating(5.0);
        Restaurant r4 = new Restaurant();
        r4.setName("restaurant4");
        r4.setRating(4.5);
        Restaurant r5 = new Restaurant();
        r5.setName("restaurant5");
        r5.setRating(5.0);
        restaurantList.add(r1);
        restaurantList.add(r2);
        restaurantList.add(r3);
        restaurantList.add(r4);
        restaurantList.add(r5);
    }

    public MonashEats() {
        initiateMoashEats();
    }

    public void startApp(){

        boolean isExit = false;
        while (!isExit){
            Input.welcomMsg();
            Input.displayMainOptions();
            String option = Input.getInput(INPUT_MSG);
            switch (option){
                case "1":
                register();
                break;
                case "2":
                login();
                break;
                case "3":
                displayRestList(this.restaurantList);
                Input.getInput("Press keyboard to back");
                break;
                case "4":
                isExit = true;
                System.out.print('\u000C');
                System.exit(0);
                break;
                default:
                System.out.print('\u000C');
                System.out.println("Please enter valid option number!");
                break;
            }
        }

    }

    private void register(){
        Input.showPage("Register");
        boolean keepRegister = true;
        while(keepRegister){
            Input.displayRegisterOptions();
            String option = Input.getInput(INPUT_MSG);
            switch (option){
                case "1":
                createAccount("C");
                keepRegister = false;
                break;
                case "2":
                createAccount("R");
                keepRegister = false;
                break;
                case "3":
                keepRegister = false;
                break;
                default:
                System.out.print('\u000C');
                System.out.println("Please enter valid option number!");
                break;
            }

        }
    }

    private void createAccount(String accountType){
        String firstName = "";
        String lastName = "";
        String email = "";
        String phoneNo = "";
        String address = "";
        String passwd = "";
        String pwd = "";
        String alertMsg = "";

        while(firstName.isEmpty()){
            alertMsg = "Please enter your first name:";
            firstName = Input.getInput(alertMsg);
            if(Input.checkExit(firstName)){
                return;
            }
        }

        while(lastName.isEmpty()){
            alertMsg = "Please enter your last name:";
            lastName = Input.getInput(alertMsg);
            if(Input.checkExit(lastName)){
                return;
            }
        }

        boolean isEmailValid = false;
        alertMsg = "Please enter your Email:";
        while (!isEmailValid){
            email = Input.getInput(alertMsg);
            if(!Validation.validEmail(email)){
                alertMsg = "Invalid email, Please enter again";
            }
            else if(existedEmail(email)){
                alertMsg = "Email existed. Please use another email";
            }
            else {
                isEmailValid = true;
            }
            if(Input.checkExit(email)){
                return;
            }
        }

        boolean isPhoneNoValid = false;
        alertMsg = "Please enter your phone number:";
        while (!isPhoneNoValid){
            phoneNo = Input.getInput(alertMsg);
            if(!Validation.validPhoneNo(phoneNo)){
                alertMsg = "Invalid phone number, Please enter again!";
            }else {
                isPhoneNoValid = true;
            }
            if(Input.checkExit(phoneNo)){
                return;
            }
        }

        if(accountType.equals("C")){
            boolean isAddressValid = false;
            alertMsg = "Please enter your address:";
            while (!isAddressValid){
                address = Input.getInput(alertMsg);
                if(!Validation.validAddress(address)){
                    alertMsg = "Invalid address, Please enter again!";
                }else {
                    isAddressValid = true;
                }
                if(Input.checkExit(address)){
                    return;
                }
            }
        }

        boolean isPasswdValid = false;
        alertMsg = "Please enter your Password:";
        while (!isPasswdValid){
            passwd = Input.getInput(alertMsg);
            if(!Validation.validPassword(passwd)){
                alertMsg = "Invalid password, Please enter !";
            }else{
                isPasswdValid = true;
            }
            if(Input.checkExit(passwd)){
                return;
            }
        }

        boolean isPwdValid = false;
        alertMsg = "Please confirm your Password:";
        while (!isPwdValid){
            pwd = Input.getInput(alertMsg);
            if(!passwd.equals(pwd)){
                alertMsg = "Confirm password not matched, Please enter again";
            }else{
                isPwdValid = true;
            }
            if(Input.checkExit(pwd)){
                return;
            }
        }

        if(accountType.equals("C")){
            Customer customer = new Customer(firstName, lastName, phoneNo, address, email, passwd);
            this.userList.add(customer);

        }

        if(accountType.equals("R")){
            RestOwner restOwner = new RestOwner(email, passwd, firstName, lastName, phoneNo);
            this.userList.add(restOwner);
        }

        login();
    }

    private void login(){
        boolean isLogin = false;
        while(!isLogin){
            Input.showPage("Login");

            String email = Input.getInput("Please enter your email:");

            if(Input.checkExit(email)){
                return;
            }
            String passwd = Input.getInput("Please enter your password");
            if(Input.checkExit(passwd)){
                return;
            }
            for(User user: this.userList){
                if(user.getEmail().equals(email) && user.getPassword().equals(passwd)){
                    this.currentUser = user;
                    isLogin = true;
                    goHomePage();
                }
            }
            if(isLogin == false){
                System.out.println("Email or password not correct!");
                Input.getInput("Press keyboard to continue...");
            }
        }
    }

    private void goHomePage(){
        boolean leaveHomePage = false;
        while(!leaveHomePage){
            Input.showPage("Home");
            Integer restNumber = displayHomeOptions();
            String option = Input.getInput(INPUT_MSG);
            if(option.equals("0")){
                researchPage();
            }
            Integer restNo = Input.strToInt(option);
            if(restNo >= 1 && restNo <= restNumber){
                orderPage(this.restaurantList, restNo-1);
            }
            if(option.equals(restNumber+1+"")){
                viewOrderHistory();
            }
            if(option.equals(restNumber+2+"")){
                this.currentUser = null;
                leaveHomePage = true;
            }
        }

    }

    private  Integer displayHomeOptions(){
        System.out.println();
        System.out.println("Please Select from the following options:");
        System.out.println("Press 0 to search restaurant");
        Integer index = displayRestList(this.restaurantList);
        System.out.println("Press "+(index+1)+" to view order history");
        System.out.println("Press "+(index+2)+" to log out");
        System.out.println();
        return index;
    }

    private Integer displayRestList(List<Restaurant> restaurantList){
        int i = 0;
        for(Restaurant restaurant : restaurantList){
            i++;
            System.out.println(i +". "+restaurant.getName()+" Rating: "+restaurant.getRating()+"☆");
        }
        return i;
    }

    private void researchPage(){
        Input.showPage("Research");
        String input = Input.getInput("Enter what you want to search:");
        ArrayList<Restaurant> filtedRestList = new ArrayList<>();
        for(Restaurant restaurant : this.restaurantList){
            if(restaurant.getAddress().contains(input) || restaurant.getName().contains(input)){
                filtedRestList.add(restaurant);
            }
        }
        displayFiltedRestList(filtedRestList);
    }

    private  void displayFiltedRestList(List<Restaurant> restaurantList){
        boolean keepOrdering = true;
        while(keepOrdering){
            System.out.print('\u000C');
            System.out.println();
            System.out.println("Please Select from the following options:");
            Integer index = displayRestList(restaurantList);
            System.out.println("Press "+(index+1)+" to back");
            System.out.println();
            String option = Input.getInput(INPUT_MSG);
            Integer restNo = Integer.valueOf(option);
            if(restNo >= 1 && restNo <= index){
                orderPage(restaurantList,restNo-1);
            }
            if(option.equals(index+1+"")){
                keepOrdering = false;
            }
        }

    }

    private void orderPage(List<Restaurant> restaurantList ,int restNo){
        boolean leaveOrderPage = false;
        Customer customer = (Customer) this.currentUser;
        Restaurant restaurant = restaurantList.get(restNo);
        Cart cart = new Cart(customer.getFirstName()+" "+customer.getLastName(), restaurant.getName());
        cart.setRestId(restNo);
        int foodNum = restaurant.getFoodListSize();
        while (!leaveOrderPage){
            Input.showPage("Order");
            restaurant.displayMenu();
            System.out.println("Press Food item No to order OR "+(foodNum +1)+" to view Cart");
            String option = Input.getInput(INPUT_MSG);
            Integer optionInt = Input.strToInt(option);
            if(optionInt > 0 && optionInt <= foodNum){
                Integer quantity = 0;
                while (quantity == 0){
                    String input = Input.getInput("Please enter quantity of this food item");
                    quantity = Input.strToInt(input);
                }
                if(quantity>0){
                    cart.addFoodItem(restaurant.getFoodList().get(optionInt-1),quantity);
                }

            }
            if(optionInt == foodNum+1){
                int size = cart.getFoodItems().size();
                if(size <= 0){
                    System.out.println("You have not order any food yet");
                    Input.getInput("Press keyboard to continue..");
                }else{
                    leaveOrderPage = cart.cartPage(cart,customer);
                }
            }
        }
    }

    private boolean existedEmail(String newEmail){
        for(User u:userList){
            if(newEmail.equals(u.getEmail())){
                return true;
            }
        }
        return false;
    }

    private void viewOrderHistory(){
        Customer customer = (Customer) this.currentUser;
        if(customer.getOrderList().getOrderList().size() <= 0)
        {
            System.out.println("No Orders to Display");
            Input.getInput("Press KeyBoard to Continue...");
        }
        else
        {

            while(true){
                Input.showPage("Order History");
                customer.showOrderList();
                System.out.println("Option 0: Go Back");
                String orderInput = Input.getInput(INPUT_MSG);
                int orderSelected = Input.strToInt(orderInput);
                if(orderSelected == 0){
                    return;
                }
                if(orderSelected > 0 && orderSelected <=customer.getOrderList().getOrderList().size() ){
                    Input.showPage("Order Detail");
                    int[] ratingReceived = customer.getOrder(orderSelected-1);
                    if(ratingReceived != null)
                    {
                        int foodRating = ratingReceived[0];
                        int deliveryRating = ratingReceived[1];
                        int restId = ratingReceived[2];
                        System.out.println("restId: "+restId);
                        Restaurant restaurant = restaurantList.get(restId);
                        restaurant.calculateRating(foodRating,deliveryRating);
                        break;
                    }
                }
            }

        }
    }
}
