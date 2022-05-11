import java.util.List;
import java.util.ArrayList;

class Baekjoon_dynamicProgramming_s5_4673 {

    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws Exception {
        List<Integer> haveConstructorNumberList = new ArrayList<>();
        for (Integer i = 1; i <= 10000; i++) {
            haveConstructorNumberList.add(dN(i));
        }
        for (int i = 1; i < 10000; i++)
            if (haveConstructorNumberList.indexOf(i) == -1) {
                result.append(i + "\n");
            }

        System.out.print(result);
    }

    public static int dN(Integer n) {

        int result = n;
        String strN = n.toString();
        for (String num : strN.split("")) {
            result += Integer.parseInt(num);
        }
        return result;
    }
}
