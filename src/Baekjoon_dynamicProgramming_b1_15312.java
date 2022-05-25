import java.io.BufferedReader;
import java.io.InputStreamReader;
class Baekjoon_dynamicProgramming_b1_15312 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String nameLine1;
    static String nameLine2;
    static int[] counts = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
    public static void main(String[] args) throws Exception {
        
        nameLine1 = br.readLine();
        nameLine2 = br.readLine();
        
        StringBuilder startLine = new StringBuilder();
        for ( int i = 0; i < nameLine1.length(); i++ ){
            startLine.append(counts[(int)nameLine1.charAt(i)-65]);
            startLine.append(counts[(int)nameLine2.charAt(i)-65]);
        }

        while( startLine.length() > 2 ){
            StringBuilder nextLine = new StringBuilder();
            for ( int i = 0; i < startLine.length()-1; i++ ){
                nextLine.append( (Integer.parseInt(startLine.substring(i,i+1)) + Integer.parseInt(startLine.substring(i+1,i+2))) % 10 );
            }
            startLine = nextLine;
        }
       System.out.print(startLine);
    }
}
