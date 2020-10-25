// import java.util.*;

// // BFS. Searching through all neighbours of each given node and use
// // visited to check if the vertex is already counted or not..
// public class domi {
//     private int V; // no. of vertices
//     private LinkedList<Integer> adj[]; // Adjacency Lists
//     boolean[] visited; 
//     public static void main(String[] args){
//         // visited
//         Scanner sc = new Scanner(System.in);
//         sc.nextInt();
//     }
//     // Constructor
//     domi(int v) {
//         V = v;
//         adj = new LinkedList[v];
//         for (int i = 0; i < v; ++i)
//             adj[i] = new LinkedList();
//     }

//     // add an edge into the graph
//     void addEdge(int v, int w) {
//         adj[v].add(w);
//     }

//     void BFS(int s) 
//     { 
//         // Mark all the vertices as not visited(By default 
//         // set as false) 
//         boolean visited[] = new boolean[V]; 
  
//         // Create a queue for BFS 
//         LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
//         // Mark the current node as visited and enqueue it 
//         visited[s]=true; 
//         queue.add(s); 
  
//         while (queue.size() != 0) 
//         { 
//             // Dequeue a vertex from queue and print it 
//             s = queue.poll(); 
//             System.out.print(s+" "); 
  
//             // Get all adjacent vertices of the dequeued vertex s 
//             // If a adjacent has not been visited, then mark it 
//             // visited and enqueue it 
//             Iterator<Integer> i = adj[s].listIterator(); 
//             while (i.hasNext()) 
//             { 
//                 int n = i.next(); 
//                 if (!visited[n]) 
//                 { 
//                     visited[n] = true; 
//                     queue.add(n); 
//                 } 
//             } 
//         } 
        

// }
// // public class domi {
// // // List<Integer> adj = new ArrayList<>();
// // Stack<Integer> adj = new Stack<>();
// // public static void main(String[] args) {
// // Scanner sc = new Scanner(System.in);
// // int cases = sc.nextInt();
// // sc.nextLine();
// // for(int i=0; i<cases; i++){
// // int n,m,l;
// // n = sc.nextInt();
// // m = sc.nextInt();
// // l = sc.nextInt();
// // for(int j=0; j<m; j++){
// // int a, b;
// // a = sc.nextInt();
// // b = sc.nextInt();
// // a--;
// // b--;
// // adj.push(b);
// // }

// // }
// // sc.close();
// // }

// // void knock(int[] adj, boolean[] visited, int curr){
// // if(visited[curr]){
// // return;
// // }
// // visited[curr] = true;
// // for(int i=0; i<adj[curr]; i++){
// // knock(adj, visited, i);
// // }

// // }

// // }
import java.util.*;

public class domi {
    public static void dfs(boolean[][] d, boolean[] visited, int node) {
        for (int j = 0; j < d.length; j++) {
          if (d[node][j] && !visited[j]) {
            visited[j] = true;
            dfs(d, visited, j);
          }
        }
      }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cases = sc.nextInt();
    for (int t = 0; t < cases; t++) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int l = sc.nextInt();

      boolean[][] knock = new boolean[n][n];
      boolean[] visited = new boolean[n];

      for (int i = 0; i < m; i++) {
        int x = sc.nextInt()-1;
        int y = sc.nextInt()-1;

        knock[x][y] = true;
      }

      for (int i = 0; i < l; i++) {
        int z = sc.nextInt() - 1;
        if (!visited[z]) {
          visited[z] = true;
          dfs(knock, visited, z);
        }
      }
      int knocked = 0;
      for (int i = 0; i < n; i++) {
        if (visited[i]) {
          knocked++;
        }
      }
      System.out.println(knocked);

    }
  }
}