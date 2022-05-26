import java.io.BufferedReader;
import java.io.InputStreamReader;
class Baekjoon_dynamicProgramming_s5_14916 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int minCoinCount = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        
        n = Integer.parseInt(br.readLine());
        int coin5Count = 0;
        int coin2Count = 0;
        int coinCount = 0;
        int copyN = n;
        boolean completeTF = false;
        for ( coin5Count = 0; coin5Count <= n / 5; coin5Count++ ){
            copyN = n;
            copyN -= coin5Count * 5;

            if( copyN % 2 == 0 ){
                completeTF = true;
                coin2Count = copyN / 2;
                coinCount = coin5Count + coin2Count;
                minCoinCount = minCoinCount > coinCount ? coinCount : minCoinCount;
            }
        }
        if ( completeTF ){
            System.out.print(minCoinCount);
        } else {
            System.out.print(-1);
        }
    }
}
