import java.util.*; 

public class plantingtrees {
    Scanner io = new Scanner(System.in);
    int [] trees;
    int numberOfSeeds;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTrees = sc.nextInt();
        // save the time intervals in an array
        int[] intervals = new int[numTrees]; 
        int treePtr = 0;
        for(int i=0; i<numTrees; i++){
            intervals[treePtr] = sc.nextInt(); 
            treePtr++;
        }
        sc.close();
        // sort intervals to plant the "longest" tree first
        Arrays.sort(intervals);
        // base case, because interval[i]>=1 and there's one or more trees
        int sum = 2;
        int currDays = 0; 
        int ptr = 0; 
        for(int i=intervals.length-1; i>=0; i--){
            //add curr tree to sum
            intervals[i] = intervals[i] - numTrees + ptr;
            sum++;
            ptr++;
        }
        for(int i=intervals.length-1; i>=0; i--){
            if(intervals[i] > currDays){
                currDays = intervals[i];
            }
        }
        sum = sum + currDays; 
        System.out.println(sum);
    }
}