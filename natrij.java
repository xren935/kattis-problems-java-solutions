import java.util.*;
public class natrij {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] currTime = (sc.nextLine()).split(":");
        String[] bombTime = (sc.nextLine()).split(":");
        sc.close();
        if(Integer.valueOf(bombTime[0])<=Integer.valueOf(currTime[0])){
            // should be in the future
            bombTime[0] = Integer.valueOf(bombTime[0])+24+"";
        }   
        // return the time diff. in sec.
        int difTime = Integer.valueOf(bombTime[0])*3600 + Integer.valueOf(bombTime[1]) * 60 + Integer.valueOf(bombTime[2]);
        difTime -= (Integer.valueOf(currTime[0])*3600 + Integer.valueOf(currTime[1]) * 60 + Integer.valueOf(currTime[2]));
        // formatting
        String h = "" + difTime/3600 + ":";
        String m = "" + (difTime%3600)/60 + ":";
        String s = "" + (difTime%3600)%60;

        if((difTime/3600)<10){
            h = "0" + h;
        }
        if(((difTime%3600)/60)<10){
            m = "0" + m;
        }
        if(((difTime%3600)%60)<10){
            s = "0" + s;
        }
        System.out.println(h + m + s);
    }
}