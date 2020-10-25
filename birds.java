import java.util.*;

public class birds{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt(); 
        int dis = sc.nextInt(); 
        int already = sc.nextInt();
        // birds already sitting on the wire are at least 6 cm from the poles and at least 𝑑 centimetres apart from each other.
        // check input 
        // have to be 6cm apart 
        if(len <= 12) System.out.println("0"); 
        // output:  the maximal number of additional birds
        // input positions of birds
        int[] pos = new int[already]; 
        int count = 0; 
        // if no birds on -> start fresh under the constrian 
        if(already == 0){
            int wire = len - 12; 
            // 20/4 = 5; | | | | | | 6 birds
            count += (wire/dis)+1; 
        }else{
            // add already occupied pos
            for(int i=0; i<already; i++){
                pos[i] = sc.nextInt(); 
            }
            Arrays.sort(pos); 

            int leftBound = pos[0]-6; 
            int lastPos = pos[pos.length-1]; 
            int rightBound = len - lastPos - 6;

            count += (leftBound / dis) + (rightBound / dis); 

            // add more birds in between,,,
            for(int i=0; i<already-1; i++){
                int btn = pos[i+1]-pos[i]; 
                count = count + (btn/dis) -1; // !!!!!
                // | * * * | | | 
            }
        }
        System.out.println(count); 
        sc.close();
    } 
}