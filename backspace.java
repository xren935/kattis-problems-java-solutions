// https://open.kattis.com/problems/backspace
import java.util.*; 
import java.io.*; 

public class backspace { 
    public static void main(String[] args){
        // when encounter a '<' -> delete the previous char and move ptr back one space
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            char[] oneLine = br.readLine().toCharArray();
            char[] processed = new char[oneLine.length];
        int ptr = 0; 
        for(int i=0; i<oneLine.length; i++){
            if(oneLine[i] >= 'a' && oneLine[i] <= 'z'){
                processed[ptr++] = oneLine[i]; //add to the processed string 
            }else{
                // not a char from a-z
                if(ptr > 0){
                    // remove it
                    processed[ptr] = ' ';
                    ptr--;
                }
                if(i == oneLine.length-1){
                    processed[ptr] = ' ';
                }

            }
        }
        String s = new String(processed);
        System.out.println(s.trim());
        }catch(Exception e){
            System.out.println("exceptions caught :/"); 
        }
    }
}
