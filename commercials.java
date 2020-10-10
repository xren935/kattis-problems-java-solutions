import java.util.*; 
// input: 
// 6 20
// 18 35 6 80 15 21
// processed: -2 15 -14 60 -5 1  
// -> selects the subsequence that has the largest sum that has length <= 6
// ouputs the sum of the elements in that subsequence 

class commercials{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 
        int noBreaks = sc.nextInt(); // get the # of commercial breaks
        int price = sc.nextInt(); // get the price of one commercial break
        int[] processed = new int[noBreaks];
        for(int i=0; i<noBreaks; i++){
            processed[i] = (sc.nextInt() - price);
        }
        System.out.println(maxSub(processed));
    }

    public static int maxSub(int[] seq){
        // use Kadane's Algorithm 
        // to find the largest sum of a continuous subarray inside the given arr 
        // for each index, compare the element with that element with the max from before 
        int[] max = new int[seq.length]; 
        max[0] = seq[0]; 
        for(int i=1; i<seq.length; i++){
            max[i] = Math.max(max[i-1]+seq[i], seq[i]); 
        }
        // because the subarry can be of length 1 to seq.length
        // max isn't necessarily the last element 
        Arrays.sort(max); 
        return max[max.length-1];
    }
}