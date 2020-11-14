import java.util.Scanner;

class numbertree {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        if(height == 0) System.out.println("1"); 
        // the root's value = 2 ^ (height+1) - 1
        int root = getRootValue(height); 
        // if there's no specified path -> we're done
        if (!sc.hasNextLine()) {
            System.out.println(root);
            return;
        }

        String command = sc.nextLine().trim();
        char[] directions = command.toCharArray();
        int weight = 1;
        int result = root;
        for (int i = 0; i < directions.length; i++) {
            if (directions[i] == 'L') {
                result = result - weight; 
                weight *= 2;
            } else if (directions[i] == 'R') {
                result = result - weight - 1;
                weight *= 2;
                weight++;
            }
        }
        System.out.println(result);
    }

    static int getRootValue(int height){
        if(height == 0) return 1; 
        return (int) Math.pow(2, height) + getRootValue(--height);
    }
}
