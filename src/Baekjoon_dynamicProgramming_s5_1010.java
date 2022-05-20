import java.io.BufferedReader;
import java.io.InputStreamReader;
class Baekjoon_dynamicProgramming_s5_1010 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    
    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());    
        StringBuilder result = new StringBuilder();
        for ( int i = 0; i < T; i++ ){
            String[] rowNM = br.readLine().split(" ");
            int N = Integer.parseInt(rowNM[0]);
            int M = Integer.parseInt(rowNM[1]);
            int n, r;
            if(N >= M){
                n = N;
                r = M;
            } else {
                n = M;
                r = N;
            }
            result.append(combination(n, r) + "\n");
        }
        System.out.print(result.toString());
    }

    public static long factorial( int number ){
        long result = 1;
        for ( int i = 2; i <= number; i++ )
            result *= number;
        return result;
    }
    
    public static long combination ( int n, int r ){   
        long result = 1;
        for ( int i = n; i > r ; i-- ){
            result *= i;
        }
        result /= factorial(r);
        return factorial(n) / (factorial(n-r) * factorial(r));
    }
    
}
