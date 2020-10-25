import java.util.Scanner;

public class queens {

    public static boolean validate(int r, int c, char[][] board) {
        for (int i = -7; i < 8; i++) {
            // check in all directions...
            if (i != 0) {
                if (r + i >= 0 && r + i < 8 && board[r + i][c] == '*') {
                    return true;
                }
                if (c + i >= 0 && c + i < 8 && board[r][c + i] == '*') {
                    return true;
                }
                if (r + i >= 0 && r + i < 8 && c + i >= 0 && c + i < 8 && board[r + i][c + i] == '*') {
                    return true;
                }
                if (r + i >= 0 && r + i < 8 && c - i >= 0 && c - i < 8 && board[r + i][c - i] == '*') {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean valid = true;
        char[][] board = new char[8][8];
        int count = 0;

        for (int i = 0; i < 8; i++) {
            String str = sc.next();
            for (int j = 0; j < 8; j++){
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (board[i][j] == '*') {
                    count++;
                    if (validate(i, j, board))
                        // System.out.println("invalid");
                        valid = false;
                    break;
                }
            }
        }
        if (count != 8){
            // System.out.println("invalid");
            valid = false; 
        }
        if(valid){
            System.out.println("valid");
        }else{
            System.out.println("invalid");
        }
        // }else{
        //     // System.out.println("valid");
        // }
        sc.close();
    }
}