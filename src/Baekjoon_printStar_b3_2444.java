import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_printStar_b3_2444 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder result = new StringBuilder();
		for (int row = 1; row <= 2 * N - 1; row++) {
			String line;
			if (row <= N) {
				line = spaces(N - row) + stars(2 * row - 1);
			} else {
				line = spaces(row - N) + stars(4 * N - 2 * row - 1);
				// line = spaces(row - N) + stars(2*N - 2*(row-N) - 1);
			}
			result.append(line + "\n");
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
