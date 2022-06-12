import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Baekjoon_io_b2_2675 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for ( int row = 0; row < T; row++ ) {
            
            String[] splitLine = br.readLine().split(" ");
            int repeatCount = Integer.parseInt(splitLine[0]);
            String word = splitLine[1];
            for ( String s : word.split("") ) {
                for ( int i = 0; i < repeatCount; i++ ){
                    result.append(s);
                }
            }
            result.append("\n");
        }
        result.deleteCharAt(result.length()-1);
        System.out.print(result);
    }
}