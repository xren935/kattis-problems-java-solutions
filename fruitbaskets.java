// https://open.kattis.com/problems/fruitbaskets
// Given n number of inputs 
// outputs the sum of all diff. combinations of the inputs that are > 200
// each number can be used at most once  
// i.e. input: 50 60 70 120 
// (60+70+120), (50+70+120), (50+60+120), (50+60+70+120) => output: 1020
// range from 1 to n number of items 

import java.util.*; 
import java.lang.*;

class fruitbaskets{
    int[] slots = new int[42];
    static int sum = 0; 
    int  n;

public static void zuhe(int a[], int n, int m, int flag)
{   //p[x]=y 取到的第x个元素，是a中的第y个元素
    int index, i;
    int[] p = new int[m]; 
    index = 0;
    p[index] = 0; //取第一个元素
    while (true)
    {
        if (p[index] >= n)
        {   //取到底了，回退
            if (index == 0)
            {   //各种情况取完了，不能再回退了
                break;
            }
            index--;//回退到前一个
            p[index]++;//替换元素
        }
        else if (index == m - 1)
        {   //取够了，输出
            int res = 0;
            for (i = 0; i < m; i++)
            {
                res += a[p[i]];
            }
            if (flag == 1)
            {
                if (res >= 200)
                {
                    sum += res;

                }
            } else {
                if (res < 200)
                {
                    sum -= res;
                }
            }

            p[index]++; //替换元素
        }
        else
        {   //多取一个元素
            index++;
            p[index] = p[index - 1] + 1;
        }

    }
}
public static void main(String[] args)
{
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); 
    int[] con = new int[n];
    int tempsum = 0;
    for (int i = 0; i < n; i++){
        int currWeight = sc.nextInt(); 
        con[i] = currWeight;
        tempsum += currWeight;
    }
    if (tempsum < 200)
    {
        System.out.println("0");

    } else if (tempsum == 200)
    {
        System.out.println("200");

    }
    if (n < 4)
    {
        for (int i = 1; i <= n; i++)
        {
            zuhe(con, n, i, 1);
        }
    } else {
        sum += tempsum * Math.pow(2,n - 1);
        for (int i = 1; i <= 3; i++)
        {
            zuhe(con, n, i, 0);
        }
    }
    System.out.println(sum);

}
} 