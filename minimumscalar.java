// to get the smallest -> 
// sort both the arrays and then multiply the smallest to the largest
import java.util.*; 
import java.math.BigInteger; 

public class minimumscalar {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 
        int testCase = sc.nextInt(); 
        int elemNum = sc.nextInt();  
        for(int i=1; i<testCase+1; i++){
            sc.nextLine();
            String firstArg = sc.nextLine();
            String secondArg = sc.nextLine();
            long sum = findSum(firstArg, secondArg); 
            System.out.println("Case #" + i +": "+sum);
        }
    }

    public static Long findSum(String f, String s){
        String[] firstArrStr = f.split(" "); 
        long[] firstArrInt = new long[firstArrStr.length];
        for(int j=0; j<firstArrStr.length; j++){
            firstArrInt[j] = Long.parseLong(firstArrStr[j]); 
        }
       
        String[] secondArrStr = s.split(" "); 
        long[] secondArrInt = new long[secondArrStr.length];
        for(int j=0; j<secondArrInt.length; j++){
            secondArrInt[j] = Long.parseLong(secondArrStr[j]); 
        }

        Arrays.sort(secondArrInt);
        Arrays.sort(firstArrInt); 
        long sum = 0;
        for(int i=0; i<firstArrStr.length; i++){
            long firstEle = firstArrInt[i]; 
            long secondEle = secondArrInt[secondArrInt.length-1-i]; 
            long prod = firstEle*secondEle; 
            sum += prod;
        } 
        return sum;
    }
}
