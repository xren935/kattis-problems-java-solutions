import java.util.*; 

public class internet{
    static boolean[] connected; 
    // no duplicates
    static Map<Integer, HashSet<Integer>> map; 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 
        int noHouse = sc.nextInt();
        int deployed = sc.nextInt(); //num of lines
        int cnt = 0;
        sc.nextLine();
        // a set of nodes for each node
        map = new HashMap<>(); 
        for(int i=1; i<noHouse+1; i++){
            map.put(i, new HashSet<>());
        }
        connected = new boolean[noHouse+1];

        for(int i=0; i<deployed; i++){
            int firstArg = sc.nextInt(); 
            int secondArg = sc.nextInt(); 
            map.get(firstArg).add(secondArg);
            map.get(secondArg).add(firstArg);
        }
        sc.close();
        // visit the first one by default 
        dfs(1); 
 
        for(int i=1; i<deployed+1; i++){
            if(!connected[i]){
                cnt++;
                break;
            }
        }
        if(cnt > 0){
            for(int i=1; i<=noHouse; i++){
                if(!connected[i]){
                    System.out.println(i);
                }
            }
        }else{
            System.out.println("connected");
        }
    }
    // dfs 
    static void dfs(int n){
        // visit 
        connected[n] = true; 
        HashSet<Integer> adjs = map.get(n); 
        for(int i=0; i<adjs.size()-1; i++){
            if(!connected[i]){
                dfs(i);
            }
        }
    }

    // static void visit(int f, int s){
    //     if(connected[f-1]){
    //         connected[s-1] = true;
    //     }
    //     if(connected[s-1]){
    //         connected[f-1] = true;
    //     }
    // }
}