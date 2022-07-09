import java.io.*;
import java.util.*;

public class Baekjoon_sort_s5_11004 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        int[] numArr = new int[N];
        String[] strNumArr = br.readLine().split(" ");
        for ( int i = 0 ; i < N; i++ ) 
            numArr[i] = Integer.parseInt(strNumArr[i]);
        Arrays.sort(numArr);
        
        System.out.print(numArr[M-1]);

    }
}