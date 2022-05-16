import java.io.BufferedReader;
import java.io.InputStreamReader;

class Baekjoon_dynamicProgramming_s3_9095 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static int[] countNs = new int[12];
    static StringBuilder result = new StringBuilder();


    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        countNs[0] = 1;
        countNs[1] = 1;
        countNs[2] = 2;
        settingCountNs();
        
        for ( int row = 0 ; row < T; row++ ){
            int n = Integer.parseInt(br.readLine());
            result.append(countNs[n] + "\n");
        }
        System.out.print(result);
    }
    public static void settingCountNs(){
        for ( int i = 3; i <= 11; i++ ){
            countNs[i] = getCountN(i);
        }
    }
    public static int getCountN (int n){
        if( n < 2 ){
            return 1;
        } else if ( n == 2 ) {
            return 2;
        } else {
            return getCountN(n-1) + getCountN(n-2) + getCountN(n-3);
        }
    }


}
