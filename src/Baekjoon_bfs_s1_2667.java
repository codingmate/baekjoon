import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Baekjoon_bfs_s1_2667 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N = 0;
    static int M = 0;
    static int[][] graph;
    static int[] deltaRow = {-1, 1, 0, 0};
    static int[] deltaCol = {0, 0, -1, 1};
    static Queue<Point> queue = new LinkedList<>();
    static int cost = 1;
    static HashMap<Integer, Integer> costCountsMap = new HashMap<Integer, Integer>();
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

        Point first1Point;
        while( (first1Point = getFirstNPoint(1)) != null  ) {
            cost++;
            bfs(first1Point);
            while( !queue.isEmpty() ) {
                bfs(queue.poll());
            }
            
        }
        
        System.out.println(cost-1);
        
        Set<Integer> costCountSet = new TreeSet<>();

        for ( Integer e : costCountsMap.values() ) {
            costCountSet.add(e);
        }

        /* Selection Sort ASC*/
        for ( int e : costCountSet ) {
            System.out.println(e);
        }

        br.close();

    }

    public static Point getFirstNPoint ( int n ) {
        
        for ( int row = 0; row < N; row++ )
            for ( int col = 0; col < M; col++ )
                if ( graph[row][col] == n) return new Point(row, col);
        return null;
    }

    public static void bfs( Point p ) {
        
        for ( int i = 0; i < deltaCol.length; i++ ) {
            int nextRow = p.row + deltaRow[i];
            int nextCol = p.col + deltaCol[i];
            if ( nextRow > -1 && nextRow < N
              && nextCol > -1 && nextCol < M ) {
                if ( graph[nextRow][nextCol] == 1 ) {
                    graph[nextRow][nextCol] = cost;
                    costCountsMap.put( cost
                                     , costCountsMap.containsKey(cost) 
                                     ? (costCountsMap.get(cost) + 1)
                                     : 1 );
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
