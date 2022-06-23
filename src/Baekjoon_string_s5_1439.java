import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_string_s5_1439 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main ( String[] args ) throws Exception {
        String line = br.readLine();
        while( line.indexOf("11") > -1 ) {
            line = line.replace("11", "1");
        }
        while( line.indexOf("00") > -1 ) {
            line = line.replace("00", "0");
        }
        
        int count0 = 0;
        int count1 = 0;
        for ( int i = 0; i < line.length(); i++ ) {
            switch ( line.charAt(i) ) {
                case '0':
                    count0++;
                    break;
                case '1':
                    count1++;
                    break;
            }
        }
        

        System.out.print(count0 > count1 ? count1 : count0);
     }
}