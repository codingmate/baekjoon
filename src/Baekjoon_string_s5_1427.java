import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.List;
import java.util.ArrayList;
public class Baekjoon_string_s5_1427 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numList = new ArrayList<>();
        
        for ( String e : br.readLine().split("") )
            numList.add(Integer.parseInt(e));
        /* Selection Sort DESC */
        for ( int i = 0; i < numList.size(); i++ ) {
            for ( int j = i + 1; j < numList.size(); j++ )
                if ( numList.get(i) < numList.get(j) ) {
                    int temp = numList.get(i);
                    numList.set(i, numList.get(j));
                    numList.set(j, temp);
                }
        }    
        StringBuilder result = new StringBuilder();
        for ( int num : numList ) {
            result.append(num);
        }

        System.out.print(result.toString());
    }
}
