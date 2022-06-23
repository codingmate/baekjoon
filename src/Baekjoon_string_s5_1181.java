import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
public class Baekjoon_string_s5_1181 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static List<String> wordList = new ArrayList<>();
    static Set<String> wordSet = new HashSet<>();
    static String[][] wordSetArray;
    public static void main(String[] args) throws Exception {
        
        N = Integer.parseInt(br.readLine());
        
        for ( int i = 0; i < N; i++ ) {
            String word = br.readLine();
            if ( !wordSet.contains(word) ) {
                wordSet.add(word);
                wordList.add(word);
            }
        }
        
        System.out.println(wordList);
        
                
        
        br.close();
    }

}
