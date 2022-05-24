import java.io.BufferedReader;
import java.io.InputStreamReader;
class Baekjoon_dynamicProgramming_b1_17202 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String numLine1;
    static String numLine2;
    public static void main(String[] args) throws Exception {
        numLine1 = br.readLine();
        numLine2 = br.readLine();

        StringBuilder startLine = new StringBuilder();
        for ( int i = 0; i < 8; i++ ){
            startLine.append(numLine1.charAt(i));
            startLine.append(numLine2.charAt(i));
        }
    
        while( startLine.length() > 2 ){
            StringBuilder nextLine = new StringBuilder();
            for ( int i = 0; i < startLine.length()-1; i++ ){
                nextLine.append( (Integer.parseInt(startLine.substring(i,i+1)) + Integer.parseInt(startLine.substring(i+1,i+2))) % 10 );
            }
            startLine = nextLine;
        }
        System.out.println(startLine);
    }
}
