import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("How many pencils would you like to use:");
        String s = sc.nextLine();
        int a = initialValueCheck(s);
        a = checkZero(a);
        a = checkNegative(a);
        String player1 = "John";
        String player2 = "Jack";
        String player = firstPlayer(player1, player2);
        System.out.println(rotating(a,player,player1,player2) + " " + "won!");

    }

    static int initialValueCheck(String s){
        boolean numeric = false;
        int a = 0;
        while(!numeric) {
            try {
                a = Integer.parseInt(s);
                numeric = true;
            } catch (NumberFormatException e) {
                System.out.println("The number of pencils should be numeric, please try again");
                s = sc.next();
            }
        }
        return a;
    }

    static int checkZero(int a){
        if(a == 0){
            while(a == 0){
                System.out.println("The number of pencils should be positive, please try again");
                String s = sc.next();
                a = initialValueCheck(s);
            }
        }
        return a;
    }

    static int checkNegative(int a){
        if(a < 0){
            while(a < 0){
                System.out.println("The number of pencils should be numeric, please try again");
                String s = sc.next();
                a = initialValueCheck(s);
            }
        }
        return a;
    }

    static String firstPlayer(String player1, String player2){
        System.out.println("Who will be the first (" + player1 + ", " + player2 + "):");
        String player = sc.next();
        if(!player.equals(player1) && !player.equals(player2)){
            while(!Objects.equals(player, player1) && !Objects.equals(player, player2)){
                System.out.println("Choose between '" + player1 + "' and '" + player2 +"'");
                player = sc.next();
            }
        }
        return player;
    }

    static String rotating(int a, String player, String player1, String player2){
        String bot = player2;
        String result1 = "";
        if(player.equals(player1)) {
            result1 = player1;
            while (a > 0) {
                for (int i = 1; i <= a; i++)
                    System.out.print('|');
                System.out.println();
                System.out.println(result1 + "'s turn!");
                if(result1.equals(bot)){
                    if(a == 1){
                        System.out.println(1);
                        a -= 1;
                    }
                    else if(a % 4 == 1){
                        Random random = new Random();
                        int randomInt = random.nextInt(3) + 1;
                        System.out.println(randomInt);
                        a -= randomInt;
                    }
                    else if(a % 4 == 0) {
                        System.out.println(3);
                        a -= 3;
                    }
                    else if(a % 4 == 3){
                        System.out.println(2);
                        a -= 2;
                    }
                    else if(a % 4 == 2){
                        System.out.println(1);
                        a -= 1;
                    }
                    result1 = player1;
                }
                else {
                    String s = sc.next();
                    int d = initialValueCheck(s);
                    d = checkMaxValue(d);
                    d = possibleValue(a, d);
                    a -= d;
                    result1 = player2;
                }
            }
            if(result1.equals(bot))
                return player2;
            else
                return player1;
        }
        else {
            result1 = player2;
            while (a > 0) {
                for (int i = 1; i <= a; i++)
                    System.out.print('|');
                System.out.println();
                System.out.println(result1 + "'s turn!");
                if(result1.equals(bot)){
                    if(a == 1){
                        System.out.println(1);
                        a -= 1;
                    }
                    else if(a % 4 == 1){
                        Random random = new Random();
                        int randomInt = random.nextInt(3) + 1;
                        System.out.println(randomInt);
                        a -= randomInt;
                    }
                    else if(a % 4 == 0) {
                        System.out.println(3);
                        a -= 3;
                    }
                    else if(a % 4 == 3){
                        System.out.println(2);
                        a -= 2;
                    }
                    else if(a % 4 == 2){
                        System.out.println(1);
                        a -= 1;
                    }
                    result1 = player1;
                }
                else {
                    String s = sc.next();
                    int d = initialValueCheck(s);
                    d = checkMaxValue(d);
                    d = possibleValue(a, d);
                    a -= d;
                    result1 = player2;
                }
            }
            if(result1.equals(bot))
                return player2;
            else
                return player1;
        }
    }

    static int checkMaxValue(int a){
        while(a < 1 || a > 3){
            System.out.println("Possible values: '1', '2', '3'");
            String s = sc.next();
            a = maxValueConfirm(s);
        }
        return a;
    }

    static int maxValueConfirm(String s){
        boolean numeric = false;
        int a = 0;
        while(!numeric) {
            try {
                a = Integer.parseInt(s);
                numeric = true;
            } catch (NumberFormatException e) {
                System.out.println("Possible values: '1', '2', '3'");
                s = sc.next();
            }
        }
        return a;
    }

    static int possibleValue(int a,int d){
        while(d > a){
            System.out.println("Too many pencils were taken");
            d = sc.nextInt();
        }
        return d;
    }
}
