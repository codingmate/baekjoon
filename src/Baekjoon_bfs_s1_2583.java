import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Baekjoon_bfs_s1_2583 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int K;
    static int X;
    static int Y;
    static int[][] graph;
    static List<Dot> queue = new LinkedList<>();
    static List<Integer> distances = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {

        String[] KXY = br.readLine().split(" ");
        Y = Integer.parseInt(KXY[0]);
        X = Integer.parseInt(KXY[1]);
        K = Integer.parseInt(KXY[2]);

        int[][] graph = new int[X][Y];
        
        for ( int i = 0; i < K; i++ ) {
            String[] xyxy = br.readLine().split(" ");
            int x1 = Integer.parseInt(xyxy[0]);
            int y1 = Integer.parseInt(xyxy[1]);
            int x2 = Integer.parseInt(xyxy[2])-1;
            int y2 = Integer.parseInt(xyxy[3])-1;
            for ( int x = x1; x <= x2; x++ ) {
               for ( int y = y1; y <= y2; y++ ) {
                   graph[x][y] = -1;
               }
            }
        }
        
        for ( int y = Y-1; y > -1; y-- ) {
            for ( int x = 0; x < X; x++ ) {
                if ( graph[x][y] == 0 ) {
                    graph[x][y] = 1;
                    queue.add(new Dot(x, y));
                    bfs();
                } else continue;
                for ( int r = Y-1; r > -1; r-- ) {
                    for ( int c = 0; c < X; c++ ) {
                        System.out.print( graph[c][r] + " " );
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }
        
        
    }

    static void bfs() {
        
        while( queue.size() > 0 ) {
            Dot d = queue.get(0);
            queue.remove(0);
            
            for ( int i = 0; i < 3; i++ ) {
                int nextX = d.x + dx[i];
                int nextY = d.x + dy[i];
                if ( nextX > -1 && nextX < X
                  && nextY > -1 && nextY < Y
                  && graph[nextX][nextY] == 0 ) {
                    graph[nextX][nextY] = graph[d.x][d.y] + 1;
                    queue.add(new Dot(nextX, nextY));
                }
            }
        }
    }
    
    static class Dot {
        public int x;
        public int y;
        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
} // class
