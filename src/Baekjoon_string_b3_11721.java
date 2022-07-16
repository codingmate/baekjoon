import java.io.*;

public class Baekjoon_string_b3_11721 {
    
    public static void main ( String[] args ) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        StringBuilder result = new StringBuilder();
        for ( int i = 0 ; i < line.length(); i += 10 ) {

            if ( (i+10) > line.length() )
                result.append( line.substring(i) );
            else 
                result.append( line.substring(i, i+10) + "\n" );
        }
        System.out.print(result.toString());
    }

}
