import java.io.*;

public class Baekjoon_string_b5_10809 {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        StringBuilder result = new StringBuilder();
        for ( int alphabet = 'a'; alphabet <= 'z'; alphabet++ )
            result.append(line.indexOf(alphabet) + " ");
        
        result.deleteCharAt(result.length() - 1);

        System.out.print(result.toString());
    }
}
