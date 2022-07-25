import java.io.*;
import java.util.*;

public class Baekjoon_sort_s3_2108 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        double sumD = 0;
        int sumI = 0;
        
        Map<Integer, Integer> countMap = new HashMap<>();
        Set<Integer> numSet = new HashSet<>();
        for ( int row = 0; row < N; row++ ) {
            nums[row] = Integer.parseInt(br.readLine());
            sumD += nums[row];
            sumI += nums[row];
            numSet.add(nums[row]);
            if ( countMap.get(nums[row]) == null )
                countMap.put(nums[row], 1);
            else
                countMap.put( nums[row], countMap.get(nums[row]) + 1 );
        }
        
        Arrays.sort(nums);

        List<Integer> numList = new ArrayList<>();
        for ( int e : numSet )
            numList.add(e);
        List<Integer> countNumList = new ArrayList<>();
        for ( int e : numList )

        int r1 = sumI/N + ( (sumD/N - sumI/N) >= 0.5 ? 1
                                                     : 0 );
        int r2 = nums[N/2];
        int r4 = nums[N-1] - nums[0];
            
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r4);
    }

} // class
