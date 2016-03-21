package vendingmachinekata;

public class Item {

    private double value;
    private String name;
    private int quantity;


    public Item(double value, String name) {
        this.value = value;
        this.name = name;
    }
    
    public Item() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
    
    
}
