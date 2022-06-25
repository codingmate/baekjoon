import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.LinkedList;

class Baekjoon_dfsBfs_s3_2606 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static boolean[] visited;
    static int[][] graph;
    static List<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        visited = new boolean[N+1];
        graph = new int[N+1][N+1];
        for ( int i = 0; i < M; i++ ) {
            String[] edge = br.readLine().split(" ");
            int v1 = Integer.parseInt(edge[0]);
            int v2 = Integer.parseInt(edge[1]);
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
        
        visited = new boolean[N+1];
        visited[1] = true;
        bfs(1);
        while ( queue.size() > 0 ) {
            int node = queue.get(0);
            queue.remove(0);
            bfs(node);
        }

        int count = 0;
        for ( int i = 2; i < visited.length; i++ ) 
            if ( visited[i] )
                count++;
        System.out.print(count);
        
    } // main

    static void bfs( int from ) {
        visited[from] = true;
        for ( int to = 1; to <= N; to++ ) {
            if( graph[from][to] == 1 && !visited[to] )
               queue.add(to);
        }
    }
    
} // class
