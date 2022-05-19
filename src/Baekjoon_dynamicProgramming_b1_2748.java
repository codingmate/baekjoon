import java.io.BufferedReader;
import java.io.InputStreamReader;
class Baekjoon_dynamicProgramming_b1_2748 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long n;
    static long[] p;
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println(0);
        } else if ( n < 2 ){
            System.out.print(1);
        } else {
            p = new long[(int)(n+1)];
            p[1] = 1;
            p[2] = 1;
            for ( int i = 3; i <= n; i++ ){
                p[i] = p[i-1] + p[i-2];
            }
            System.out.println(p[(int)n]);
        }
    }
}
