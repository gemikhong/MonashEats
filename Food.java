public class Food {
    private String name;
    private String description;
    private Double price;

    public Food() {
    }

    public Food(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void display(){
        System.out.println("Food Name: "+getName());
        System.out.println("Description: "+getDescription());
        System.out.println("Price: "+getPrice());
    }
}
