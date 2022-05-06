import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static StringBuilder result = new StringBuilder();
	static List<Integer> printStack = new ArrayList<>();
	static int[][] graph;
	static int N;
	static int M;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] splitLine = br.readLine().split(" ");
	    N = Integer.parseInt(splitLine[0]);
	    M = Integer.parseInt(splitLine[1]);
	    
	    graph = new int[N+1][N+1];
	    for ( int fromIndex = 1; fromIndex <= N; fromIndex++ )
	    	for ( int toIndex = 1; toIndex <= N; toIndex++ )
                if ( fromIndex <= toIndex )
	    		    graph[fromIndex][toIndex] = 1;
        
	    
	    for ( int startIndex = 1; startIndex <= N; startIndex++ )
	    	dfs(startIndex);
	    
	    System.out.print(result);
	}
	
	public static void dfs(int fromIndex) {
		
		printStack.add(fromIndex);
		
		for ( int toIndex = 1; toIndex <= N; toIndex++ )
			if( printStack.size() < M 
			 && graph[fromIndex][toIndex] == 1 
			  ) {
				dfs(toIndex);
			}
		
		if ( printStack.size() == M ) {
			for ( int i = 0; i < printStack.size(); i++ ) {
				result.append(printStack.get(i) + " ");
			}
			result.append("\n");
		}
        
		printStack.remove(printStack.size() - 1);
	}
}
