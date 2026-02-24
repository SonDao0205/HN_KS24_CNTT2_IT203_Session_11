package com.arenaofheroes.model;

import com.arenaofheroes.model.GameCharacter;
import com.arenaofheroes.service.ISkill;

public class Assassin extends GameCharacter implements ISkill {
    private int energy;

    public Assassin(String name, int hp, int attackPower, int energy) {
        super(name, hp, attackPower);
        this.energy = energy;
    }

    @Override
    public void attack(GameCharacter target) {
        if (this.energy >= 50){
            target.takeDamage(super.getAttackPower());
            energy -= 50;
            System.out.printf("%s sử dụng nắm đấp sấm sét vào %s .\n" , super.getName() , target.getName());
        } else {
            target.takeDamage(super.getAttackPower()/2);
            System.out.printf("%s sử dụng nắm đấp sấm sét vào %s .\n" , super.getName() , target.getName());
        }
        if(target.getHp()<=0){
            System.out.printf("%s đã bị hạ gục!\n", target.getName());
        }
    }

    @Override
    public void useUltimate(GameCharacter target) {
        if (this.energy >= 100){
            if (target.getHp() <= 100) {
                int damage = target.getHp();
                target.takeDamage(damage);
                this.energy -= 100;
                System.out.printf("%s sử dụng One shot one kill vào %s .\n" , super.getName() , target.getName());
                this.setHp(this.getHp() + damage);
            } else {
                target.takeDamage(super.getAttackPower() * 3);
                this.energy -= 100;
                System.out.printf("%s sử dụng cú bắn nem chua vào %s .\n" , super.getName() , target.getName());
            }
        } else {
            System.out.printf("Năng lượng của %s không đủ để dùng chiêu cuối !.\n" , super.getName());
        }
        if(target.getHp()<=0){
            System.out.printf("%s đã bị hạ gục!\n", target.getName());
        }
    }

    @Override
    public void displayInfo() {
        System.out.printf("|Name : %-10s | HP : %-5d | Energy : %d |\n",super.getName(),super.getHp(),this.energy);
    }
}