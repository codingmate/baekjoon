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
        long F = 1;
        for ( int i = 2; i <= number; i++ ){
            F *= i;
        }

        return F;
    }
    
    public static long combination ( int n, int r ){   
        long C = 1;
        
        int maxR = (n-r) > r ? (n-r) : r;
        int minR = (n-r) < r ? (n-r) : r;
        for ( int i = n; i > maxR ; i-- ){
            C *= i;
        }

        C /= factorial(minR);
        return C;
    }
    
}
