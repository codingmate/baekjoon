import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_string_b1_1357 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] XY = br.readLine().split(" ");
        

        int revX = rev(XY[0]);
        int revY = rev(XY[1]);

        int sumRev = revX + revY;
        System.out.print(rev ( Integer.toString(sumRev) ) );
        
        br.close();
        
        
    }

    public static int rev(String num) {
        String[] splitNum = num.split("");
        StringBuilder rev = new StringBuilder();
        for (int i = splitNum.length - 1; i > -1; i-- ){
            rev.append(splitNum[i]);
        }
        
        return Integer.parseInt(rev.toString());
    }
}
