import java.util.*;


public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        filling_board(board);
        printing_board(board);
        int z = 1;
        int flag = 0;
        char s = 'X';
        while(z <= 9) {
            number_checking(board, s);
            printing_board(board);
            if(x_wins(board)){
                System.out.println("X wins");
                flag = 1;
                break;
            }
            if(o_wins(board)){
                System.out.println("O wins");
                flag = 1;
                break;
            }
            z += 1;
            if(s == 'X')
                s = 'O';
            else
                s = 'X';
        }
        if(flag == 0){
            System.out.println("Draw");
        }
    }


    static boolean o_wins(char[][] board){
        if(board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O')
            return true;
        else if(board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O')
            return true;
        else if(board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O')
            return true;
        else if(board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O')
            return true;
        else if(board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O')
            return true;
        else if(board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O')
            return true;
        else if(board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')
            return true;
        else if(board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')
            return true;
        return false;
    }




    static boolean x_wins(char[][] board){
        if(board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X')
            return true;
        else if(board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X')
            return true;
        else if(board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X')
            return true;
        else if(board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X')
            return true;
        else if(board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X')
            return true;
        else if(board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X')
            return true;
        else if(board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')
            return true;
        else if(board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')
            return true;
        return false;
    }


    static void printing_board(char[][] board) {
        System.out.println("---------");
        for(int i = 0; i < 3; i ++){
            System.out.print("| ");
            for(int j = 0; j < 3; j ++){
                if(board[i][j] != '_')
                    System.out.print(board[i][j] + " ");
                else
                    System.out.print("  ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    static void number_checking(char[][] board, char s) {
        boolean flag = true;
        while(flag) {
            String x;
            String y;
            int a = 0;
            int b = 0;
            int check = 0;
            boolean flag2 = true;
            while(flag2) {
                try {
                    System.out.println("Enter row: ");
                    x = sc.next();
                    System.out.println("Enter column: ");
                    y = sc.next();
                    sc.nextLine();
                    a = Integer.parseInt(x);
                    b = Integer.parseInt(y);
                    flag2 = false;
                } catch (Exception e) {
                    System.out.println("You should enter numbers!");
                }
            }
            if(a > 3 || b > 3){
                check = 1;
                System.out.println("Coordinates should be from 1 to 3!");
            }
            else if(board[a-1][b-1] != '_'){
                check = 1;
                System.out.println("This cell is occupied! Choose another one!");
            }
            if(check == 0) {
                flag = false;
                board[a - 1][b - 1] = s;
            }
        }
    }

    static void filling_board(char[][] board) {
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                board[i][j] = '_';
            }
        }
    }
}
