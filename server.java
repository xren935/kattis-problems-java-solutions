import java.util.*; 
import java.io.*; 


public class server {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        int allowedTime = sc.nextInt();
        int totalTime = 0;
        int result = 0; 
        for(int i=0; i<n; i++){
            int currT = sc.nextInt();
            if(totalTime + currT <= allowedTime){
                totalTime += currT; 
                result++; 
            }else{
                break;
            }
        }
        System.out.println(result);
    }
}
