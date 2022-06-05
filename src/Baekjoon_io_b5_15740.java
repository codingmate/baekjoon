import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon_io_b5_15740 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] AB = br.readLine().split(" ");
        
        boolean AisMinus = false;
        boolean BisMinus = false;
        String A = AB[0];
        String B = AB[1];
        if ( A.charAt(0) == '-' ){
            A = A.substring(1);
            AisMinus = true;
        }
            
        if ( B.charAt(0) == '-' ){
            B = B.substring(1);
            BisMinus = true;
        }

        

        int diffLength = A.length() - B.length();
        if ( diffLength > 0 ){
            for ( int i = 0; i < diffLength; i++ ){
                B = "0" + B;
            }
        } else if ( diffLength < 0 ){
            for ( int i = 0; i < diffLength; i++ ){
                A = "0" + A;
            }
        }
        boolean AisGreaterThanB = false;

        List <Integer> sumList = new ArrayList<>();

        for ( int i = A.length()-1; i > -1; i-- ){

            Character charA = A.charAt(i);
            Character charB = B.charAt(i);
            int a = Integer.parseInt(charA.toString());
            int b = Integer.parseInt(charB.toString());
            int sum = (AisMinus ? -1 * a : a) + BisMinus ? b;
            sumList.add(a+b);
        }
        sumList.add(0);
        
        for ( int i = 0; i < sumList.size(); i++ ) {
            int sum = sumList.get(i);
            if ( sum / 10 > 0) {
                sumList.set(i+1, sumList.get(i+1) + sum/10);
                sumList.set(i, sum - 10 * (sum/10));
                //System.out.println("i : " + i + ", " + sumList.get(i) + " " + sumList.get(i+1));
            }
        }
        StringBuilder result = new StringBuilder();
        if ( sumList.get(sumList.size()-1) == 0 )
            sumList.remove(sumList.size()-1);
        for ( int i = sumList.size()-1; i > -1; i-- ){
            result.append(sumList.get(i));
        }
        
        System.out.println(result.toString());
    }
}