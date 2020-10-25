import java.util.*; 
public class printer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int statues = sc.nextInt();
        int printers = 1;
        int printed = 0;
        int days = 0;
        while(printed < statues){
            if((statues-printed) > printers){
                days++;
                printers += printers;
            }
            else {
                days++;
                printed += printers;
            }
        }
        
        System.out.println(days);
        sc.close();
    }
}