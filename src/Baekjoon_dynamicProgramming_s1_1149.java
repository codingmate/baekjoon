import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Baekjoon_dynamicProgramming_s1_1149 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int costMinLastR;
    static int costMinLastG;
    static int costMinLastB;
    static int result = Integer.MAX_VALUE;


    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        for (int row = 0; row < N; row++) {
            String[] rgbLine = br.readLine().split(" ");
            int r = Integer.parseInt(rgbLine[0]);
            int g = Integer.parseInt(rgbLine[1]);
            int b = Integer.parseInt(rgbLine[2]);
            if ( row == 0 ){
                costMinLastR = r;
                costMinLastG = g;
                costMinLastB = b;
            } else {
                r += (costMinLastG <= costMinLastB ? costMinLastG : costMinLastB);
                g += (costMinLastB <= costMinLastR ? costMinLastB : costMinLastR);
                b += (costMinLastR <= costMinLastG ? costMinLastR : costMinLastG);
                costMinLastR = r;
                costMinLastG = g;
                costMinLastB = b;
            }
        }
        result = costMinLastR <= costMinLastG && costMinLastR <= costMinLastB ? costMinLastR
               : costMinLastG <= costMinLastR && costMinLastG <= costMinLastB ? costMinLastG
               : costMinLastB;

        System.out.print(result);
    }


}
