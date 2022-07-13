import java.io.*;
import java.util.*;

public class Baekjoon_sort_g4_1253 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        StringTokenizer numberStk = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[N];
        
        for ( int i = 0; numberStk.hasMoreTokens(); i++ )
            nums[i] = Integer.parseInt(numberStk.nextToken());
        
        
        Map<Integer, List<String>> sumMap = new HashMap<Integer, List<String>>();
        for ( int i = 0; i < N; i++ ) {
            int I = nums[i];
            for ( int j = i + 1; j < N; j++ ) {
                int J = nums[j];
                int sum = I + J;
                String IJ = I + "," + J;
                if ( sumMap.get(sum) == null )
                    sumMap.put(sum, new ArrayList<String>());
                sumMap.get(sum).add(IJ);
            }
        }
        int count = 0;
        for ( int i = 0 ; i < N ; i++ ) {
            String num = Integer.toString(nums[i]);
            if ( sumMap.get(nums[i]) != null )
                for ( String IJ : sumMap.get(Integer.parseInt(num)) ) {
                    StringTokenizer stk = new StringTokenizer(IJ, ",");
                    if ( !stk.nextToken().equals(num) && !stk.nextToken().equals(num) ) {
                        count++;
                        break;
                    }
                }
        }
        System.out.print(count);
        
        //System.out.println(sumMap);
    }
}
