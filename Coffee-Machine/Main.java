import java.util.*;

class CoffeeMachine{
    Scanner sc = new Scanner(System.in);
    private int water;
    private int milk;
    private int coffee;
    private int cup;
    private int money;

    CoffeeMachine(){
        this.water = 400;
        this.milk = 540;
        this.coffee = 120;
        this.cup = 9;
        this.money = 550;
    }

    public void checking(String decision){
        if(decision.equals("remaining")) {
            remaining();
        }
        else if (decision.equals("buy")) {
            buy();
        }
        else if (decision.equals("fill")) {
            fill();
        }
        else if (decision.equals("take")){
            take();
        }
    }

    private void fill(){
        System.out.println("Write how many ml of water you want to add: ");
        this.water += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        this.milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        this.coffee += sc.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        this.cup += sc.nextInt();
        sc.nextLine();
    }

    private void remaining(){
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " ml of water");
        System.out.println(this.milk + " ml of milk");
        System.out.println(this.coffee + " g of coffee beans");
        System.out.println(this.cup + " disposable cups");
        System.out.println("$" + this.money + " of money");
    }

    private void buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:  ");
        String option = sc.nextLine();
        if (Objects.equals(option, "1")) {
            if(this.water >= 250 && this.coffee >= 16) {
                System.out.println("I have enough resources, making you a coffee!");
                this.water -= 250;
                this.coffee -= 16;
                this.money += 4;
                this.cup -= 1;
            }
            else{
                System.out.println("Sorry, not enough water!");
            }
        }
        else if (Objects.equals(option, "2")) {
            if(water >= 350 && coffee >= 20 && milk >= 75) {
                System.out.println("I have enough resources, making you a coffee!");
                this.water -= 350;
                this.milk -= 75;
                this.coffee -= 20;
                this.money += 7;
                this.cup -= 1;
            }
            else{
                System.out.println("Sorry, not enough water!");
            }
        }
        else if(Objects.equals(option, "3")) {
            if(water >= 200 && coffee >= 12 && milk >= 100) {
                this.water -= 200;
                this.milk -= 100;
                this.coffee -= 12;
                this.money += 6;
                this.cup -= 1;
            }
            else{
                System.out.println("Sorry, not enough water!");
            }
        }
    }

    private void take(){
        System.out.println("I gave you $" + this.money);
        this.money = 0;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine();
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String decision = sc.nextLine();
        while(!decision.equals("exit")) {
            machine.checking(decision);
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            decision = sc.nextLine();
        }
    }
}
