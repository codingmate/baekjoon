import java.io.BufferedReader;
import java.io.InputStreamReader;

class Baekjoon_dynamicProgramming_b2_5585 {

    static int price;
    static int result;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        price = Integer.parseInt(br.readLine().split(" ")[0]);

        int change = 1000 - price;
        int count500 = change / 500;
        int count100 = change % 500 / 100;
        int count50 = change % 500 % 100 / 50;
        int count10 = change % 500 % 100 % 50 / 10;
        int count5 = change % 500 % 100 % 50 % 10 / 5;
        int count1 = change % 500 % 100 % 50 % 10 % 5 / 1;

        result = count500 + count100 + count50 + count10 + count5 + count1;
        System.out.print(result);
    }
}
