import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.LinkedList;

class Baekjoon_dfsBfs_s2_1260 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int V;
    static boolean[] visited;
    static int[][] graph;
    static List<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        String[] NMV = br.readLine().split(" ");
        N = Integer.parseInt(NMV[0]);
        M = Integer.parseInt(NMV[1]);
        V = Integer.parseInt(NMV[2]);
        
        visited = new boolean[N+1];
        graph = new int[N+1][N+1];
        for ( int i = 0; i < M; i++ ) {
            String[] edge = br.readLine().split(" ");
            int v1 = Integer.parseInt(edge[0]);
            int v2 = Integer.parseInt(edge[1]);
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
        
        dfs(V);
        visited = new boolean[N+1];
        bfs(V);
        
    } // main
    static void dfs( int from ) {
        visited[from] = true;
        for ( int to = 1; to < N; to++ )
            if( graph[from][to] == 1 && !visited[to] )
                dfs(to);
        visited[from] = false; 
    }

    static void bfs( int from ) {
        
        for ( int to = 1; to < N; to++ ) {
            if( graph[from][to] == 1 && !visited[to] )
                
        }
    }
    
} // class
