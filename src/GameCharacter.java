import java.util.Map;
import java.util.Random;

public abstract class GameCharacter {
    protected String name;
    protected int health;
    protected int power;
    protected int dexterity;
    protected int experience;
    protected int gold;

    public GameCharacter(String name, int health, int power, int dexterity, int experience, int gold) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.dexterity = dexterity;
        this.experience = experience;
        this.gold = gold;
    }

    public int attack() {
        if(dexterity * 3 > new Random().nextInt(100) + 1) {
            if(new Random().nextInt(10) == 0) {
                return power * 2;
            }
            else {
                return power;
            }
        }
        else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return  "Имя - " + name + "\n" +
                "здоровье - " + health + "\n" +
                "сила - " + power + "\n" +
                "ловкость - " + dexterity + "\n" +
                "опыт - " + experience + "\n" +
                "золото - " + gold;
    }
}
