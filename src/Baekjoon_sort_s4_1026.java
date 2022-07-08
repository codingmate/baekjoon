import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Baekjoon_sort_s4_1026 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {

        int N = Integer.parseInt(br.readLine());
        String[] strA = br.readLine().split(" ");
        String[] strB = br.readLine().split(" ");
        
        int[] A = new int[N];
        int[] B = new int[N];
        for ( int i = 0 ; i < N; i++ ) {
            A[i] = Integer.parseInt(strA[i]);
            B[i] = Integer.parseInt(strB[i]);
        }
        Arrays.sort(A);
        Arrays.sort(B);
        // for ( int a : A ) 
        //     System.out.print(a + " ");
        // System.out.println();
        // for ( int i = N-1; i > -1; i-- ) 
        //     System.out.print(B[i] + " ");

        
        int result = 0;

        for ( int i = 0; i < N; i++ ) {
            result += A[i] * B[N-1-i];
        }
        System.out.println(result);
        br.close();
    }
} // class
