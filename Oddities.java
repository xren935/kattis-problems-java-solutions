import java.util.Scanner; 

class Oddities{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 
        int no = sc.nextInt(); 
        for(int i=0; i<no; i++){
            int currNum = sc.nextInt(); 
            if(Math.abs(currNum) % 2 == 0){
                System.out.println(currNum + " is even");
            }else{
                System.out.println(currNum + " is odd");
            }
        }
        sc.close();
    }
}