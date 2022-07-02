import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
public class Baekjoon_string_s4_1764 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        
        Set<String> cantHearSet = new HashSet<>();
        Set<String> cantHearSeeSet = new TreeSet<>();
        /* 듣도 못한 사람들 */
        for ( int row = 0; row < N; row++ )
            cantHearSet.add(br.readLine());
            
        /* 듣도 보도 못한 사람들 */
        for ( int row = 0; row < M; row++ ){
            String key = br.readLine();
            if ( cantHearSet.contains(key) ) {                
                cantHearSeeSet.add(key);
            }
        }
        System.out.println(cantHearSeeSet.size());
        /* cantHearSeeList 문자열 오름차순 정렬 필요 */
        for ( String s : cantHearSeeSet ) {
            result.append( s + "\n" );
        }
        if ( result.length() > 1 )
            result.deleteCharAt(result.length()-1);
        System.out.print(result.toString());
    }
}
