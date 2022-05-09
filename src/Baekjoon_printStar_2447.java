import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_printStar_2447 {

	static int[][] matrix;
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		matrix = new int[N + 1][N + 1];
		for (int row = 1; row <= N; row++)
			for (int col = 1; col <= N; col++)
				matrix[row][col] = 1;

		for (int i = 1; i <= numberIs3ToThePowerOfX(N); i++) {
			executeIndex(i);
		}

		System.out.println(buildMatrix());

	} // main

	public static int numberIs3ToThePowerOfX(int number) {
		int count = 0;
		int copyN = N;
		while (copyN > 1) {
			copyN /= 3;
			count++;
		}
		return count;
	}

	public static int power3(int count) {
		int result = 1;
		for (int i = 0; i < count; i++) {
			result *= 3;
		}
		return result;
	} // power3

	public static void executeIndex(int index) {
		int power3 = power3(index);
		for (int row = 1; row <= N; row++)
			for (int col = 1; col <= N; col++)
				if (row % power3 >= (power3 / 3 + 1) && row % power3 <= (2 * power3 / 3)
						&& col % power3 >= (power3 / 3 + 1) && col % power3 <= (2 * power3 / 3))
					matrix[row][col] = 0;
	} // executeIndex

	public static String buildMatrix() {
		StringBuilder result = new StringBuilder();
		for (int row = 1; row <= N; row++) {
			for (int col = 1; col <= N; col++)
				result.append(matrix[row][col] == 1 ? "*" : " ");
			result.append("\n");
		}
		return result.toString();
	} // buildMatrix

}
