import java.io.*;
import java.util.*;

public class Baekjoon_sort_g4_1253 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        StringTokenizer numberStk = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[N];
        
  
        Map<Integer, Integer> numCountMap = new HashMap<>();
        int count0 = 0;
        for ( int i = 0; numberStk.hasMoreTokens(); i++ ) {
            
            int num = Integer.parseInt(numberStk.nextToken());
            nums[i] = num;
            if ( numCountMap.get(num) == null )
                numCountMap.put(num, 0);
            numCountMap.put(num, numCountMap.get(num) + 1);
            
            if ( num == 0 )
                count0++;
        }
            
        Arrays.sort(nums);
        
        Set<Integer> sumSet = new HashSet<>();
        for ( int i = 0; i < N; i++ ) {
            int I = nums[i];
            if ( I == 0 ) continue;
            for ( int j = i + 1; j < N; j++ ) {
                int J = nums[j];
                if ( J == 0 ) continue;
                int sum = I + J;
                sumSet.add(sum);
            }
        }             

        int count = 0;
        if ( count0 == 0 || count0 > 2 )
            for ( int i = 0; i < N; i++ ) {
                int num = nums[i];
                if ( num == 0 ) continue;
                if ( sumSet.contains(num) )
                count++;
            }
        else if ( count0 == 1 || count0 == 2 ) {
            for ( int i = 0; i < N; i++ ) {
                int num = nums[i];
                if ( sumSet.contains(num)
                  || (num != 0 && numCountMap.get(num) > 1)
                   )
                count++;
            }
        }
        if ( count0 > 2 ) {
            count += count0;
        }
        
        System.out.print(count);
        
        //System.out.println(sumMap);
    }
}
