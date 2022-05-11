import java.io.BufferedReader;
import java.io.InputStreamReader;

class Baekjoon_dynamicProgramming_b2_2864 {

    static String A;
    static String B;
    static int maxSum;
    static int minSum;
    static String result;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String[] splitLine = br.readLine().split(" ");
        A = splitLine[0];
        B = splitLine[1];

        StringBuilder maxA = new StringBuilder();
        StringBuilder minA = new StringBuilder();
        StringBuilder maxB = new StringBuilder();
        StringBuilder minB = new StringBuilder();
        for (String a : A.split("")) {
            maxA.append(a.equals("5") || a.equals("6") ? "6" : a);
            minA.append(a.equals("5") || a.equals("6") ? "5" : a);
        }
        for (String b : B.split("")) {
            maxB.append(b.equals("5") || b.equals("6") ? "6" : b);
            minB.append(b.equals("5") || b.equals("6") ? "5" : b);
        }
        maxSum = Integer.parseInt(maxA.toString()) + Integer.parseInt(maxB.toString());
        minSum = Integer.parseInt(minA.toString()) + Integer.parseInt(minB.toString());

        result = minSum + " " + maxSum;
        System.out.print(result);
    }
}
