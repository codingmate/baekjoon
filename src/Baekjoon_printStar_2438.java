package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_print_2438 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    
	    StringBuilder result = new StringBuilder();
	    for (int row = 1; row <= N; row++) {
	    	for (int i = 1; i <= row; i++) {
	    		result.append("*");
	    	}
	    	result.append("\n");
	    }
	    
	    System.out.print(result);
	}
}
