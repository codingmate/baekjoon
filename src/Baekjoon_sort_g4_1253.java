import java.io.*;
import java.util.*;

public class Baekjoon_sort_g4_1253 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        int[] nums = new int[N];
        for ( int i = 0; i < N; i++ )
            nums[i] = Integer.parseInt(numbers[i]);
        
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
                for ( String IcJ : sumMap.get(Integer.parseInt(num)) ) {
                    String[] IJ = IcJ.split(",");
                    if ( !IJ[0].equals(num) && !IJ[1].equals(num) ) {
                        count++;
                        break;
                    }
                }
        }
        System.out.print(count);
        
        //System.out.println(sumMap);
    }
}
