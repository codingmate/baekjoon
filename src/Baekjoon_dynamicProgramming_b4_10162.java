import java.io.BufferedReader;
import java.io.InputStreamReader;

class Baekjoon_dynamicProgramming_b4_10162 {

    static int time;
    static String result;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        time = Integer.parseInt(br.readLine().split(" ")[0]);

        if (time % 10 == 0) {
            int countA = time / 300;
            int countB = time % 300 / 60;
            int countC = time % 300 % 60 / 10;
            result = countA + " " + countB + " " + countC;
        } else {
            result = "-1";
        }

        System.out.print(result);
    }
}
