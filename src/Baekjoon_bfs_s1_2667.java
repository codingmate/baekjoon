import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Baekjoon_bfs_s1_2667 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N = 0;
    static int M = 0;
    static int[][] graph;
    static int[] deltaRow = {-1, 1, 0, 0};
    static int[] deltaCol = {0, 0, -1, 1};
    static Queue<Point> queue = new LinkedList<>();
    static int cost = 1;
    public static void main(String[] args) throws Exception {
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = N;
        graph = new int[N][M];
        for ( int row = 0; row < N; row++ ) {
            String[] numbers = br.readLine().split("");
            for ( int col = 0; col < M; col++ ) {
                graph[row][col] = Integer.parseInt(numbers[col]);
            }
        }

        Point start = new Point(0, 0);
        bfs(start);
        while( isExist1() ) {
            cost++;
            while( !queue.isEmpty() ) {
                bfs(queue.poll());
            }
        }
        
        br.close();

    }

    public static boolean isExist1 () {
        for ( int row = 0; row < N; row++ )
            for ( int col = 0; col < M; col++ )
                if ( graph[row][col] == 1) return true;
        return false;
    }

    public static void bfs( Point p ) {
        
        graph[p.row][p.col] = 1;
        for ( int i = 0; i < deltaCol.length; i++ ) {
            int nextRow = p.row + deltaRow[i];
            int nextCol = p.col + deltaCol[i];
            if ( nextRow > -1 && nextRow < N
              && nextCol > -1 && nextCol < M ) {
                if ( graph[nextRow][nextCol] == 1 ) {
                    graph[nextRow][nextCol] = cost;
                    queue.add(new Point(nextRow, nextCol));
                }    
            }
        }
    }
        
    public static class Point {
        public int row;
        public int col;
        public Point( int row, int col ) {
            this.row = row;
            this.col = col;
        }
    }
}
