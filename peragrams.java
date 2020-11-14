import java.util.*;

public class peragrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] alp = new int[26];
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);
            alp[Character.getNumericValue(a) - 10]++;
        }
        for(int i = 0; i < 26; i++) if(alp[i] % 2 != 0) count++;
        if(count <= 0) System.out.println(0);
        else System.out.println(count-1);
    }
}