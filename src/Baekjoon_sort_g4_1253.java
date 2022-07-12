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
        for ( int i = 0; i < numList.size(); i++ ) {
            Long numI = numList.get(i);
            boolean isCounted = false;
            for ( int j = 0; j < numList.size(); j++) {
                if ( i == j )
                    continue;
                else {
                    Long numJ = numList.get(j);
                    for ( int k = j + 1; k < numList.size(); k++ ) {
                        if ( i != k && (numI == numJ + numList.get(k)) ) {
                            count++;
                            //System.out.printf("numI : %d, numJ : %d, num : %d \n", numI, numJ, numList.get(k));
                            isCounted = true;
                            break;
                        }
                    } //for : k
                } // else
                if ( isCounted )
                    break;
            } // for : j
        } // for : i
        
        System.out.print(count);
        
    }
}
