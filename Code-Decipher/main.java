import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Please input operation (encode/decode/exit): ");
        String s = sc.nextLine();
        while(!Objects.equals(s, "exit")) {
            if (!Objects.equals(s, "encode") && !Objects.equals(s, "decode") && !Objects.equals(s, "exit")) {
                System.out.println("There is no '" + s + "' operation");
            }
            if (s.equals("encode")) {
                System.out.println("Input string: ");
                String s1 = sc.nextLine();
                System.out.println("Encoded string: ");
                building_string(s1);
            }
            if (s.equals("decode")) {
                System.out.println("Input encoded string: ");
                String s1 = sc.nextLine();
                String[] charArray = checking_decode(s1);
                if(charArray != null) {
                    decryption(charArray);
                }
            }
            System.out.println("Please input operation (encode/decode/exit): ");
            s = sc.nextLine();
        }
        System.out.println("Bye! ");
    }

    static String[] checking_decode(String s1){
        String[] charArray = null;
        charArray = s1.split(" ");
        int flag = 0;
        if (charArray.length % 2 != 0) {
            System.out.println("Encoded string is not valid. ");
            flag = 1;
        }
        if(flag == 0) {
            for (int i = 0; i < charArray.length; i += 2) {
                if (!Objects.equals(charArray[i], "0") && !Objects.equals(charArray[i], "00")) {
                    System.out.println("Encoded string is not valid. ");
                    flag = 1;
                    break;
                }
            }
        }
        if(flag == 0) {
            for (int i = 0; i < charArray.length; i++) {
                for (int j = 0; j < charArray[i].length(); j++) {
                    if (charArray[i].charAt(j) != '0') {
                        System.out.println("Encoded string is not valid. ");
                        flag = 1;
                        break;
                    }
                }
            }
        }
        if(flag == 1)
            return null;
        else
            return charArray;
    }

    static void generating_code(String s, StringBuilder curr){
        int count = 0;
        int zero_one = -1;
        for(int i = 0; i < curr.length(); i++) {
            if(count == 0){
                if(curr.charAt(i) == '1'){
                    zero_one = 1;
                }
                else
                    zero_one = 0;
            }
            else{
                if(curr.charAt(i) != curr.charAt(i-1)){
                    if(zero_one == 0){
                        System.out.print("00 ");
                        for(int j = 1; j <= count; j ++)
                            System.out.print("0");
                        System.out.print(" ");
                    }
                    else{
                        System.out.print("0 ");
                        for(int j = 1; j <= count; j ++)
                            System.out.print("0");
                        System.out.print(" ");
                    }
                    if(curr.charAt(i) == '1')
                        zero_one = 1;
                    else
                        zero_one = 0;
                    count = 0;
                }
            }
            count += 1;
        }
        if(zero_one == 0){
            System.out.print("00 ");
            for(int j = 1; j <= count; j ++)
                System.out.print("0");
            System.out.print(" ");
        }
        else{
            System.out.print("0 ");
            for(int j = 1; j <= count; j ++)
                System.out.print("0");
            System.out.print(" ");
        }
        System.out.println();
    }

    static void building_string(String s){
        StringBuilder curr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder temp = new StringBuilder(Integer.toBinaryString(s.charAt(i)));
            if(temp.length() == 7)
                curr.append(temp);
            else{
                temp.insert(0,'0');
                curr.append(temp);
            }
        }
        generating_code(s, curr);
    }

    static void decryption(String[] arr){
        String result = "";
        StringBuilder temp = new StringBuilder();
        for(int i = 1; i < arr.length; i+=2){
            if(Objects.equals(arr[i - 1], "0")) {
                for(int j = 0; j < arr[i].length(); j++)
                    temp.append("1");
            }
            else {
                for(int j = 0; j < arr[i].length(); j++)
                    temp.append("0");
            }
        }
        String temp2 = temp.toString();
        if(temp2.length() % 7 != 0)
            System.out.println("Encoded string is not valid.");
        else {
            for (int i = 0; i < temp2.length() / 7; i++) {
                int a = Integer.parseInt(temp2.substring(7 * i, (i + 1) * 7), 2);
                result += (char) (a);
            }

            System.out.println("Decoded string:");
            System.out.println(result);
        }

    }
}
