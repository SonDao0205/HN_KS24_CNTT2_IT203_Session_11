package com.arenaofheroes.model;

import com.arenaofheroes.service.ISkill;

public class Warrior extends GameCharacter implements ISkill {
    private int armor;
    final private int limitHp;

    public Warrior(String name, int hp, int attackPower, int armor) {
        super(name, hp, attackPower);
        this.armor = armor;
        limitHp = (int)(super.getHp() * 0.1);
        System.out.println("limit : "+limitHp );
    }

    @Override
    public void attack(GameCharacter target) {
        int attackPower = super.getAttackPower();
        target.takeDamage(attackPower);
        System.out.printf("[Chiến binh] %s tấn công %s!\n",super.getName(),target.getName());
        System.out.printf("-> %s mất %d máu, HP còn : %d\n",target.getName(),attackPower,target.getHp());
    }

    @Override
    public void useUltimate(GameCharacter target) {
        if(super.getHp() <= limitHp){
            System.out.println("Không đủ máu để sử dụng!");
        }else{
            int damage = super.getAttackPower() * 2;
            target.takeDamage(damage);
            super.setHp((int) (super.getHp() * 0.9));
            System.out.printf("[Chiến binh] %s sử dụng chiêu cuối lên %s!\n",super.getName(),target.getName());
            System.out.printf("-> %s tốn 10 máu, %s mất %d\n",super.getName(),target.getName(),damage);
        }
    }

    @Override
    public void takeDamage(int amount) {
        if(this.armor >= amount){
            this.armor -= amount;
        }else{
            int damage = amount - this.armor;
            this.armor = 0;
            super.takeDamage(damage);
        }
    }

    @Override
    public void displayInfo() {
        System.out.printf("|Name : %-10s | HP : %-5d | Giáp : %-5d |\n",super.getName(),super.getHp(),this.armor);
    }
}
