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
    static List<Point> queue = new LinkedList<>();
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
                if ( graph[row][col] == 1 ) 
                    visited[row][col] = true;
            }
        }
        
        Point temp = new Point(0, 0);
        bfs(temp);
        while( queue.size() > 0 ) {
            Point p = queue.get(0);
            bfs(p);
            System.out.printf("x : %d, y : %d\n", p.row, p.col);
            queue.remove(0);
        }
        
    }

    public static void bfs( Point p ) {
        visited[p.row][p.col] = true;
        p.insertNextPoint();
        for ( Point po : queue ) {
            System.out.println(po.row + " " + po.col);
        }
    }
    
    
    public static class Point {
        public int row;
        public int col;
        public Point( int row, int col ) {
            this.row = row;
            this.col = col;
        }
        public boolean insertNextPoint() {

            System.out.printf("x : %d, y : %d, %b\n", row-1, col, row > 0 ? visited[row-1][col] : false);
            System.out.printf("x : %d, y : %d, %b\n", row+1, col, row < N-1 ? visited[row+1][col] : false);
            System.out.printf("x : %d, y : %d, %b\n", row, col+1, col < M-1 ? visited[row][col+1] : false);
            System.out.printf("x : %d, y : %d, %b\n", row, col-1, col > 0 ? visited[row][col-1] : false);
            System.out.println(queue.size());
            if ( col > 0 ? visited[row][col-1] : true
              && col < M-1 ? visited[row][col+1] : true
              && row < N-1 ? visited[row+1][col] : true
              && row > 0 ? visited[row-1][col] : true) {
                return false;
            } else {
                
                if ( row > 0 
                && graph[row-1][col] == 1 
                && !visited[row-1][col]  ) {
                    queue.add(new Point(row-1, col));
                }
                if ( row < N - 1 
                && graph[row+1][col] == 1 
                && !visited[row+1][col] ) {
                    queue.add(new Point(row+1, col));
                }
                if ( col > 0 
                && graph[row][col-1] == 1 
                && !visited[row][col-1] ) {
                    queue.add(new Point(row, col-1));                    
                }
                if ( col < M - 1 
                && graph[row][col+1] == 1 
                && !visited[row][col+1] ) {
                    queue.add(new Point(row, col+1));
                }
            }
            return true;
        }
    }
}
