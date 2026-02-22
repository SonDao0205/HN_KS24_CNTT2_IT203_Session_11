package com.arenaofheroes.model;

import com.arenaofheroes.service.ISkill;

public class Mage extends GameCharacter implements ISkill {
    private int mana;

    public Mage(String name, int hp, int attackPower, int mana) {
        super(name, hp, attackPower);
        this.mana = mana;
    }

    @Override
    public void attack(GameCharacter target) {
        if(this.mana >= 5){
            target.takeDamage(super.getAttackPower());
            this.mana -= 5;
        }else{
            target.takeDamage(super.getAttackPower() / 2);
        }
        System.out.printf("[Pháp sư] %s tấn công %s!\n",super.getName(),target.getName());
        System.out.printf("-> %s mất %d máu, HP còn : %d\n",target.getName(),super.getAttackPower(),target.getHp());
    }

    @Override
    public void useUltimate(GameCharacter target) {
        if(this.mana < 50){
            System.out.printf("%s Không đủ mana!\n",super.getName());
        }else{
            this.mana -= 50;
            System.out.printf("[Pháp sư] %s sử dụng chiêu cuối lên %s!\n",super.getName(),target.getName());
            System.out.printf("-> %s tốn 50 mana, %s mất %d máu\n",super.getName(),target.getName(),super.getAttackPower() * 2);
            target.takeDamage(super.getAttackPower() * 2);
        }
    }

    @Override
    public void displayInfo() {
        System.out.printf("|Name : %-10s | HP : %-5d | Mana : %-5d |\n",super.getName(),super.getHp(),this.mana);
    }
}

