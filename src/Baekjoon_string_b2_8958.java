import java.io.*;

public class Baekjoon_string_b2_8958 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < N; row++) {
            String line = br.readLine();
            int start = -1;
            int end = -1;
            int lineScore = 0;
            //System.out.println();
            for (int col = 0; col < line.length(); col++) {
                end++;
                char c = line.charAt(col);
                switch (c) {
                    case 'O':
                        break;
                    case 'X':
                        if ( col > 0 && line.charAt(col-1) == 'O' ) {
                            int diff = end - start;
                            int score = 0;
                            for (int i = 1; i < diff; i++)
                                score += i;
                            lineScore += score;
                            start = end;
                            //System.out.print(score + " ");
                        } else if ( col > 0 && line.charAt(col-1) == 'X' ) {
                            start++;
                        }
                        break;
                    default:
                        break;
                } // switch

            }
            
            if (start != end) {
                    int diff = end - start;
                    int score = 0;
                    for (int i = 1; i <= diff; i++)
                        score += i;
                    lineScore += score;
                //System.out.print("!" + score + " ");
                }
            //System.out.printf("lineScore : %d\n", lineScore);
            result.append(lineScore + "\n");
        }
        if ( result.length() > 0 )
            result.deleteCharAt(result.length()-1);
        System.out.print(result.toString());

    } // main

} // class
