import java.io.BufferedReader;
import java.io.InputStreamReader;
class Baekjoon_dynamicProgramming_s3_1463 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int minExectueCount = 0;
    static int[] counts;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        counts = new int[N+1];
        counts[0] = 0;
        counts[1] = 0;

        for ( int i = 2; i <= N; i++ ){
            counts[i] = counts[i-1] + 1;
            if ( i % 2 == 0 ) counts[i] = counts[i] < (counts[i/2] + 1)
                                               ? counts[i]
                                               : (counts[i/2] + 1);
            if ( i % 3 == 0 ) counts[i] = counts[i] < (counts[i/3] + 1)
                                               ? counts[i]
                                               : (counts[i/3] + 1);

            System.out.printf("counts[%d] : %d\n", i, counts[i]);
                                               
        }
        br.close();
        System.out.print(counts[N]);
    }

    
}
