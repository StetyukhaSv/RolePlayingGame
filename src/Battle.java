import java.util.Random;

import static java.lang.System.exit;

public class Battle {

    public static GameCharacter chooseMonster(Hero hero) {
        if(new Random().nextInt(2) == 0) {
            return new Skeleton("Скелет", hero.health, hero.power, hero.dexterity, 50, 10);
        }
        else {
            return new Goblin("Гоблин", hero.health, hero.power, hero.dexterity, 50, 10);
        }
    }
    public static Thread battleScenario(Hero hero, GameCharacter monster)  {
        Thread thread = new Thread() {
            @Override
            public void run() {
                boolean isFightOver = false;
                while(!isFightOver) {
                    System.out.println(hero.name + " заходит в лес.");
                    if(new Random().nextInt(2) == 0) {
                        System.out.println("Увидев " + monster.name + ", " + hero.name + " успевает быстро среагировать и наносит первый удар!" + "\n");
                        isFightOver = fightWithMonster(hero, monster);
                    }
                    else {
                        System.out.println(hero.name + " обращает внимание на целебную и траву и теряет бдительность, рядом затаившийся "
                                + monster.name + " наносит удар первым!" + "\n");
                        isFightOver = fightWithMonster(monster, hero);
                    }
                    try {
                        Thread.sleep(1500);
                    }
                    catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
        return thread;
    }

    public static boolean fightWithMonster(GameCharacter attacking, GameCharacter defending) {
        boolean result = false;
        while (attacking.health > 0 && defending.health > 0) {
            int attack = attacking.attack();
            defending.health -= attack;
            System.out.println("Сила удара равна " + attack + ". Уровень здоровья "+ defending.name + " равен " + defending.health);
            if(defending.health <= 0) {
                if(defending instanceof Hero) {
                    System.out.println(defending.name + " повержен! Игра окончена");
                    System.exit(0);
                }
                else {
                    System.out.println(attacking.name + " одолел " + defending.name + "!");
                    attacking.gold += defending.gold;
                    attacking.experience += defending.experience;
                    System.out.println(attacking.name + " получает " + defending.gold + " золотых и " + defending.experience + " опыта." + "\n");
                    System.out.println(attacking);
                    //System.out.println("Теперь у " + attacking.name + " " + attacking.gold + " золотых и " + attacking.experience + " опыта.");
                    if(attacking.experience >= 150) {
                        ((Hero) attacking).levelUp();
                    }
                }
                result = true;
                break;
            }
            attack = defending.attack();
            attacking.health -= attack;
            System.out.println("Сила удара равна " + attack + ". Уровень здоровья "+ attacking.name + " равен " + attacking.health);
            if (attacking.health <= 0) {
                if(attacking instanceof Hero) {
                    System.out.println(attacking.name + " повержен! Игра окончена");
                    System.exit(0);
                }
                else {
                    System.out.println(defending.name + " одолел " + attacking.name + "!");
                    defending.gold += attacking.gold;
                    defending.experience += attacking.experience;
                    System.out.println(defending.name + " получает " + attacking.gold + " золотых и " + attacking.experience + " опыта." + "\n");
                    System.out.println(defending);
                    //System.out.println("Теперь у " + defending.name + " " + defending.gold + " золотых и " + defending.experience + " опыта.");
                    if(defending.experience >= 150) {
                        ((Hero) defending).levelUp();
                    }
                }
                result = true;
                break;
            }
        }
        return result;
    }

}
