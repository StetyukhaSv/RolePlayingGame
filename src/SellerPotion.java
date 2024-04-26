public class SellerPotion {
    public static void sellPotion(Hero hero) {
        if(hero.health == hero.firstHealthHero) {
            System.out.println(hero.name + " не нуждается в лечении. Нет смысла тратить деньги");
        }
        else if(hero.gold >= 10 && hero.health < hero.firstHealthHero) {
            hero.gold -= 10;
            System.out.println(hero.name + " купил зелье за 10 золотых. В кошельке осталось " + hero.gold + " золота.");
            if(hero.health + 20 > 100) {
                hero.health = hero.firstHealthHero;
                System.out.println("Здоровье полностью восстановлено!");
            }
            else {
                hero.health += 20;
                System.out.println("Часть здоровья восстановлена. И теперь равна " + hero.health);
            }
        }
        else {
            System.out.println("У " + hero.name + " не хватает денег. Нужно ещё " + (10 - hero.gold));
        }
    }
}
