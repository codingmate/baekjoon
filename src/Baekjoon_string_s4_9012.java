import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_string_s4_9012 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for ( int row = 0; row < T; row++ ){

            String[] splitLine = br.readLine().split("");
            int score = 0;
            for ( int i = 0; i < splitLine.length; i++ ){
                if (splitLine[i].equals("(")) {
                    score++;
                } else {
                    score--;
                }
                if(score < 0) {
                    result.append("NO\n");
                    break;
                }
            }
            if(score == 0) result.append("YES\n");
            else if (score > 0) result.append("NO\n");
        }
        System.out.print(result.toString());
    }

}
