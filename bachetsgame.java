// https://open.kattis.com/problems/bachetsgame
import java.util.*; 

class bachetsgame {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int noStones = sc.nextInt(); 
            boolean[] result = new boolean[noStones+1];
            int noMoves = sc.nextInt(); 
            int[] steps = new int[noMoves];
            // fill the steps arr with the possible moves 
            for(int i=0; i<steps.length; i++){
                steps[i] = sc.nextInt(); 
            }
            // any position with a multiple (aPossibleStep) + 1 is a losing position.
            for(int j=0; j<noStones+1; j++){
                for(int k=0; k<steps.length; k++){
                    if(j+steps[k] <= noStones){
                        result[j+steps[k]] |=!result[j];
                    }
                }
            }
            if(result[noStones]){
                System.out.println("Stan wins");
            }else{
                System.out.println("Ollie wins");
            }
        }

    }
}