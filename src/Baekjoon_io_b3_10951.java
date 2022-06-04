import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_io_b3_10951 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringBuilder result = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.equals(""))
                break;
            String[] AB = br.readLine().split(" ");
            int A = Integer.parseInt(AB[0]);
            int B = Integer.parseInt(AB[1]);
            int sum = A + B;
            result.append(sum + "\n");
        }
        if (result.length() > 1)
            result.deleteCharAt(result.length() - 1);
        System.out.print(result);
    }
}