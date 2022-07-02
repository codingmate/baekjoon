import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Baekjoon_string_b2_10988 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main ( String [] args ) throws Exception {

        String word = br.readLine();
        boolean result = true;
        for (int i = 0; i < word.length()/2; i++ ) {
            if ( word.charAt(i) != word.charAt(word.length()-1 - i) ) {
                result = false;
                break;
            }
        }

        System.out.print(result ? 1 : 0);
    }
    
}
