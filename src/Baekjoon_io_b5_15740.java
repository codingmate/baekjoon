import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon_io_b5_15740 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] AB = br.readLine().split(" ");
        String A = AB[0];
        String B = AB[1];

        boolean AisNegative = false;
        boolean BisNegative = false;
        /* A (-) 부호 제거 */
        if ( A.charAt(0) == '-' ) {
            AisNegative = true;
            A = A.substring(1);
        }
        /* B (-) 부호 제거 */
        if ( B.charAt(0) == '-'  ) {
            BisNegative = true;
            B = B.substring(1);
        }


        /* A와 B의 절댓값의 자릿수 맞춰주기 ( 앞을 0으로 채우기 ) */
        int diffLength = A.length() - B.length();
        if ( diffLength > 0 ){
            for ( int i = 0; i < diffLength; i++ ){
                B = "0" + B;
            }
        } else if ( diffLength < 0 ){
            for ( int i = 0; i < (-1 * diffLength); i++ ){
                A = "0" + A;
            }
        }  
        /* A와 B의 절댓값 중 누가 더 큰지 판별 */
        boolean AIsGreaterThanB = false;
        boolean BIsGreaterThanA = false;

        for ( int i = 0; i < A.length(); i++ ){
            Character charA = A.charAt(i);
            Character charB = B.charAt(i);

            int a = Integer.parseInt(charA.toString());
            int b = Integer.parseInt(charB.toString());

            if ( a > b ) {
                AIsGreaterThanB = true;
                break;
            } else if ( b > a ) {
                BIsGreaterThanA = true;
                break;
            } else if ( i == A.length() - 1 ) {
                /* 둘이 같음 */
            }
        }

        /* 각 자리 숫자를 연산한 결과를 갖는 List */
        List <Integer> sumList = new ArrayList<>();

        /* 최대 자릿수 증가 가능성으로, 자릿수 하나 더 추가 */
        sumList.add(0);

        if ( AisNegative == BisNegative ){
            /* 1. A, B의 부호가 같을 때 각 자릿수 더해서 sumList에 넣기 */
            for ( int i = 0; i < A.length(); i++ ) {
                Character charA = A.charAt(i);
                Character charB = B.charAt(i);

                int a = Integer.parseInt(charA.toString());
                int b = Integer.parseInt(charB.toString());

                sumList.add(a+b);
            }
            /* 각 자릿수가 10 이상이면 위로 올린다. */
            for ( int i = A.length(); i > -1; i-- ) {
                int sum = sumList.get(i);
                if ( sum >= 10 ) {
                    sumList.set( i - 1, sumList.get(i-1) + 1 );
                    sumList.set( i, sum - 10);
                }
            }
        } else {
            /* 2. A, B의 부호가 다를 때 */
            for ( int i = 0; i < A.length(); i++ ) {
                Character charA = A.charAt(i);
                Character charB = B.charAt(i);

                int a = Integer.parseInt(charA.toString());
                int b = Integer.parseInt(charB.toString());

                int sum = AIsGreaterThanB ? (a-b) : (b-a);
                sumList.add(sum);
            }
            /* 각 자릿수가 0보다 작으면 위로 내린다. */
            for ( int i = A.length(); i > -1; i-- ) {
                int sum = sumList.get(i);
                if ( sum < 0 ) {
                    sumList.set( i - 1, sumList.get(i-1) - 1 );
                    sumList.set( i, sum + 10);
                }
            }
        }
        /* 최대 자릿수 증가를 대비하여 넣은 값이 0이면 삭제 */
        //if (sumList.get(0) == 0)
        //    sumList.remove(0);
        
        StringBuilder result = new StringBuilder();
        int firstNot0Index = 0;
        for ( int i = 0; i < sumList.size(); ++i ){
            int sum = sumList.get(i);
            if ( sum > 0 && firstNot0Index == 0 ){
                firstNot0Index = i;
            }
            if (sum == 0 && firstNot0Index == 0) continue;
            result.append(sumList.get(i));
        }
        
        if ( result.length() == 0 ) {
            result.append("0");
        }

        if( ( AisNegative == true 
           && BisNegative == false
           && AIsGreaterThanB == true) 
         || ( BisNegative == true
           && AisNegative == false
           && BIsGreaterThanA == true
            )
         || ( BisNegative == true 
           && AisNegative == true
            )
          ){
            System.out.print( "-" + result.toString());
        } else 
            System.out.print( result.toString() );
        
        
        
    }
}
