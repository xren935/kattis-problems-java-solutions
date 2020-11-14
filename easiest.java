import java.util.*;
public class easiest {	
	private static int sumDigi(int num) {
		int sum =0;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		while(n != 0) {
            // given 1≤𝑁≤100000
            // brutal force...
			for(int p=11; p<1000000000; p++) {
				if(sumDigi(p*n) == sumDigi(n)) {
					System.out.println(p);
					break;
				}
			}
			n = sc.nextInt();
		}
	}
}