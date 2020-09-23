
// you can find the question here: https://open.kattis.com/problems/virtualfriends
import java.util.*;

// !!!! Time Limit Exceeded T-T 
// Working on fixing it ... 

public class virtualfriends {
    // using union-find
    static int[] parent;
    static int[] size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noCases = Integer.parseInt(sc.nextLine());
        parent = new int[100000];
        size = new int[100000];
        for (int i = 0; i < noCases; i++) {
            int noPairs = Integer.parseInt(sc.nextLine());
            for (int j = 0; j <= noPairs; j++) {
                // set the curr node's parent to itself 
                parent[j] = j;
                size[j] = 1;
            }
            int cur = 0;
            Hashtable<String, Integer> table = new Hashtable<String, Integer>(); // maps aFriend to the number of friends aFriend has
            for (int j = 0; j < noPairs; j++) {
                String[] s = sc.nextLine().split(" ");
                String firstFriend = s[0];
                String secondFriend = s[1];
                // int x and y represent the number of friends each friend has 
                int x = 0, y = 0;
                if (table.containsKey(firstFriend)){
                    // already in the table, get its parent 
                    x = table.get(firstFriend);
                }else {
                    // add to the table 
                    x = cur;
                    table.put(firstFriend, cur);
                    cur++; // one more frined in the network 
                }
                // do the same to the second friend 
                if (table.containsKey(secondFriend)){
                    y = table.get(secondFriend);
                }else {
                    y = cur;
                    table.put(secondFriend, cur);
                    cur++;
                }
                // the total number of friends in the network is 
                // the union of (the number of friends of firstFriend + the # of friends of secondFriend)
                union(x, y);
                // either x or y's parent;s number of friends would be the result(i.e. total number of friends in the network)
                System.out.println(size[findSet(x)]);
            }
            sc.close();
        }
    }

    // findSet returns the parent of a given element
    public static int findSet(int i) {
        if (parent[i] == i)
            return i;
        return findSet(parent[i]);
    }

    // isSameSet returns true if the two given elements are in the same set by checking their parents
    public static boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    // union merges two sets
    public static void union(int i, int j) {
        if (!isSameSet(i, j)) {
            size[findSet(j)] += size[findSet(i)];
            parent[findSet(i)] = findSet(j);
        }
    }
}