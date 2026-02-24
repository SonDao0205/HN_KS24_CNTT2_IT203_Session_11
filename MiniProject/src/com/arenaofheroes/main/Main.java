package com.arenaofheroes.main;

import com.arenaofheroes.model.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Warrior yasuo = new Warrior("Yasuo", 400, 50, 20);
        Assassin talon = new Assassin("Talon", 300, 50, 100);
        Support threst = new Support("Threst", 500, 30, 100);
        Mage veigar = new Mage("Veigar", 300, 100, 100);
        Chronomancer huyHoan =  new Chronomancer("Hoan", 300, 100, 100);
        GameCharacter goblin = new GameCharacter("Goblin", 100, 10) {
            @Override
            public void attack(GameCharacter target) {
                System.out.println("[Quái vật] Goblin tấn công!");
                target.takeDamage(10);
                System.out.printf("-> Goblin cắn trộm %s gây 10 sát thương!\n", target.getName());
            }
        };

        GameCharacter[] characters = {yasuo, veigar, goblin,talon,threst,huyHoan};

        System.out.println("=== ARENA OF HEROES ===");
        System.out.println("============ THÔNG SỐ TRƯỚC TRẬN ĐẤU ===========");
        matchStatistics(characters);
        int randomSkill = (int) (Math.random() * 2);

        while (countAlive(characters) > 1) {
            int attackerIdx, victimIdx;

            do {
                attackerIdx = (int) (Math.random() * characters.length);
            } while (characters[attackerIdx].getHp() <= 0);

            do {
                victimIdx = (int) (Math.random() * characters.length);
            } while (victimIdx == attackerIdx || characters[victimIdx].getHp() <= 0);

            System.out.println("\n--- LƯỢT ĐẤU ---");
            if (randomSkill == 0) {
                characters[attackerIdx].attack(characters[victimIdx]);
            } else {
                if (characters[attackerIdx] instanceof Mage mage) {
                    mage.useUltimate(characters[victimIdx]);
                } else if (characters[attackerIdx] instanceof Warrior warrior) {
                    warrior.useUltimate(characters[victimIdx]);
                } else if (characters[attackerIdx] instanceof Support support) {
                    support.useUltimate(characters[victimIdx]);
                } else if (characters[attackerIdx] instanceof Assassin assassin){
                    assassin.useUltimate(characters[victimIdx]);
                }else if(characters[attackerIdx] instanceof Chronomancer chronomancer){
                    chronomancer.useUltimate(characters[victimIdx]);
                }
                else {
                    characters[attackerIdx].attack(characters[victimIdx]);
                }
            }
            matchStatistics(characters);
        }

        System.out.println("\n================================================");
        System.out.println("TRẬN ĐẤU KẾT THÚC!");
        announceWinner(characters);
    }

    // Hàm đếm số tướng còn sống
    static int countAlive(GameCharacter[] characters) {
        int alive = 0;
        for (GameCharacter c : characters) {
            if (c.getHp() > 0) alive++;
        }
        return alive;
    }

    // Hàm hiển thị thông tin tất cả các tướng
    static void matchStatistics(GameCharacter[] characters) {
        System.out.println("------------------------------------------------");
        for (GameCharacter character : characters) {
            character.displayInfo();
        }
        System.out.println("------------------------------------------------");
    }

    // Hàm thông báo người thắng cuộc
    static void announceWinner(GameCharacter[] characters) {
        for (GameCharacter c : characters) {
            if (c.getHp() > 0) {
                System.out.println("NGƯỜI CHIẾN THẮNG CUỐI CÙNG: " + c.getName().toUpperCase());
                return;
            }
        }
    }
}