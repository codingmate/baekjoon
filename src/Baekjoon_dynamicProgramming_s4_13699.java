import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
class Baekjoon_dynamicProgramming_s4_13699 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static List < Long > valueList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        
        n = Integer.parseInt(br.readLine());
        valueList.add(1l);
        for ( int i = 1; i <= n; i++ ){
            valueList.add(valueSetting(i));
        }
        
        System.out.println(valueList.get(n));
    }

    public static long valueSetting (int num) {
        Long value = 0l;
        for ( int i = 0; i < num; i++ ){
            value += valueList.get(i) * valueList.get(num-1-i);
        }
        return value;
    }
    
}
