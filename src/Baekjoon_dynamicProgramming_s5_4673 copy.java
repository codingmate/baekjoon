import java.io.BufferedReader;
import java.io.InputStreamReader;

class Baekjoon_dynamicProgramming_s1_1149 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int costR;
    static int costG;
    static int costB;
    static int countR = 0;
    static int countG = 0;
    static int countB = 0;
    static int result;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        String[] splitCostLine = br.readLine().split(" ");
        costR = Integer.parseInt(splitCostLine[0]);
        costG = Integer.parseInt(splitCostLine[1]);
        costB = Integer.parseInt(splitCostLine[2]);

        result = costR * countR + costG * countG + costB * countB;
        System.out.print(result);
    }
}
