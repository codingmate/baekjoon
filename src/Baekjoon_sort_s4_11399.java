import java.io.*;
import java.util.*;

public class Baekjoon_sort_s4_11399 {
    
    static int N;
    static int[] times;
    public static void main ( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        times = new int[N];
        String[] numbers = br.readLine().split(" ");
        for ( int i = 0 ; i < N; i++ ) {
            times[i] = Integer.parseInt(numbers[i]);
        }
        Arrays.sort(times);

        int result = 0;
        for ( int i = 0; i < times.length; i++ ) {
            result += (N - i) * times[i];
        }
        System.out.print(result);
    }
}
