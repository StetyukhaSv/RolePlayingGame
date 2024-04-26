import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Чтобы начать игру необходимо создать вашего персонажа. Введите его имя");
        String nameHero = console.nextLine();
        Hero hero = new Hero(nameHero, 100, 10, 10, 0, 0);
        System.out.println("Поздравляем! Ваш персонаж создан" + "\n" + hero);
        while (true) {
            System.out.println("\n" + "Выберите куда вы хотите отправится и введите нужную цифру." + "\n" +
                    "1. К торговцу" + "\n" +
                    "2. В тёмный лес" + "\n" +
                    "3. На выход");
            int number = console.nextInt();
            if (number == 1) {
                SellerPotion.sellPotion(hero);
            }
            else if (number == 2) {
                Thread thread = Battle.battleScenario(hero, Battle.chooseMonster(hero));
                while (true) {
                    if (thread.getState() != Thread.State.RUNNABLE) {
                        break;
                    }
                }
            }
            else if(number == 3) {
                System.out.println("Игра завершена");
                break;
            }
            else {
                System.out.println("Вы ввели неверное число, попробуйте снова...");
            }
        }
    }
}