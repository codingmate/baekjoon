import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class Baekjoon_string_s4_1764 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        Set<String> cantHearSet = new HashSet<>();
        for ( int row = 0; row < N; row++ )
            cantHearSet.add(br.readLine());
        for ( int row = 0; row < M; row++ ){
            String key = br.readLine();
            if ( cantHearSet.contains(key) )
                result.append( key + "\n" );
        }
        if ( result.length() > 1 )
            result.deleteCharAt(result.length() - 1);
        System.out.print(result.toString());
    }
}
