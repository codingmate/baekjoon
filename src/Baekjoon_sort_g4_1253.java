import java.io.*;
import java.util.*;

public class Baekjoon_sort_g4_1253 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main( String[] args ) throws IOException{
        
        int N = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        List<Long> numList = new ArrayList<>();
        for ( String num : nums ) {
            numList.add(Long.parseLong(num));
        }

        Collections.sort(numList);
        
        int count = 0;
        for ( int i = 0; i < N; i++ ) {
            long I = numList.get(i);
            for ( int j = 0; j < N; j++ ) {
                if ( i == j ) continue;
                

                long J = numList.get(j);
                if ( I < J )
                    continue;
                for ( int k = j + 1; k < N; k++ ) {
                    long K = numList.get(k);
                    if ( i == k ) continue;
                    if ( I == J && K == 0 ) continue;

                    if ( I == J + K ) {
                        count++;
                        break;
                    }
                }
            }
            
        } // for : i
        
        System.out.print(count);
        
    }
}
