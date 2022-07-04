import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_sort_s5_2751 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];
        for ( int i = 0; i < N; i++ )
            numArr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(numArr);

        for ( int i = 0; i < N; i++ ) 
            System.out.println(numArr[i]);
        
        br.close();
    } // main
}
