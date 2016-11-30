package Vibes_Marketplace;
 
public class Items {
 
    int id;
    String name;
    String details;
    int quantity;
    double price;
     
    //public Item(){}
     
    public Items(int id, String name, String details, int quantity, double price){
        super();
        this.name = name;
        this.details = details;
        this.quantity = quantity;
        this.price = price; 
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getDetails() {
        return details;
    }
 
    public void setDetails(String details) {
        this.details = details;
    }
 
    public int getQuantity() {
        return quantity;
    }
 
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
     
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }
 
    public int getId() {
        return id;
    }
 
}