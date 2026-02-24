package Main;

import Model.Coffee;
import Model.Drink;
import Model.FruitJuice;

public class Main {
    public static void main(String[] args) {
        Drink[] drinks = new Drink[3];
        drinks[0] = new Coffee(1,"Bạc sỉu",30000,true);
        drinks[1] = new FruitJuice(2,"Nước cam",40000,10);
        drinks[2] = null;

        for (Drink drink : drinks) {
            if(drink != null){
                drink.displayInfo();
                System.out.println("Thành tiền : " + drink.calculatePrice());
                if(drink instanceof FruitJuice) {
                    ((FruitJuice) drink).mix();
                }
            }
        }
    }
}
