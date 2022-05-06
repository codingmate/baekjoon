import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon_backtracking_15654 {
	
	static StringBuilder result = new StringBuilder();
	static List<Integer> printStack = new ArrayList<>();
    static List<Integer> ascSortedNumbers = new ArrayList<>();
	static int[][] graph;
	static int N;
	static int M;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] splitLine = br.readLine().split(" ");
	    N = Integer.parseInt(splitLine[0]);
	    M = Integer.parseInt(splitLine[1]);

        String[] stringNumbers = br.readLine().split(" ");
        
        for ( int i = 0; i < N; i++ ) {
            int number = Integer.parseInt(stringNumbers[i]);
            if ( ascSortedNumbers.size() == 0 ){
                ascSortedNumbers.add(number);
            }
            else {
                for ( int j = 0; j < ascSortedNumbers.size(); j++ )
                    if ( number >= ascSortedNumbers.get(j) ){
                        if ( j == ascSortedNumbers.size() - 1 ){
                            ascSortedNumbers.add(number);
                            break;
                        }
                        else continue;
                    } else {
                        ascSortedNumbers.add(j, number);
                        break;
                    }
            }
        }
	    
	    graph = new int[N][N];
	    for ( int fromIndex = 0; fromIndex < N; fromIndex++ )
	    	for ( int toIndex = 0; toIndex < N; toIndex++ )
                if ( fromIndex != toIndex )
	    		    graph[fromIndex][toIndex] = 1;
        
	    
	    for ( int startIndex = 0; startIndex < N; startIndex++ )
	    	dfs(startIndex);
	    
	    System.out.print(result);
	}
	
	public static void dfs(int fromIndex) {
		
		printStack.add(fromIndex);
		
		for ( int toIndex = 0; toIndex < N; toIndex++ )
			if( printStack.size() < M 
			 && graph[fromIndex][toIndex] == 1
             && printStack.indexOf(toIndex) == -1
			  ) {
				dfs(toIndex);
			}
		
		if ( printStack.size() == M ) {
			for ( int i = 0; i < printStack.size(); i++ ) {
				result.append(ascSortedNumbers.get(printStack.get(i)) + " ");
			}
			result.append("\n");
		}
        
		printStack.remove(printStack.size() - 1);
	}
}
