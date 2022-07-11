import java.io.*;
import java.util.Arrays;
public class Baekjoon_sort_b1_10989 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main( String[] args ) throws Exception{
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0 ; i < N; i++ )
            nums[i] = Integer.parseInt(br.readLine());
        Arrays.sort(nums);

        StringBuilder result = new StringBuilder();
        for ( int num : nums ) 
            result.append( num + "\n" );
            
        if ( result.length() > 0 )
            result.deleteCharAt( result.length() - 1 );

        System.out.print(result.toString());
        br.close();
    }
    
}
