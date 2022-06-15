import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.List;
import java.util.ArrayList;

public class Baekjoon_backtracking_s2_1182 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> stack = new ArrayList<>();
    static List<Integer> numList = new ArrayList<>();
    static int N;
    static int S;
    static int count = 0;
    public static void main ( String[] args ) throws Exception {

        String[] splitLine = br.readLine().split(" ");
        N = Integer.parseInt(splitLine[0]);
        S = Integer.parseInt(splitLine[1]);
        
        for ( String number : br.readLine().split(" ") )
            numList.add(Integer.parseInt(number));
        
        for ( int fromIdx = 0; fromIdx < N; fromIdx++ ){
            dfs(fromIdx);
        }
        
        System.out.print(count);
    }

    public static void dfs ( int fromIdx ) {
        stack.add(fromIdx);
        
        for ( int toIdx = 0; toIdx < N; toIdx++ ) {
            if ( stack.size() < N
              && stack.indexOf(toIdx) == -1
              && fromIdx < toIdx
               ) {
                dfs(toIdx);
            }
        }
        
        int sum = 0;
        if ( stack.size() > 0 ) {
            for ( int i = 0; i < stack.size(); i++ ) {
                sum += numList.get(stack.get(i));
            }
            if ( sum == S )
                count++;
        }
            
        
        stack.remove(stack.size()-1);
    }
}