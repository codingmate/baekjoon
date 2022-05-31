import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_string_b2_11720 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long result = 0;
        String line = br.readLine();
        String[] splitLine = line.split("");
        for ( String strNum : splitLine ){
            result += Integer.parseInt(strNum);
        }
        System.out.print(result);
    }
}
