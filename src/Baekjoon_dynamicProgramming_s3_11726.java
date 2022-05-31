import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_dynamicProgramming_s3_11726 {

    static int n;

    static long[] fn;
    public static void main ( String[] args ) throws Exception {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        fn = new long[n+1];
        
        
        fn[1] = 1;
        fn[2] = 2;

        for ( int i = 3; i < n+1; i++ ){
            fn[i] = (fn[i-1] + fn[i-2]) % 10007;
        }

        
        System.out.print( fn[n] );
    }

}