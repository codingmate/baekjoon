import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_string_s5_5635 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String minAgeName = new String();
        String maxAgeName = new String();

        int maxBirth = 99999999;
        int minBirth = 00000000;
        for ( int row = 0; row < n; row++ ){
            String line = br.readLine();
            String[] splitLine = line.split(" ");
            String name = splitLine[0];
            String Y = splitLine[3];
            String M = splitLine[2];
            String D = splitLine[1];

            M = Integer.parseInt(M) < 10 ? "0".concat(M) : M;
            D = Integer.parseInt(D) < 10 ? "0".concat(D) : D;

            int YMD = Integer.parseInt(Y + M + D);
            if ( YMD > minBirth ) {
                minBirth = YMD;
                minAgeName = name;
            }
            if ( YMD < maxBirth ) {
                maxBirth = YMD;
                maxAgeName = name;
            }
        }
        
        System.out.println(minAgeName);
        System.out.print(maxAgeName);
    }
}
