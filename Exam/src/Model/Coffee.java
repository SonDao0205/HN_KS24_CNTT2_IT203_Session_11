package Model;

import Serivices.IMixable;

public class Coffee extends Drink {
    boolean hasMilk;

    public Coffee(int id, String name, float price, boolean hasMilk) {
        super(id, name, price);
        this.hasMilk = hasMilk;
    }

    @Override
    public double calculatePrice() {
        if(hasMilk){
//            super.setPrice(super.getPrice() + 5000);
            return super.price + 5000;
        }else{
            return super.price;
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("%s |", (hasMilk ? "Có sữa" : "Đen đá"));
    }
}
