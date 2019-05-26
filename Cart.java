import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private String customerName;
    private String restaurantName;
    private HashMap<Food,Integer> foodItems;
    private Double totalPrice;
    private int restId;

    public Cart() {
        foodItems = new HashMap<Food,Integer>();
    }

    public Cart(String customerName, String restaurantName) {
        this.customerName = customerName;
        this.restaurantName = restaurantName;
        foodItems = new HashMap<Food,Integer>();
    }

    public String getCustomerName() {
        return customerName;
    }
    
    public String getRestaurantName() {
        return restaurantName;
    }

    public HashMap<Food, Integer> getFoodItems() {
        return foodItems;
    }
    
    public Double getTotalPrice() {
        return totalPrice;
    }

    public int getRestId()
    {
        return restId;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
    
    public void setFoodItems(HashMap<Food, Integer> foodItems) {
        this.foodItems = foodItems;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public void setRestId(int restNo)
    {
        this.restId = restNo;
    }
    
    public void addFoodItem(Food food, int num) {
        if (foodItems.containsKey(food)){
            foodItems.replace(food,foodItems.get(food)+num);
        }else {
            foodItems.put(food,num);
        }
    }

    public void finalizeTotalPrice(){
        Double totalPrice = 0d;
        for(Map.Entry<Food,Integer> entry: getFoodItems().entrySet()){
            totalPrice += entry.getKey().getPrice()*entry.getValue();
        }
        setTotalPrice(totalPrice);
    }
    
    public Integer getFoodListSize(){
        return getFoodItems().size();
    }

    public boolean cartPage(Cart cart, Customer customer){
        Input.showPage("Cart");
        List<Food> list = new ArrayList<>();

        boolean flag = false;
        while (!flag){
            HashMap<Food, Integer> foodItems = cart.getFoodItems();
            cart.finalizeTotalPrice();
            System.out.println("Option 0: back to order");

            showFoodItems(foodItems,list);
            System.out.println("       Total Price: $" +cart.getTotalPrice());
            System.out.println("Option "+(list.size() + 1) + ": place order");
            System.out.println("Option "+(list.size() + 2) + ": delete cart");

            String option = Input.getInput("Press item NO to Update or select other option");

            Integer optionInt = Input.strToInt(option);
            if(optionInt == 0){
                flag = true;
            }

            if(optionInt == (list.size() + 2)){
                foodItems.clear();
                cart.setFoodItems(foodItems);
                flag = true;
            }
            if(optionInt == list.size()+1){
                if(cart.getTotalPrice() <= 600 && cart.getTotalPrice() > 10 )
                {
                    cart.setFoodItems(foodItems);
                    String payMethod = "";
                    while(payMethod.isEmpty()){
                        Input.showPayment();
                        String payOption = Input.getInput("Please select your payment method:");
                        Integer payInt = Input.strToInt(payOption);
                        if(payInt == 1)
                            payMethod = "Cash";
                        if(payInt == 2)
                            payMethod = "Coupon";
                    }
                    customer.addOrder(cart, payMethod);
                    return true;

                }
                else
                {
                    System.out.println("The Total Order Price cant be above AUD$ 600 and cannot be below AUD$ 10");
                    Input.getInput("Press any key to continue...");
                    list = new ArrayList<>();
                }

            }
            if(optionInt>0 && optionInt<=list.size()){
                String input = Input.getInput("Please enter the quantity you want to change to:");
                Integer quantity = Input.strToInt(input);
                if(quantity == 0){
                    foodItems.remove(list.get(optionInt-1));
                }else if(quantity > 0){
                    foodItems.replace(list.get(optionInt-1),quantity);
                }
                cart.setFoodItems(foodItems);
            }

        }

        return false;

    }

    public void showFoodItems(HashMap<Food, Integer> foodItems,List<Food> list)
    {
        for(Map.Entry<Food,Integer> entry: foodItems.entrySet()){
            Food food = entry.getKey();
            Integer num = entry.getValue();
            list.add(food);
            System.out.println("Item"+list.size()+" "+food.getName() + " Quantity:"+ num +" $"+food.getPrice()*num);
        }
    }

}
