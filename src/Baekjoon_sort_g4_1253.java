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

        int count = 0;
        for ( int i = 0; i < N; i++ ) {
            long numI = numList.get(i);

            for ( int j = 0; j < N; j++ ) {

                boolean isCounted = false;
                long numJ = numList.get(j);
                for ( int k = 0; k < N; k++ ) {
                    if ( i != j && i != k && j != k ) {
                        long numK = numList.get(k);
                        if ( numI == (numJ + numK) ) {
                            count++;
                            isCounted = true;
                        }
                    }
                }
                if ( isCounted ) {
                    break;
                }
            } // for : j
        } // for : i
        
        System.out.print(count);
        
    }
}
