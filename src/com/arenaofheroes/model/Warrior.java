package com.arenaofheroes.model;

import com.arenaofheroes.service.ISkill;

public class Warrior extends GameCharacter implements ISkill {
    private int armor;

    public Warrior(String name, int hp, int attackPower, int armor) {
        super(name, hp, attackPower);
        this.armor = armor;
    }

    @Override
    public void attack(GameCharacter target) {
        target.takeDamage(super.getAttackPower());
        System.out.printf("[Chiến binh] %s tấn công %s!\n",super.getName(),target.getName());
        System.out.printf("-> %s mất %d máu, HP còn : %d\n",target.getName(),super.getAttackPower(),target.getHp());
    }

    @Override
    public void useUltimate(GameCharacter target) {
        if(super.getHp() <= 10){
            System.out.println("Không đủ máu để sử dụng!");
        }else{
            target.takeDamage(super.getAttackPower() * 2);
            super.setHp((int) (super.getHp() * 0.9));
            System.out.printf("[Chiến binh] %s sử dụng chiêu cuối lên %s!\n",super.getName(),target.getName());
            System.out.printf("-> %s tốn 10 máu, %s mất %d\n",super.getName(),target.getName(),super.getAttackPower() * 2);
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
