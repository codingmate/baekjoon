import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;



public class Baekjoon_string_s5_1181 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Set<String> wordSet = new TreeSet<>();
    static String[][] wordSetArray;
    public static void main(String[] args) throws Exception {
        
        N = Integer.parseInt(br.readLine());
        for ( int i = 0; i < N; i++ ) {
            String word = br.readLine();
            if ( !wordSet.contains(word) ) {
                wordSet.add(word);
            }
        }
        Comparator<String> comparator = (String s1, String s2) -> {            
            if ( s1.length() > s2.length() ) {
                return 1;
            } else if ( s1.length() < s2.length() ) {
                return -1;
            } else {
                if ( s1.compareTo(s2) < 0 ) { 
                    return -1;
                } else if ( s1.compareTo(s2) > 0 ) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        ArrayList<String> wordASCList = new ArrayList<>(wordSet);
        //Collections.sort(wordASCList, comparator);
        Collections.sort(wordASCList, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                if ( s1.length() > s2.length() ) {
                    return 1;
                } else if ( s1.length() < s2.length() ) {
                    return -1;
                } else {
                    if ( s1.compareTo(s2) < 0 ) { 
                        return -1;
                    } else if ( s1.compareTo(s2) > 0 ) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        StringBuilder result = new StringBuilder();
        for ( String s : wordASCList ) {
            result.append(s + "\n");
        }
        if ( result.length() > 0 ) {
            result.deleteCharAt(result.length()-1);
        }
        System.out.print(result.toString());
        br.close();
    }

}
