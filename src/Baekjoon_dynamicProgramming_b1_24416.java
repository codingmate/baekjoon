import java.io.BufferedReader;
import java.io.InputStreamReader;
class Baekjoon_dynamicProgramming_b1_24416 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int executeCount1 = 0;
    static int executeCount2 = 0;
    static int[] tempFibonacci;
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        tempFibonacci = new int[n];
        tempFibonacci[0] = 1;
        tempFibonacci[1] = 1;
        fib(n);
        fibonacci(n);

        System.out.println(executeCount1 + " " + executeCount2);
    }

    public static long fib(int number) {
        if (number == 1 || number == 2) {
            executeCount1++;
            return 1;
        }
        else {
            return (fib(number - 1) + fib(number - 2));
        }
    }

    public static long fibonacci(int number){
        long result = 0;
        if ( number == 1 || number == 2 ) {
            executeCount2++;
        } else {
            for ( int index = 2; index < number; index++ ){
                executeCount2++;
                 tempFibonacci[index] = tempFibonacci[index-1] = tempFibonacci[index-2];
            }
            return result;
        }
        


        return result;
    }
        

}
