import java.io.*;
import java.util.*;

public class Baekjoon_sort_g4_1253 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main( String[] args ) throws IOException{
        
        int N = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        List<Long> numList = new ArrayList<>();
        Set<Long> sumSet = new HashSet<>();
        for ( String num : nums ) {
            numList.add(Long.parseLong(num));
        }

        for ( int i = 0; i < numList.size(); i++ ) {
            Long numI = numList.get(i);
            for ( int j = i + 1; j < numList.size(); j++ ) {
                if ( !sumSet.contains(numI + numList.get(j)) )
                    sumSet.add(numI + numList.get(j));
            }
        }

        int count = 0;
        for ( long num : numList )
            if ( sumSet.contains(num) )
                count++;
        System.out.print(count);
        
    }
}
