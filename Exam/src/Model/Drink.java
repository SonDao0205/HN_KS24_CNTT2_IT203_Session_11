package Model;

public abstract class Drink {
    protected int id;
    protected String name;
    protected float price;

    public Drink(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract double calculatePrice();

    public void displayInfo(){
        System.out.printf("|ID : %d |Name : %s |Price : %.2f |",id,name,price);
    }
}
