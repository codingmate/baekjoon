import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_string_b2_1152 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int result = line.trim().split(" ").length;
        if( line.trim().equals("") ) result = 0;
        System.out.print(result);
    }
}
