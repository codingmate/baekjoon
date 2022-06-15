import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.LinkedList;

public class Baekjoon_bfs_s1_2178 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N = 0;
    static int M = 0;
    static int[][] graph;
    static boolean[][] visited;
    static List<String> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        graph = new int[N][M];
        visited = new boolean[N][M];
        for ( int row = 0; row < N; row++ ) {
            String[] numbers = br.readLine().split("");
            for ( int col = 0; col < M; col++ ) {
                graph[row][col] = Integer.parseInt(numbers[col]);
            }
        }

        for ( int row = 0; row < N; row++ ) {
            for (int col = 0; col < M; col++ ){
                System.out.print(graph[row][col] + " ");
            }
            System.out.println();
        }

        bfs(0, 0);
    }

    public static void bfs( int fromX, int fromY ) {
        visited[fromX][fromY] = true;
        
        if ( fromY > 0 && !visited[fromX][fromY-1] ) {
            queue.add(set(fromX, fromY-1));
            visited[fromX][fromY-1] = true;
        }
        if ( fromY < N - 1 && !visited[fromX][fromY+1] ) {
            queue.add(set(fromX, fromY+1));
            visited[fromX+1][fromY] = true;
        }
        if ( fromX > 0 && !visited[fromX-1][fromY] ) {
            queue.add(set(fromX-1, fromY));
            visited[fromX-1][fromY] = true;
        }
        if ( fromX < M - 1 && !visited[fromX+1][fromY] ) {
            queue.add(set(fromX+1, fromY));
            visited[fromX+1][fromY] = true;
        }

        while( queue.size() > 0 ) {
            int[] XY = get(queue.get(0));
            bfs(XY[0], XY[1]);
            queue.remove(queue.size() - 1);    
        }
    }
    public static String set(int a, int b) {
        return a + "\\" + b;
    }

    public static int[] get(String xy) {
        String[] X_Y = xy.split("\\");
        int[] XY = { Integer.parseInt(X_Y[0]), Integer.parseInt(X_Y[1]) };

        return XY;
    }
}
