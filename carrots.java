import java.util.*; 

public class carrots {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arg1;
        int arg2; 
        arg1 = sc.nextInt(); 
        arg2 = sc.nextInt(); 
        sc.nextLine();
        List<String> a = new ArrayList<>(); 
        for(int i=0; i<arg1; i++){
            String curr = sc.nextLine(); 
            a.add(curr);
        }
        System.out.println(arg2); 
    }
}
