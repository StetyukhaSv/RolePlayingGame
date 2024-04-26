public class Hero extends GameCharacter{
    int firstHealthHero = health;
    int lvl = 1;
    public Hero(String name, int health, int power, int dexterity, int experience, int gold) {
        super(name, health, power, dexterity, experience, gold);
    }

    public void levelUp() {
        System.out.println("\n" + "Вы набрались опыта ведения боя с силами зла. Все раны затягиваются, а уровень и характеристики повышаются");
        health = firstHealthHero + 20;
        firstHealthHero = health;
        power += 5;
        dexterity += 5;
        experience = 0;
        lvl++;
        System.out.println(toString() + "\n" + "уровень - " + lvl);
    }

}
