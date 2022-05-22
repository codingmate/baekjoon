import java.io.BufferedReader;
import java.io.InputStreamReader;
class Baekjoon_dynamicProgramming_b1_24416 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int executeCount1 = 0;
    static int executeCount2 = 0;
    static int[] tempFibonacci = new int[4];
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        tempFibonacci[1] = 1;
        tempFibonacci[2] = 2;
        fib(n);
        fibonacci(n);

        System.out.println(executeCount1 + " " + executeCount2);
    }

    public static long fib(int number) {
        executeCount1++;
        if (number == 1 || number == 2) {
            return 1;
        }
        else {
            return (fib(number - 1) + fib(number - 2));
        }
    }

    public static long fibonacci(int number){
        long result = 0;
        executeCount2++;
        if ( number == 1 || number == 2 ) {
        } else {
            for ( int i = 3; i <= number; i++ ){
                fibonacci(i) // ing
            )
        }
        


        return result;
    }
        

}
