import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_string_s5_1427 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numStr = br.readLine();
        String[] splitStr = numStr.split("");
        for ( int i = 1; i < splitStr.length; i++ ) {
            int num = Integer.parseInt(splitStr[i]);
            int preNum = Integer.parseInt(splitStr[i-1]);
            if ( num < preNum ) {
                String temp = splitStr[i];
                splitStr[i-1]
            }
        }


        System.out.print(numStr);
    }
}
