import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.LinkedList;

public class Baekjoon_bfs_s1_2178 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N = 0;
    static int M = 0;
    static int[][] graph;
    static int[][] distances;
    static List<Point> queue = new LinkedList<>();
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
                else
                    distances[row][col] = -1;
            }
        }

        Point start = new Point(0, 0);
        bfs(start);
        distances[0][0] = 1;
        while( queue.size() > 0 ) {
            
            Point p = queue.get(0);
            bfs(p);
            queue.remove(0);
        }
        
        System.out.print(distances[N-1][M-1]);

    }

    public static void bfs( Point p ) {
        distances[p.row][p.col] = p.getMinDistance();
        p.insertNextAblePointList();
    }
        
    public static class Point {
        public int row;
        public int col;
        public Point( int row, int col ) {
            this.row = row;
            this.col = col;
        }

        public int getMinDistance() {
            int distance = Integer.MAX_VALUE;
            
            if ( this.row > 0 
            && graph[this.row-1][this.col] == 1 
            && distances[this.row-1][this.col] != -1 ) 
                distance = distance > (distances[this.row-1][this.col] + 1)
                         ? distances[this.row-1][this.col] + 1
                         : distance;

            if ( this.row < N - 1 
            && graph[this.row+1][this.col] == 1 
            && distances[this.row+1][this.col] != -1 )
                distance = distance > (distances[this.row+1][this.col] + 1)
                         ? distances[this.row+1][this.col] + 1
                         : distance;
            if ( this.col > 0 
            && graph[this.row][this.col-1] == 1 
            && distances[this.row][this.col-1] != -1 ) 
                distance = distance > (distances[this.row][this.col-1] + 1)
                         ? distances[this.row][this.col-1] + 1
                         : distance;

            if ( this.col < M - 1 
            && graph[this.row][this.col+1] == 1 
            && distances[this.row][this.col+1] != -1 )
                distance = distance > (distances[this.row][this.col+1] + 1)
                         ? distances[this.row][this.col+1] + 1
                         : distance;
            
            return distance;
        }

        public void insertNextAblePointList() {

            if ( this.row > 0 
            && graph[this.row-1][this.col] == 1 
            && distances[this.row-1][this.col] == -1 ) {
                queue.add(new Point(this.row-1, this.col));
            }
            if ( this.row < N - 1 
            && graph[this.row+1][this.col] == 1 
            && distances[this.row+1][this.col] == -1 ) {
                queue.add(new Point(this.row+1, this.col));
            }
            if ( this.col > 0 
            && graph[this.row][this.col-1] == 1 
            && distances[this.row][this.col-1] == -1 ) {
                queue.add(new Point(this.row, this.col-1));
            }
            if ( this.col < M - 1 
            && graph[this.row][this.col+1] == 1 
            && distances[this.row][this.col+1] == -1 ) {
                queue.add(new Point(this.row, this.col+1));
            }
        }

        public String toString() {
            return this.row + " " + this.col;
        }
    }
}
