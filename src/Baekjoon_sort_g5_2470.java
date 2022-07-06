import java.io.*;
import java.util.*;

public class Baekjoon_sort_g5_2470 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] numbers;
    static int N;

    public static void main (String[] args ) throws Exception {
        
        N = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        int[] values = new int[N];

        for ( int i = 0; i < N; i++ )
            values[i] = Integer.parseInt(numbers[i]);
        Arrays.sort(values);

        for ( int value : values )
            System.out.println(value);
        

        br.close();
    }
}