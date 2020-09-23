
// the question is here: https://open.kattis.com/problems/guessthedatastructure
import java.util.*;
import java.io.*;

class guessthedatastructure {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ln; 
        while ((ln = br.readLine())!= null) {
            int noCases = Integer.parseInt(ln);
            // brutal force method:
            // create all the possible data structures and perform the operpations on those
            // structures
            // see if the given output matches what the structures should behave
            Stack<Integer> aStack = new Stack<>();
            boolean isStack = true;
            Queue<Integer> aQueue = new LinkedList<>();
            boolean isQueue = true;
            PriorityQueue<Integer> aPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            boolean isPriorityQueue = true;

            for (int i = 0; i < noCases; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op =  st.nextToken();
                int value = Integer.parseInt(st.nextToken());
                if (op.equals("1")) {
                    if (isStack)
                        aStack.push(value);
                    if (isQueue)
                        aQueue.offer(value);
                    if (isPriorityQueue)
                        aPriorityQueue.offer(value);
                } else if (op.equals("2")) {
                    if (isStack && (aStack.size() == 0 || !aStack.pop().equals(value)))
                        isStack = false;
                    if (isQueue && (aQueue.size() == 0 || !aQueue.poll().equals(value)))
                        isQueue = false;
                    if (isPriorityQueue && (aPriorityQueue.size() == 0 || !aPriorityQueue.poll().equals(value)))
                        isPriorityQueue = false;
                }
            }

            if (!isStack && !isQueue && !isPriorityQueue) {
                System.out.println("impossible");
            } else if ((isStack && isQueue) || (isStack && isPriorityQueue) || (isQueue && isPriorityQueue)) {
                System.out.println("not sure");
            } else if (isStack) {
                System.out.println("stack");
            } else if (isQueue) {
                System.out.println("queue");
            } else {
                System.out.println("priority queue");
            }
        }
    }
}