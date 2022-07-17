import java.io.*;
import java.util.StringTokenizer;
public class Baekjoon_string_b2_1212 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        String[] octals = line.split("");

        StringBuilder result = new StringBuilder();

        for ( String octal : octals ) {
            int o = Integer.parseInt(octal);
            String toBynary = new String();
            if ( o >= 2 * 2 ) {
                o -= 4;
                toBynary = "1";
            }
            else toBynary = "0";

            if ( o >= 2 ) {
                o -= 2;
                toBynary += "1";
            }
            else toBynary += "0";

            if ( o >= 1 ) {
                toBynary += "1";
            }
            else toBynary +="0";
            result.append(toBynary);
            //System.out.printf("octal : %s, toBynary : %s\n", octal, toBynary);
        }

        while ( result.indexOf("0") == 0 ) {
            result.deleteCharAt(0);
        }

        System.out.print(result.toString());

        
    }
    
}
