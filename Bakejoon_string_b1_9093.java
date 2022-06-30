import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class Bakejoon_string_b1_9093 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws Exception {
       
        T = Integer.parseInt(br.readLine());
        
        for ( int i = 0; i < T; i++ ) {
            String[] splitLine = br.readLine().split(" ");
            for ( int j = 0; j < splitLine.length; j++ ) {
                for ( int k = splitLine[j].length()-1; k > -1; k-- ) {
                    result.append(splitLine[j].charAt(k));
                }
                result.append(" ");
            }
            result.append("\n");
        }
        System.out.print(result.toString());

    }

    
} // class
