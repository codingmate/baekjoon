import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon_string_g4_5052 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        for ( int r = 0; r < t; r++ ){
            List<String> strList = new ArrayList<>();
            for ( int e = 0; e < n; e++ ){
                strList.add(br.readLine());
            }
        }
    }
}
