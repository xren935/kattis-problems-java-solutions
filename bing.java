// import java.io.*;
// import java.util.*; 

// public class bing {

//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         PrintWriter bw = new PrintWriter(new OutputStreamWriter(System.out));
//         int n = Integer.parseInt(br.readLine());
//         String sent;
//         String[] words = new String[n];
//         int cnt = 1; 
//         words[0] = br.readLine(); 
//         bw.println(0);
//         do{
//             words[cnt]=br.readLine();
//             int repeat = getSame(words,words[cnt],cnt);
//             bw.println(repeat);
//             cnt++;
//         }while(cnt < n);
//         bw.close();
//     }

//     public static int getSame(String[] words ,String str, int counter){
//         int cnt = 0 ;
//         for(int i = 0 ; i <counter ; i++){
//             if(words[i].charAt(0)==str.charAt(0) && str.length()<=words[i].length()){
//                 boolean isContain = true;
//                 for(int j = 1 ; j<str.length()  ; j++){
//                     if(str.charAt(j)!=words[i].charAt(j)){
//                         isContain = false;
//                         break;
//                     }
//                 }
//                 if(isContain)
//                     cnt++;
//             }
                    
//         }
//         return cnt;
//     }
// }

import java.util.*;
import java.io.*;

public class bing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter (new OutputStreamWriter(System.out)));
        int num = Integer.parseInt(br.readLine());
        String [] words = new String[num];
        int count = 1;
        words[0]=br.readLine();
        pw.println(0);
        do{
            words[count]=br.readLine();
            int repeat = getSame(words,words[count],count);
            pw.println(repeat);
            count = count+1;
        }while(count<num);
        pw.close();
    }
    
    public static int getSame(String[] words ,String str, int counter){
        int cnt = 0 ;
        for(int i = 0 ; i <counter ; i++){
            if(words[i].charAt(0)==str.charAt(0) && str.length()<=words[i].length()){
                boolean isContain = true;
                for(int j = 1 ; j<str.length()  ; j++){
                    if(str.charAt(j)!=words[i].charAt(j)){
                        isContain = false;
                        break;
                    }
                }
                if(isContain){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}