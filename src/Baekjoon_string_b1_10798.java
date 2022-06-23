import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
public class Baekjoon_string_b1_10798 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        List<String> lineList = new ArrayList<>();
        int maxLineLength = 0;
        String line;
        while ( (line = br.readLine()) != null ) { 
            lineList.add(line);
            if ( line.length() > maxLineLength )
                maxLineLength = line.length();
        }   

        StringBuilder result = new StringBuilder();

        for ( int col = 0; col < maxLineLength; col++ ) {
            for ( int row = 0; row < lineList.size(); row++ ) {
                String s = lineList.get(row);
                if ( col < s.length() )
                    result.append(s.charAt(col));
            }
        }

        System.out.print(result.toString());
        
    }
}
