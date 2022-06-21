import java.io.BufferedReader;
import java.io.InputStreamReader;

class Baekjoon_implement_s3_17413 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        String line = br.readLine();
        String[] splitLine = line.split("");
        boolean isTagged = false;
        int wordStartIdx = 0;
        int wordEndIdx = 0;
        for ( int i = 0; i < splitLine.length; i++ ) {
            String s = splitLine[i];
            wordEndIdx = i;
            switch(s) {
                case "<":
                    if( wordStartIdx != wordEndIdx ) {
                        result.append(reverse(line.substring(wordStartIdx, wordEndIdx)));    
                    }
                    isTagged = true;
                    result.append(s);
                    break;
                case ">":
                    isTagged = false;
                    result.append(s);
                    wordStartIdx = i+1;
                    break;
                case " ":
                    if ( isTagged ) {
                        result.append(s);
                        continue;
                    }    
                    result.append(reverse(line.substring(wordStartIdx, wordEndIdx)));
                    result.append(s);
                    wordStartIdx = wordEndIdx + 1;
                    break;
                default :
                    if ( isTagged )
                        result.append(s);
                    break;
            } // switch
        } // for
        if ( !isTagged ) {
            result.append(reverse(line.substring(wordStartIdx, wordEndIdx+1)));
        }

        System.out.print(result);
    } // main

    static String reverse( String s ){
        String[] splitS = s.split("");
        StringBuilder result = new StringBuilder();
        for ( int i = splitS.length - 1; i > -1; i-- ) {
            result.append(splitS[i]);
        }
        return result.toString();
    }
} // class
