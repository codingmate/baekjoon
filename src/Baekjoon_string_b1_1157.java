import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Baekjoon_string_b1_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().toUpperCase();
        // System.out.println((int)'a');
        // System.out.println((int)'z');
        // System.out.println((char)97);
        // System.out.println((char)122);

        Map<Character, Integer> countMap = new TreeMap<>();
        List<String> countList = new ArrayList<>();

        for ( char c = 'A'; c <= 'Z'; c++ )
            countMap.put(c, 0);

        for ( int i = 0; i < line.length(); i++ ) {
            char c = line.charAt(i);
            countMap.put(c, countMap.get(c)+1);
        }

        for ( Character c = 'A'; c <= 'Z'; c++ )
            countList.add(countMap.get(c) + c.toString() );
        Collections.sort(countList);

        if ( countList.get(countList.size()-1)
                      .substring(0,1)
                      .equals(countList.get(countList.size()-2)
                                       .substring(0,1)) ) {
            System.out.print("?");
        } else {
            System.out.print(countList.get(countList.size()-1).substring(1));
        }
        
        //System.out.println(countList);
    }
}
