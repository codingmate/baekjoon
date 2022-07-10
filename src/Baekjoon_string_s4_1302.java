import java.io.*;
import java.util.*;

public class Baekjoon_string_s4_1302 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<String, Integer> wordCountMap = new HashMap<>();
    public static void main( String args[] ) throws Exception {
    
        int N = Integer.parseInt(br.readLine());
        
        int maxCount = 0;
        String maxWord = "";
        for ( int i = 0; i < N; i++ ) {
            String word = br.readLine();
            Integer wordCount = wordCountMap.get(word);
            if ( wordCount == null ) {
                wordCount = 1;
                wordCountMap.put(word, wordCount);
            } else {
                wordCountMap.put(word, ++wordCount);
            }
            if ( ( wordCount > maxCount )
              || ( wordCount == maxCount && word.compareTo(maxWord) < 0 )
               ) {
                maxCount = wordCount;
                maxWord = word;
            }
        }
        System.out.print(maxWord);
        br.close();
    }
}

