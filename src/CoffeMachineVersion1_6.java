import java.util.Scanner;

public class CoffeMachineVersion1_6 {
    static int amountOfWater = 400,
            amountOfMilk = 540,
            coffeeBeans = 120,
            disposableCups = 9,
            money = 550;
    static String choice=null;
    static Scanner sc; //receive user input

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        selectionMenu();
    }


    public static void selectionMenu() {
        do {
            welcomeMenu();
            System.out.println("\nWrite action (buy, fill, take,remaining and exit):");
            choice = sc.next();
            switch (choice) {
                case "buy" : buy();break;
                case "fill" : fill();break;
                case "take" : take();break;
                case "remaining" : remaining();break;

            }
            //loops the question to keep asking if the user does't input exit

        } while (!choice.equals("exit"));

    }
    public static void exit () {
        //this method will terminate the program
        System.exit(0);
    }

    public static void welcomeMenu() {
        System.out.println("*****************************************");
        System.out.println("* Welcome to Coffee Machine Menu!       *");
        System.out.println("*****************************************");
    }


    public static void fill() {
    // getting input from user and adding to the value


        System.out.println("Write how many ml of water you want to add: ");
        amountOfWater += sc.nextInt();//Adding to the total of water

        System.out.println("Write how many ml of milk you want to add: ");
        amountOfMilk += sc.nextInt();//adding to the total of milk

        System.out.println("Write how many grams of coffee beans you want to add: ");
        coffeeBeans += sc.nextInt();//adding to the total of coffee beans

        System.out.println("Write how many disposable cups of coffee you want to add: ");
        disposableCups += sc.nextInt();//adding to the total of disposable cups
    }

    public static void take() {
        System.out.println("I gave you $" + money);
        money -= money;//subtracts all the money available to make it ZERO

    }

    private static void buy() {

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        //prompts the user to enter one of the available choices
        String choiceBuy = sc.next();
        int cup = 1;

        switch (choiceBuy) {
            case "1":
                espresso(cup);
                break;
            case "2":
                latte(cup);
                break;
            case "3":
                cappuccino(cup);
                break;
            case "back":
                selectionMenu();
                break;
        }
    }

    public static void espresso(int cup) {
        // checking to see if there's enough resource to make coffee
        // needs 250 water--16 coffee beans -- cost $4
        if (250 * cup > amountOfWater) {//checks if there's enough water
            System.out.println("Sorry, not enough water!\n");
        }
        if (16 * cup > coffeeBeans) {//checks if there's enough coffee beans
            System.out.println("Sorry, not enough coffee beans!\n");
        }
        if (cup > disposableCups) {//checks if there's enough cups
            System.out.println("Sorry, not enough disposable cups!\n");
        }
        // if there's enough resource to make the desire amount
        if (250 * cup < amountOfWater && 16 * cup < coffeeBeans && cup < disposableCups) {
            System.out.println("I have enough resources, making you a coffee!\n");

            // calculating the values, it will subtract from the resources
            amountOfWater -= 250 * cup;
            coffeeBeans -= 16 * cup;
            disposableCups -= cup;
            money += 4 * cup;//adding to the value
        }
    }


    // latte method
    public static void latte(int cup) {
        // condition to check resources
        // needs 350 water -- 75 milk -- 20 coffee beans --cost $7
        if (350 * cup > amountOfWater) {//checks if there's enough water
            System.out.println("Sorry, not enough water!\n");
        }
        if (75 * cup > amountOfMilk) {//checks if there's enough water
            System.out.println("Sorry, not enough milk!\n");
        }
        if (20 * cup > coffeeBeans) {//checks if there's enough coffee beans
            System.out.println("Sorry, not enough coffee beans!\n");
        }
        if (cup > disposableCups) {//checks if there's enough cups
            System.out.println("Sorry, not enough disposable cups!\n");
        }
        // if there's enough resource to make the desire amount
        if (350 * cup < amountOfWater && 75 * cup < amountOfMilk &&
                20 * cup < coffeeBeans && cup < disposableCups) {
            System.out.println("I have enough resources, making you a coffee!\n");
            amountOfWater -= 350 * cup;
            amountOfMilk -= 75 * cup;
            coffeeBeans -= 20 * cup;
            disposableCups -= cup;
            money += 7 * cup;
        }
    }


    // cappuccino method
    public static void cappuccino(int cup) {
        // condition to check resources
        // needs 350 water -- 75 milk -- 20 coffee beans --cost $7
        if (350 * cup > amountOfWater) {//checks if there's enough water
            System.out.println("Sorry, not enough water!\n");
        }
        if (75 * cup > amountOfMilk) {//checks if there's enough water
            System.out.println("Sorry, not enough milk!\n");
        }
        if (20 * cup > coffeeBeans) {//checks if there's enough coffee beans
            System.out.println("Sorry, not enough coffee beans!\n");
        }
        if (cup > disposableCups) {//checks if there's enough cups
            System.out.println("Sorry, not enough disposable cups!\n");
        }
        // if there's enough resource to make the desire amount
        if (200 * cup < amountOfWater && 100 * cup < amountOfMilk &&
                12 * cup < coffeeBeans && cup < disposableCups) {
            System.out.println("I have enough resources, making you a coffee!\n");
            amountOfWater -= 200 * cup;
            amountOfMilk -= 100 * cup;
            coffeeBeans -= 12 * cup;
            disposableCups -= cup;
            money += 6 * cup;
        }
    }

    public static void remaining() {
        //simple print methods to give what it remains in the coffee machine
        System.out.println("\nThe coffee machine has:");
        System.out.println(amountOfWater + " ml of water");
        System.out.println(amountOfMilk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + money + " of money");
    }


}