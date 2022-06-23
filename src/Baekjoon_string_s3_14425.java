import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.HashSet;

public class Baekjoon_string_s3_14425 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main ( String[] args ) throws Exception {
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        
        Set<String> S = new HashSet<>();
        for ( int i = 0; i < N; i++ ) {
            S.add(br.readLine());
        }

        int count = 0;
        for ( int i = 0; i < M; i++ ) {
            if ( S.contains(br.readLine()) )
                count++;
        }

        System.out.print( count );
     }
}