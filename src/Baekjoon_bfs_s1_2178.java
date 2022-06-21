import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Baekjoon_bfs_s1_2178 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N = 0;
    static int M = 0;
    static int[][] graph;
    static int[][] distances;
    static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        graph = new int[N][M];
        distances = new int[N][M];
        for ( int row = 0; row < N; row++ ) {
            String[] numbers = br.readLine().split("");
            for ( int col = 0; col < M; col++ ) {
                graph[row][col] = Integer.parseInt(numbers[col]);
                if ( graph[row][col] == 0 ) 
                    distances[row][col] = Integer.MAX_VALUE;
            }
        }

        Point start = new Point(0, 0);
        distances[0][0] = 1;
        bfs(start);
        while( !queue.isEmpty() ) {
            bfs(queue.poll());
        }
        br.close();
        System.out.print(distances[N-1][M-1]);

    }

    public static void bfs( Point p ) {
        int cost = distances[p.row][p.col];
        int nextRow, nextCol;

        if ( p.row > 0 ) {
            nextRow = p.row-1;
            nextCol = p.col;
            if ( graph[nextRow][nextCol] == 1 && distances[nextRow][nextCol] == 0 ) {
                distances[nextRow][nextCol] = cost + 1;
                queue.add(new Point(nextRow, nextCol));
            }
        }
        if ( p.col > 0 ) {
            nextRow = p.row;
            nextCol = p.col-1;
            if ( graph[nextRow][nextCol] == 1 && distances[nextRow][nextCol] == 0 ) {
                distances[nextRow][nextCol] = cost + 1;
                queue.add(new Point(nextRow, nextCol));
            }
        }

        if ( p.row < N-1 ) {
            nextRow = p.row+1;
            nextCol = p.col;
            if ( graph[nextRow][nextCol] == 1 && distances[nextRow][nextCol] == 0 ) {
                distances[nextRow][nextCol] = cost + 1;
                queue.add(new Point(nextRow, nextCol));
            }
        }

        if ( p.col < M-1 ) {
            nextRow = p.row;
            nextCol = p.col+1;
            if ( graph[nextRow][nextCol] == 1 && distances[nextRow][nextCol] == 0 ) {
                distances[nextRow][nextCol] = cost + 1;
                queue.add(new Point(nextRow, nextCol));
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
