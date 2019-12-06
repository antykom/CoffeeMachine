package machine;
import java.util.Scanner;

public class CoffeeMachine {

    public static void printAmount(int water, int milk, int beans, int cups, int money){
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public enum UserOption{
        BUY,
        FILL,
        TAKE,
        REMAINING,
        EXIT,
        BACK;
    }

    public static class Machine{
        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;
        boolean exit = false;

        Scanner scanner = new Scanner(System.in);

        void toDo(String status){

            status = status.toUpperCase();
            switch (UserOption.valueOf(status)){
                case BUY:
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3- cappuccino, back - to main menu" );
                    int buyOption = scanner.nextInt();
                    switch(buyOption){
                        case 1:
                            if(water < 250){
                                System.out.println("Sorry, not enough water!");
                            }else if(beans < 16){
                                System.out.println("Sorry, not enough beans!");
                            }else if(cups < 1){
                                System.out.println("Sorry, not enough cups!");
                            }else{
                                water -= 250;
                                beans -= 16;
                                cups --;
                                money += 4;
                                System.out.println("I have enough resources, making you a coffee!");
                            }
                            break;
                        case 2:
                            if(water < 350){
                                System.out.println("Sorry, not enough water!");
                            }else if(beans < 20){
                                System.out.println("Sorry, not enough beans!");
                            }else if(milk < 75){
                                System.out.println("Sorry, not enough milk!");
                            }else if(cups < 1){
                                System.out.println("Sorry, not enough cups!");
                            }else{
                                water -= 350;
                                milk -= 75;
                                beans -= 20;
                                cups --;
                                money += 7;
                                System.out.println("I have enough resources, making you a coffee!");
                            }
                            break;
                        case 3:
                            if(water < 200){
                                System.out.println("Sorry, not enough water!");
                            }else if(beans < 12){
                                System.out.println("Sorry, not enough beans!");
                            }else if(milk < 100){
                                System.out.println("Sorry, not enough milk!");
                            }else if(cups < 1){
                                System.out.println("Sorry, not enough cups!");
                            }else{
                                water -= 200;
                                milk -= 100;
                                beans -= 12;
                                cups --;
                                money += 6;
                                System.out.println("I have enough resources, making you a coffee!");
                            }
                            break;
                    }
                    break;
                case FILL:
                    System.out.println("Write how many ml of water do you want to add: ");
                    water += scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add: ");
                    milk += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add: ");
                    beans += scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    cups += scanner.nextInt();
                    break;
                case TAKE:
                    System.out.println("I gave you $" + money);
                    money = 0;
                    break;
                case REMAINING:
                    printAmount(water, milk, beans, cups, money);
                    break;
                case BACK:
                    break;
                case EXIT:
                    exit = true;
                    break;
                default:
                    break;
            }

        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Machine coffeeMachine = new Machine();
        String action;
        boolean exit = false;

        do{
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = scanner.next();
            coffeeMachine.toDo(action);
            if(coffeeMachine.exit == true){
                exit = true;
            }
        }while(!exit);

    }

}