import java.util.Scanner; 
import java.util.*; 

class QuickBrownFox{
 public static void main(String[] args){
    Scanner sc = new Scanner(System.in); 
    // get the numper of test cases 
    int no = sc.nextInt(); 
    sc.nextLine();
    // use the helper function below to determine if each test case is a pangram 
    String result = ""; 
    for(int i=0; i<no; i++){
        String sentence = sc.nextLine();
        String oneString = checkPang(sentence);
        result += oneString;
        result += System.lineSeparator();
    }
    System.out.print(result);
    sc.close();
 }  
 
 public static String checkPang(String s){
    int[] letters = new int[26]; // i.e. if letters[0] == 0 then we haven't encountered 'a'|'A'
    boolean notPangram = false; 
    // parse the string 
    s = s.toLowerCase().replaceAll("[^a-zA-Z]", "").replace(" ", ""); 
    for(int c=0; c<s.length(); c++){
        char currChar = s.charAt(c); 
        letters[currChar-'a']++; 
    }
    List<Character> missing = new ArrayList<>(); 
    // check if all letters have been visited 
    for(int l=0; l<26; l++){
        if(letters[l] == 0){
            notPangram = true; 
            char missingChar = (char)('a' + l);
            missing.add(missingChar);
        }
    }
    if(notPangram){
        return "missing " + missing.toString().replace("[","").replace(",","").replace("]","").replace(" ","");
    }else{
        return "pangram";
    }
 }
}
