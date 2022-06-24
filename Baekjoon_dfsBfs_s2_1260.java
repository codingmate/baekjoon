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
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws Exception {
        String[] NMV = br.readLine().split(" ");
        N = Integer.parseInt(NMV[0]);
        M = Integer.parseInt(NMV[1]);
        V = Integer.parseInt(NMV[2]);
        
        visited = new boolean[N+1];
        graph = new int[N+1][N+1];
        for ( int i = 1; i <= M; i++ ) {
            String[] edge = br.readLine().split(" ");
            int v1 = Integer.parseInt(edge[0]);
            int v2 = Integer.parseInt(edge[1]);
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
        
        dfs(V);
        result.append("\n");
        visited = new boolean[N+1];
        queue.add(V);
        visited[V] = true;
        while( queue.size() > 0 ) {
            int node = queue.get(0);
            result.append(node + " ");
            queue.remove(0);
            bfs(node);
        }
        System.out.println(result);
    } // main
    static void dfs( int from ) {
        result.append(from + " ");
        visited[from] = true;
        for ( int to = 1; to <= N; to++ )
            if( graph[from][to] == 1 && !visited[to]  )
                dfs(to);
    }

    static void bfs( int from ) {
        
        for ( int to = 1; to <= N; to++ ) {
            if( graph[from][to] == 1 && !visited[to] ) {
                visited[to] = true;
                queue.add(to);
            }
        }
    }
    
} // class
