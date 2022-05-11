import java.io.BufferedReader;
import java.io.InputStreamReader;
class Main {
    
    static int N;
    static int result;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine().split(" ")[0]);
        int count5 = 0;
        int count3 = 0;

        for ( int i = 0; i <= N / 5; i++) {
            int tmp = N - 5 * i;
            if ( tmp % 3 == 0 ){
                count5 = i;
                count3 = tmp / 3;
            }
        }
        result = count5 == 0 && count3 == 0 ? -1 : count5 + count3;
        System.out.print(result);
    }
}
