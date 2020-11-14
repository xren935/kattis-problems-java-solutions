import java.util.*; 
import java.io.*; 


public class phonelist {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 
        int totalTestCases = sc.nextInt();
        
        for(int i=0; i<totalTestCases; i++){
            List<String> nums = new ArrayList<String>(); 
            int testC = sc.nextInt(); 
            for(int j=0; j<testC; j++){
                String curr = sc.next();
                nums.add(curr);
            }
            Collections.sort(nums);
            boolean consis = true;
    
            for(int k=1; k<testC; k++){
                if(nums.get(k).length() > nums.get(k-1).length()){
                    if(nums.get(k).substring(0, nums.get(k-1).length()).equals(nums.get(k-1))){
                        consis = false;
                    }
                }else{
                    if(nums.get(k-1).substring(0, nums.get(k).length()).equals(nums.get(k))){
                        consis = false;
                    }
                }
            }
                if(consis){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }

        }
     
  
        // for(int i=0; i<totalTestCases; i++){
        //     int nums = sc.nextInt();
        //     String[] phones = new String[nums];
        //     for(int j=0; j<nums; j++){
        //         phones[j] = sc.nextLine();
        //     }
        //     Arrays.sort(phones);
        //     boolean consis = true;
        //     for(int k=0; k<phones.length; k++){
        //         if(phones[k].startsWith(phones[k-1])){
        //             consis = false;
        //             break;
        //         }
        //     }
        //     if(consis){
        //         System.out.println("YES");
        //     }else{
        //         System.out.println("NO");
        //     }
        // 
    }
}
