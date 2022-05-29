import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_backtracking_1003 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] fibonaccis = new long[41];
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException{
        
        fibonaccis[0] = 0;
        fibonaccis[1] = 1;
        int top = 1;
        int row = Integer.parseInt(br.readLine());
        for ( int i = 0; i < row; i++ ){
            int n = Integer.parseInt(br.readLine());
            if ( n == 0 ){
                result.append("1 0\n");
                continue;
            } else if ( n == 1 ) {
                result.append("0 1\n");
                continue;
            }
            for ( int j = top + 1; j < n+1; j++ ){
                fibonaccis[j] = setFibonacci(j);
            }
            if ( n > top ) top = n;
            result.append(fibonaccis[n-1] + " " + fibonaccis[n] + "\n");
        }
        result.deleteCharAt(result.length()-1);
        System.out.print(result);
    }

    public static long setFibonacci(int num){
        return fibonaccis[num-1] + fibonaccis[num-2];
    }
    
}