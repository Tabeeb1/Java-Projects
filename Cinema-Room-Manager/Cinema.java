import java.util.Objects;
import java.util.Scanner;

public class Cinema {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Enter the number of rows: ");
        int row = sc.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int seat = sc.nextInt();
        String[][] seats = new String[row + 1][seat + 1];
        fill_seats(seats, row, seat);
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        int choice = sc.nextInt();
        while (choice != 0) {
            if (choice == 1)
                print_initial_cinema(seats, row, seat);
            else if (choice == 2) {
                booking(seats, row, seat);
            }
            else if(choice == 3) {
                show_stats(seats, row, seat);
            }
            else {
                break;
            }
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            choice = sc.nextInt();
        }
    }

    static void show_stats(String[][] seats, int row, int seat){
        int total_seat = row * seat;
        int booked_seat = 0;
        for(int i = 1; i < seats.length; i++){
            for(int j = 0; j < seats[i].length; j++){
                if(seats[i][j].equals("B")){
                    booked_seat++;
                }
            }
        }
        int total = 0;
        int half = row / 2;
        if(row * seat <= 60){
            total = (row * seat) * 10;
        }
        else {
            total += (half * seat) * 10;
            total += ((row - half) * seat) * 8;
        }
        int curr = 0;
        for(int i = 1; i < seats.length; i++){
            for(int j = 0; j < seats[i].length; j++){
                if(seats[i][j].equals("B")){
                    if(i <= half || (row * seat <= 60)){
                        curr += 10;
                    }
                    else
                        curr += 8;
                }
            }
        }

        System.out.println("Number of purchased tickets: " + booked_seat);
        System.out.format("Percentage: %.2f", ((booked_seat * 100.0) / total_seat));
        System.out.println("%");
        System.out.println("Current income: $" + curr);
        System.out.println("Total income: $" + total);

    }

    static void booking(String[][] seats, int row, int seat){
        System.out.println("Enter a row number: ");
        int row_number = sc.nextInt();
        System.out.println("Enter a seat number in that row: ");
        int seat_number = sc.nextInt();
        while(true) {
            if(row_number > row || seat_number > seat) {
                System.out.println("Wrong input!");
                System.out.println("Enter a row number: ");
                row_number = sc.nextInt();
                System.out.println("Enter a seat number in that row: ");
                seat_number = sc.nextInt();
            }
            else if(seats[row_number][seat_number].equals("B")){
                System.out.println("That ticket has already been purchased!");
                System.out.println("Enter a row number: ");
                row_number = sc.nextInt();
                System.out.println("Enter a seat number in that row: ");
                seat_number = sc.nextInt();
            }
            else {
                int half = row / 2;
                if (row_number <= half || seat * row <= 60) {
                    System.out.println("Ticket price: $" + 10);
                } else {
                    System.out.println("Ticket price: $" + 8);
                }
                break;
            }
        }
        seats[row_number][seat_number] = "B";
    }



    static void fill_seats(String[][] seats, int row, int seat) {
        seats[0][0] = "";
        for(int i = 1; i <= seat; i ++){
            seats[0][i] = Integer.toString(i);
        }
        for(int i = 1; i <= row; i ++){
            for(int j = 0; j <= seat; j ++){
                if(j == 0)
                    seats[i][j] = Integer.toString(i);
                else
                    seats[i][j] = "S";
            }
        }
    }



    static void print_initial_cinema(String[][] seats, int row, int seat){
        System.out.println("Cinema: ");
        for(int i = 0; i <= row; i ++){
            for(int j = 0; j <= seat; j ++){
                if(Objects.equals(seats[i][j], ""))
                    System.out.print("  ");
                else
                    System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }

    }
}
