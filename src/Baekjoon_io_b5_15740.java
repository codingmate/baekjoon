import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon_io_b5_15740 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] AB = br.readLine().split(" ");
        
        boolean AisNegative = false;
        boolean BisNegative = false;
        String A = AB[0];
        String B = AB[1];
        /* 마이너스 부호 제거 및 A, B 음수 판별 */
        if ( A.charAt(0) == '-' ){
            A = A.substring(1);
            AisNegative = true;
        }
        if ( B.charAt(0) == '-' ){
            B = B.substring(1);
            BisNegative = true;
        }

        /* A와 B의 길이를 맞추기 위한 보정 작업 ( 앞을 0으로 채움) */
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

        /* A와 B의 절댓값 비교 -> A가 B보다 큰지 판별 */
        boolean AisGreaterThanB = false;
        boolean AEqualB = false;
        for ( int i = A.length()-1; i > -1; --i ){
            Character charA = A.charAt(i);
            Character charB = B.charAt(i);
            int a = Integer.parseInt(charA.toString());
            int b = Integer.parseInt(charB.toString());

            if ( a > b ) {
                AisGreaterThanB = true;
                break;
            } else if ( a < b ){
                AisGreaterThanB = false;
                break;
            } else if (i == 0) { /* a == b */
                AEqualB = true;
            } 
        }
        
        /* 각 자릿 수의 연산 결과를 저장하는 리스트 (가장 오른쪽 자릿수부터 저장) */
        List <Integer> sumList = new ArrayList<>();
        /* 올림 수로 하나의 자릿수 추가 */
        sumList.add(0);
        /* A, B 둘 다 양수 또는 둘 다 음수일 때 */
        if ( AisNegative = BisNegative ) {

            /* 두 절댓값을 더하는 연산 */
            for ( int i = A.length()-1; i > -1; i-- ){

                Character charA = A.charAt(i);
                Character charB = B.charAt(i);
                int a = Integer.parseInt(charA.toString());
                int b = Integer.parseInt(charB.toString());
                int sum = a+b;
                sumList.add(sum);
            }
            /* 각 자릿수의 합이 10이 넘을 경우, 올림수 반영 */
            for ( int i = 0; i < sumList.size(); i++ ) {
                int sum = sumList.get(i);
                if ( sum > 10) {
                    sumList.set(i+1, sumList.get(i+1) + 1);
                    sumList.set(i, sum - 10);
                    //System.out.println("i : " + i + ", " + sumList.get(i) + " " + sumList.get(i+1));
                }
            }
        }
        /* A와 B중 하나만 음수일 때 */
        else {
            /* 두 절댓값에서, 큰 값에서 작은 값 뺴는 연산 */
            for ( int i = A.length()-1; i > -1; i-- ){

                Character charA = A.charAt(i);
                Character charB = B.charAt(i);
                int a = Integer.parseInt(charA.toString());
                int b = Integer.parseInt(charB.toString());
                int sum = AisGreaterThanB ? a - b : b - a;
                sumList.add(sum);
            }
            /* 각 자릿수의 합이 0보다 작을 경우, 내림수 반영 */
            for ( int i = sumList.size()-1; i > -1; i-- ) {
                int sum = sumList.get(i);
                if ( sum < 0) {
                    sumList.set(i+1, sumList.get(i+1) - 1);
                    sumList.set(i, sum + 10);
                    //System.out.println("i : " + i + ", " + sumList.get(i) + " " + sumList.get(i+1));
                }
            }
        }
        
        StringBuilder result = new StringBuilder();
        if ( (AisGreaterThanB && AisNegative) || (!AisGreaterThanB )){
            result.append("-");
        } 
        if ( sumList.get(sumList.size()-1) == 0 )
            sumList.remove(sumList.size()-1);
        for ( int i = sumList.size()-1; i > -1; i-- ){
            result.append(sumList.get(i));
        }
        
        System.out.println(result.toString());
    }
}