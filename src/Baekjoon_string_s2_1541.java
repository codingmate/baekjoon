import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_string_s2_1541 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        
        int minSum = 0;
        int beginIndex = 0;
        int firstMinusIndex = -1;
        for ( int i = 1; i < line.length(); i++ ){
            if( line.charAt(i) == '+' || line.charAt(i) == '-' ){
                int num = Integer.parseInt(line.substring(beginIndex, i));
                beginIndex = i+1;
                if ( firstMinusIndex > -1 ){
                    minSum -= num;
                } else {
                    minSum += num;
                }
                if ( line.charAt(i) == '-' && firstMinusIndex == -1 ){
                    firstMinusIndex = i;
                }
            }
        }
        if ( firstMinusIndex == -1 ){
            minSum += Integer.parseInt(line.substring(beginIndex, line.length()));;
        } else {
            minSum -= Integer.parseInt(line.substring(beginIndex, line.length()));;
        }
        System.out.print(minSum);
        
    }

}
