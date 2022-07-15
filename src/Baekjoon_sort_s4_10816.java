import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_sort_s4_10816 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        String line1 = br.readLine();
        Map<String, Integer> numCountMap = new HashMap<>();
        for ( String num : line1.split(" ") )
            if ( numCountMap.get(num) == null )
                numCountMap.put(num, 1);
            else
                numCountMap.put(num, numCountMap.get(num) + 1);
        M = Integer.parseInt(br.readLine());
        String line2 = br.readLine();
        StringBuilder result = new StringBuilder();
        for ( String num : line2.split(" ") ) 
            result.append((numCountMap.get(num) == null ? 0 
                                                       : numCountMap.get(num)) + " ");
        System.out.print(result.toString());

        br.close();
    }

   
    
    
    
} // class
