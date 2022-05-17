import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Baekjoon_dynamicProgramming_g5_1025 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int[][] table;
    static List<Integer> completeNumberList = new ArrayList<>();
    static int maxCompleteNumber = -1;

    public static void main(String[] args) throws Exception {
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        completeNumberListSetting(N <= M ? M : N);
        // for (int i = 0; i < completeNumberList.size(); i++) {
        // System.out.println(" i = " + i + " : " + completeNumberList.get(i));
        // }

        table = new int[N + 1][M + 1];
        for (int row = 1; row <= N; row++) {
            String[] numbers = br.readLine().split("");
            for (int col = 1; col <= M; col++)
                table[row][col] = Integer.parseInt(numbers[col - 1]);
        }

        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= M; col++) {

                if (table[row][col] > maxCompleteNumber && completeNumberList.indexOf(table[row][col]) > -1) {
                    maxCompleteNumber = table[row][col];
                }

                // for (int colD = -M + 1; colD < M; colD++) {
                // if (colD == 0)
                // continue;
                // String rowColMax = Integer.toString(table[row][col]);
                // for (int i = 1; (col + i * colD) >= 1 && (col + i * colD) <= M; i++) {
                // rowColMax += Integer.toString(table[row][col + i * colD]);
                // int rowCol = Integer.parseInt(rowColMax);
                // if (rowCol > maxCompleteNumber && completeNumberList.indexOf(rowCol) > -1)
                // maxCompleteNumber = rowCol;
                // }
                // }

                // (int rowD = -N + 1; rowD < N; rowD++) {
                // rowD == 0)
                // continue;
                // String rowColMax = Integer.toString(table[row][col]);
                // (int i = 1; (row + i * rowD) >= 1 && (row + i * rowD) <= N; i++) {
                // rowColMax += Integer.toString(table[row + i * rowD][col]);
                // int rowCol = Integer.parseInt(rowColMax);
                // rowCol > maxCompleteNumber && completeNumberList.indexOf(rowCol) > -1)
                // maxCompleteNumber = rowCol;
                // }
                // }

                for (int rowD = -N + 1; rowD < N; rowD++) {
                    for (int colD = -M + 1; colD < M; colD++) {
                        if (rowD == 0 && colD == 0)
                            continue;

                        // System.out.println(">>>>>>>>>>>>>");
                        String rowColMax = Integer.toString(table[row][col]);
                        for (int i = 1; i < N && (row + i * rowD) >= 1 && (row + i * rowD) <= N; i++) {
                            for (int j = 1; j < M && (col + j * colD) >= 1 && (col + j * colD) <= M; j++) {

                                rowColMax += Integer.toString(table[row + i * rowD][col + j * colD]);
                                int rowCol = Integer.parseInt(rowColMax);
                                System.out.print((rowD) + ", " + (colD) + " : ");
                                System.out.print((i) + ", " + (j) + " : ");

                                System.out.println((row + i * rowD) + ", " + (col + j * colD) + " : " +
                                        rowCol);
                                // System.out.println(rowCol);
                                if (rowCol > maxCompleteNumber
                                        && (rowCol % 10 == 0 ||
                                                rowCol % 10 == 1 ||
                                                rowCol % 10 == 4 ||
                                                rowCol % 10 == 5 ||
                                                rowCol % 10 == 6 ||
                                                rowCol % 10 == 9)
                                        && completeNumberList.indexOf(rowCol) > -1)
                                    maxCompleteNumber = rowCol;
                                if (colD == 0)
                                    break;
                            }
                        }

                    }
                }

            } // col
        } // row

        System.out.print(maxCompleteNumber);

    }

    public static void completeNumberListSetting(int numberLength) {
        int maxNumber = 1;
        for (int i = 0; i < numberLength; i++) {
            maxNumber *= 10;
        }
        maxNumber -= 1;
        int tempCompleteNumber = 0;
        for (int square = 0; (tempCompleteNumber = square * square) < maxNumber; square++) {
            completeNumberList.add(tempCompleteNumber);
        }
    }

}
