import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_printStar_b3_10996 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder result = new StringBuilder();
		StringBuilder evenRowSet = new StringBuilder();
		StringBuilder oddRowSet = new StringBuilder();
		for (int i = 1; i <= (N % 2 == 1 ? N / 2 + 1 : N / 2); i++)
			oddRowSet.append("* ");
		for (int i = 1; i <= N / 2; i++)
			evenRowSet.append(" *");

		for (int row = 1; row <= 2 * N; row++) {
			String rowLine = row % 2 == 0 ? evenRowSet.toString() : oddRowSet.toString();
			result.append(rowLine + "\n");
		}
		result.deleteCharAt(result.lastIndexOf("\n"));
		System.out.print(result);
	}

	public static String stars(int count) {

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < count; i++) {
			result.append("*");
		}
		return result.toString();
	}

	public static String spaces(int count) {

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < count; i++) {
			result.append(" ");
		}
		return result.toString();
	}
}
