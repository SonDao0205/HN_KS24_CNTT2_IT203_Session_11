package com.arenaofheroes.main;

import com.arenaofheroes.model.GameCharacter;
import com.arenaofheroes.model.Mage;
import com.arenaofheroes.model.Warrior;
public class Main {
    public static void main(String[] args) {
        Warrior yasuo = new Warrior("Yasuo",400,50,20);
        Mage veigar = new Mage("Veigar",300,50,100);
        GameCharacter goblin = new GameCharacter("Goblin", 100, 10) {
            @Override
            public void attack(GameCharacter target) {
                target.takeDamage(10);
                System.out.println("[Quái vật] Goblin tấn công!");
                System.out.printf("-> Goblin cắn trộm %s gây 10 sát thương!\n",target.getName());
            }
        };

        GameCharacter[] characters = new GameCharacter[GameCharacter.count];
        characters[0] = yasuo;
        characters[1] = veigar;
        characters[2] = goblin;

        System.out.println("=== ARENA OF HEROES ===");
        System.out.printf("Đã khởi tạo %d nhân vật tham gia đấu trường!\n",GameCharacter.count);
        System.out.println("============ THÔNG SỐ TRƯỚC LƯỢT ĐẤU ===========");
        matchStatistics(characters);

        // trường hợp 1 :
        yasuo.attack(goblin);
        veigar.useUltimate(yasuo);
        goblin.attack(veigar);

//        trường hợp 2 :
//        yasuo.attack(goblin);
//        veigar.useUltimate(yasuo);
//        yasuo.attack(null);
//        yasuo.attack(goblin);
//        goblin.attack(veigar);

        System.out.println("============ THÔNG SỐ SAU LƯỢT ĐẤU =============");
        matchStatistics(characters);


    }

    static void matchStatistics(GameCharacter[] charaters){
        for (GameCharacter character : charaters){
            character.displayInfo();
        }
        System.out.println("================================================");
    }
}
