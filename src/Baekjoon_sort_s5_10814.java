import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Baekjoon_sort_s5_10814 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> humanInfoList = new ArrayList<>();
        for ( int i = 0; i < N; i++ )
            humanInfoList.add(br.readLine());
        
        Collections.sort(humanInfoList, (String h1, String h2) -> {
            int h1_age = Integer.parseInt(h1.split(" ")[0]);
            int h2_age = Integer.parseInt(h2.split(" ")[0]);

            if ( h1_age > h2_age ) return 1;
            else if ( h1_age == h2_age ) return 0;
            else return -1;
        });
        StringBuilder result = new StringBuilder();
        for ( int i = 0; i < N; i++ )
            result.append(humanInfoList.get(i) + "\n");
        if ( result.length() > 0 ) {
            result.deleteCharAt(result.length() - 1);
        }    
        System.out.print(result.toString());
        br.close();
    } // main

}
