import java.util.*;
import java.io.*;

public class wheresmyinternet {
    private static int number_of_cables;
    private static int number_of_houses;
    private static ArrayList<ArrayList<Integer>> adjList;

    public static void scan() {
        try (BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLine = buffReader.readLine().split(" ");
            number_of_houses = Integer.parseInt(firstLine[0]);
            number_of_cables = Integer.parseInt(firstLine[1]);
            adjList = new ArrayList<>();
            for (int i = 0; i <= number_of_houses; ++i) {
                adjList.add(new ArrayList<>());
            }
            for (int i = 0; i < number_of_cables; ++i) {
                String[] cable = buffReader.readLine().split(" ");
                int firstHouse = Integer.parseInt(cable[0]);
                int secondHouse = Integer.parseInt(cable[1]);

                adjList.get(firstHouse).add(secondHouse);
                adjList.get(secondHouse).add(firstHouse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void run() {
        scan();
        ArrayList<Integer> ans = dfs(1);
        printans(ans);
    }

    public static void printans(ArrayList<Integer> ans){
        try (BufferedWriter buffWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            if (ans.size() == 0) {
                buffWriter.write("Connected\n");
            } else {
                for (int i : ans) {
                    buffWriter.write(i + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        run();
    }

    private static ArrayList<Integer> dfs(int source) {
        boolean[] isVisited = new boolean[number_of_houses + 1];
        recur(source, isVisited);
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 1; i <= number_of_houses; ++i) {
            if (!isVisited[i]) {
                output.add(i);
            }
        }
        return output;
    }

    private static void recur(int current, boolean[] visited) {
        visited[current] = true;
        for (int neighbour : adjList.get(current)) {
            if (!visited[neighbour]) {
                recur(neighbour, visited);
            }
        }
    }

}
