import java.util.*; 

public class simonsays {
    Scanner io = new Scanner(System.in);
    int [] instructions;
    int noInstruc;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noInstruc = sc.nextInt();
        sc.nextLine();
        String[] instructions = new String[noInstruc]; 
        for(int i=0; i<noInstruc; i++){
            String aLine = sc.nextLine();
            instructions[i] = aLine;
        }
        // for each line cut simon says and output the rest of the line 
        for(int i=0; i<instructions.length; i++){
            String curr = instructions[i]; 
            if(curr.startsWith("Simon says ")){
                String action = curr.replaceFirst("Simon says ", "");
                System.out.println(action);
            }
        }
        // sc.close();
    }
}
