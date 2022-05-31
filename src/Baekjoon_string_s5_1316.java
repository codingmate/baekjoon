import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Baekjoon_string_s5_1316 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for ( int i = 0; i < N; i++ ){
            String str = br.readLine();
            if ( isGroupStr ( str ) ){
                result++;
            }
        }
        System.out.print(result);
    }

    public static boolean isGroupStr( String str ) {
        List<Character> distinctCharList = new ArrayList<>();
        for ( int i = 0; i < str.length(); i++ ){
            Character C = str.charAt(i);
            if ( distinctCharList.indexOf(C) == -1 ) {
                distinctCharList.add(C);
            }
        }

        for ( int i = 0; i < distinctCharList.size(); i++ ){
            Character C = distinctCharList.get(i);
            String doubleC = C.toString() + C.toString();
            while( str.indexOf(doubleC) > -1 ){
                str = str.replace(doubleC, "");
            }
        }

        for ( int i = 0; i < distinctCharList.size(); i++ ){
            char C = distinctCharList.get(i);
            if ( str.indexOf(C) != str.lastIndexOf(C) ){
                return false;
            }
        }
        
        return true;
    }
}
