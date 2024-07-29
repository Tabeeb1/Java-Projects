import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Input the length of the secret code: ");
        String s = sc.nextLine();
        int n = 0;
        int flag = 0;
        try{
            n = Integer.parseInt(s);
        } catch(Exception e){
            System.out.println("Error: " + s + " isn't a valid number.");
            flag = 1;
        }
        if(n < 1) {
            System.out.println("error");
            System.exit(0);
        }
        if(flag == 0) {
            System.out.println("Input the number of possible symbols in the code: ");
            String s1 = sc.nextLine();
            int char_limit = 0;
            int flag1 = 0;
            try{
                char_limit = Integer.parseInt(s1);
            } catch(Exception e){
                System.out.println("Error: " + s1 + " isn't a valid number.");
                flag1 = 1;
            }
            if(flag1 == 0) {
                if(char_limit < n){
                    System.out.println("Error: it's not possible to generate a code with a length of " + n + " with " + char_limit + " unique symbols.");
                }
                else if(char_limit > 36){
                    System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                }
                else {
                    n = take_number(n);
                    generate(n, char_limit);
                }
            }
        }
    }

    static int take_number(int n){
        while(n > 36) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            n = sc.nextInt();
        }
        return n;
    }

    static void playing(String s, ArrayList<Character> arr) {
        System.out.println("Okay, let's start a game! ");
        int turn = 1;
        while (true){
            System.out.println("Turn " + turn + ":");
            String answer = sc.nextLine();
            int bulls = 0;
            int cows = 0;
            for(int i = 0; i < s.length(); i++){
                int checking = 0;
                for(int x = 0; x < arr.size(); x++){
                    if(s.charAt(i) == arr.get(x))
                        checking = 1;
                }
                for(int j = 0; j < answer.length(); j++){
                    if(s.charAt(i) == answer.charAt(j) && checking == 1){
                        if(i == j)
                            bulls ++;
                        else
                            cows ++;
                    }
                }
            }
            if(bulls == s.length()){
                System.out.println("Grade: " + bulls + " bulls" );
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }
            else{
                if(cows == 0 && bulls == 0){
                    System.out.println("Grade: None");
                }
                else if(bulls == 0){
                    if(cows == 1)
                        System.out.println("Grade: " + cows + " cow" );
                    else
                        System.out.println("Grade: " + cows + " cows" );

                }
                else if (cows == 0){
                    if(bulls == 1)
                        System.out.println("Grade: " + bulls + " bull" );
                    else
                        System.out.println("Grade: " + bulls + " bulls" );
                }
                else{
                    if(cows == 1 && bulls == 1)
                        System.out.println("Grade: " + bulls + " bull and " + cows + " cow" );
                    else if(cows > 1 && bulls > 1)
                        System.out.println("Grade: " + bulls + " bulls and " + cows + " cows" );
                    else if(cows == 1 && bulls > 1)
                        System.out.println("Grade: " + bulls + " bulls and " + cows + " cow" );
                    else
                        System.out.println("Grade: " + bulls + " bull and " + cows + " cows" );
                }
            }
            turn ++;
            System.out.println();
        }
    }

    static void generate(int n, int char_limit) {
        ArrayList<Character> arr = new ArrayList<>();
        characters_to_print(char_limit, arr);
        if(arr.size() <= 10){
            System.out.print("The secret is prepared: ");
            for(int i = 1; i <= n; i ++)
                System.out.print("*");
            System.out.println(" (0-" + arr.get(arr.size()-1) + ").");
        }
        else{
            System.out.print("The secret is prepared: ");
            for(int i = 1; i <= n; i ++)
                System.out.print("*");
            System.out.println(" (0-9, " + arr.get(10) + "-" + arr.get(arr.size()-1) + ").");
        }
        StringBuilder sb = new StringBuilder();
        Collections.shuffle(arr);
        for(int i = 0; i < n; i++)
            sb.append(arr.get(i));
        playing(sb.toString(), arr);
    }

    static void characters_to_print(int char_limit, ArrayList<Character> final_one){
        char[] numbers = {'0', '1' , '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] alphabets = new char[26];
        for (int i = 0; i < 26; i++) {
            alphabets[i] = (char) ('a' + i);
        }
        if(char_limit <= 10){
            for(int i = 0; i < char_limit; i ++)
                final_one.add(numbers[i]);
        }
        else{
            for(int i = 0; i < numbers.length; i ++)
                final_one.add(numbers[i]);
            int z = 0;
            for(int i = 10; i < char_limit; i ++)
                final_one.add(alphabets[z++]);
        }
    }
}
