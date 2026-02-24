package Model;

import Serivices.IMixable;

public class FruitJuice extends Drink implements IMixable {
    int discountPercent;

    public FruitJuice(int id, String name, float price, int discountPercent) {
        super(id, name, price);
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculatePrice() {
        return super.price - (super.price * discountPercent / 100);
    }

    @Override
    public void mix() {
        System.out.println("Đang ép trái cây tươi!");
    }
}
