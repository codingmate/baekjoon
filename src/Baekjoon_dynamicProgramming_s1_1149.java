import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Baekjoon_dynamicProgramming_s1_1149 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int costR;
    static int costG;
    static int costB;
    static int result = Integer.MAX_VALUE;
    static int[][] rgbs;
    static List<Integer> stack = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        rgbs = new int[N][N];
        for (int row = 0; row < N; row++) {
            String[] rgbLine = br.readLine().split(" ");
            int[] rgb = new int[3];
            rgb[0] = Integer.parseInt(rgbLine[0]);
            rgb[1] = Integer.parseInt(rgbLine[1]);
            rgb[2] = Integer.parseInt(rgbLine[2]);
            rgbs[row] = rgb;
        }

        for (int startNode = 0; startNode < 3; startNode++) {
            dfs(startNode);
        }
        System.out.print(result);
    }

    public static void dfs(int node) {

        stack.add(node);
        for (int nextNode = 0; nextNode < 3; nextNode++)
            if (stack.size() < N && node != nextNode)
                dfs(nextNode);
        if (stack.size() == N) {
            int tempSum = 0;
            for (int row = 0; row < N; row++) {
                tempSum += rgbs[row][stack.get(row)];
            }

            result = result > tempSum ? tempSum : result;
        }
        stack.remove(stack.size() - 1);
    }

}
