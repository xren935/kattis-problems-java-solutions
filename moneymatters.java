// to get the smallest -> 
// sort both the arrays and then multiply the smallest to the largest
import java.util.*; 
import java.io.*; 

public class moneymatters {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 
        int numNodes = sc.nextInt(); 
        int numEdges = sc.nextInt();  
        int[] friends = new int[numNodes];
        for(int i=0; i<numNodes; i++){
            friends[i] = sc.nextInt();
        }

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        // init. map 
        for(int i=0; i<numEdges; i++){
            int a = sc.nextInt();
            int b = sc.nextInt(); 
            if(map.get(a) == null){
                map.put(a, new HashSet<Integer>());
            }
            if(map.get(b) == null){
                map.put(b, new HashSet<Integer>());
            }
            map.get(a).add(b);
            map.get(b).add(a);
        }  
        
        boolean[] visited = new boolean[numNodes];
        boolean result = true;
        for(int i=0; i<numNodes && result; i++){
            if(visited[i] == false){
                result = bfs(friends, map, visited, i);
            }
        }
        if(result){
            System.out.println("POSSIBLE");
        }else{ 
            System.out.println("IMPOSSIBLE");
        }
        sc.close();
    }

    public static boolean bfs(int[] friends, HashMap<Integer, HashSet<Integer>> map, boolean[] visited, int i){
        LinkedList<Integer> queue = new LinkedList<>();
		queue.add(i);
		int total = 0;
		while (!queue.isEmpty()) {
			int curr = queue.remove();
			if (visited[curr]) {
				continue;
			}
			visited[curr] = true;
			total += friends[curr];
			for (Integer n : map.get(curr)) {
				if (!visited[n]) {
					queue.add(n);
				}
			}
        }

		return total == 0;
    }
}
