import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_printStar_b2_10996 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder result = new StringBuilder();
		String setN = spaces(N - 1) + "*" + spaces(N - 2) + "*" + spaces(N - 2) + "*";
		String setStartOrEnd = stars(N) + spaces(2 * N - 3) + stars(N);
		String set = "*" + spaces(N - 2) + "*";

		for (int row = 1; row <= 2 * N - 1; row++) {
			String rowLine = (row == 1 || row == 2 * N - 1) ? setStartOrEnd
					: row == N ? setN
							: spaces(row < N ? row - 1 : 2 * N - row - 1) + set.toString()
									+ spaces(row < N ? 2 * (N - row) - 1 : 2 * (row - N) - 1)
									+ set.toString();
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
