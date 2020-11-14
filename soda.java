import java.util.*;
public class soda {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int emptyStart = sc.nextInt(); // the number of empty soda bottles at the beginning
        int emptyDuring = sc.nextInt(); // the number of empty soda bottles found during the day
        int emptyRequired = sc.nextInt(); // the number of empty bottles required to buy a new soda
        sc.close();
        int empties = emptyStart + emptyDuring;
        int numDrank = 0;
        while (empties >= emptyRequired) {
            int filled = empties / emptyRequired;
            empties = empties % emptyRequired + filled;
            numDrank += filled;
        }
        System.out.println(numDrank);
    }
}