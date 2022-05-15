import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_printStar_b3_10991 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder result = new StringBuilder();
		for (int row = 1; row <= N; row++) {
			String rowLine = spaces(N - row);
			for (int i = 1; i <= row; i++) {
				rowLine += stars(1) + spaces(1);
			}
			rowLine += "\n";
			result.append(rowLine);
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
