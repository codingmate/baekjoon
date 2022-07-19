import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_sort_p5_1517 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] nums;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        String[] numbers = br.readLine().split(" ");
        
        for ( int i = 0; i < N; i++ )
            nums[i] = Integer.parseInt(numbers[i]);
        
        int count = 0;
        boolean isSorted = false;
        while ( !isSorted ) {
            isSorted = true;
            for ( int i = 0; i < N - 1; i++ ) {
                if ( nums[i] > nums[i + 1] ) {
                    isSorted = false;
                    swap(i, i+1);
                    count++;
                } 
            } // for
        } // while
        System.out.print(count);
        
    }
    public static void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
} // class
