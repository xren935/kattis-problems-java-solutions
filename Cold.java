import java.util.Scanner; 
class Cold{
 public static void main(String[] args){
    Scanner sc = new Scanner(System.in); 
    int no = sc.nextInt(); 
    int counter = 0; 
    for(int i=0; i<no; i++){
        int currTemp = sc.nextInt(); 
        if(currTemp < 0){
            counter++;
        }
    }
    System.out.println(counter);
    sc.close();
 }   
}