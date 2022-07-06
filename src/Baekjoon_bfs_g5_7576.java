package src;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
 
class Baekjoon_bfs_g5_7576 {

   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int[][] graph;
    static List<Dot> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[1]);
        M = Integer.parseInt(NM[0]);

        graph = new int[N][M];
        for ( int i = 0 ; i < N; i++ ) {
            String[] row = br.readLine().split(" ");
            for ( int j = 0 ; j < M; j++ ) {
                graph[i][j] = Integer.parseInt(row[j]);
                if( graph[i][j] == 1 )
                    queue.add(new Dot(i, j));
            }
                
        }

        
        
        while( queue.size() > 0 ) {
            // System.out.println("\n\n");
            // for ( int[] row : graph ) {
            //     for ( int col : row ) {
            //         System.out.print(col + " ");
            //     }
            //     System.out.println();
            // }
            
            Dot d = queue.get(0);
            queue.remove(0);
            bfs(d);
            
        }

        
        if ( isExist0() ) {
            System.out.print(-1);
        } else {
            System.out.print(getGraphMax() - 1);
        }


    } // main

    static void bfs( Dot d ) {
        for ( int i = 0; i < 4; i++ ) {
            int nextRow = d.row + dx[i];
            int nextCol = d.col + dy[i];
            if ( nextRow > -1
              && nextRow < N
              && nextCol > -1
              && nextCol < M
              && ( graph[nextRow][nextCol] == 0
                || ( graph[nextRow][nextCol] != -1 
                  && graph[nextRow][nextCol] > graph[d.row][d.col] + 1)
                 )
               ) {
                graph[nextRow][nextCol] = graph[d.row][d.col] + 1;
                queue.add(new Dot(nextRow, nextCol));
              }
        }

    }

    static boolean isExist0 () {
        
        for ( int[] row : graph ) {
            for ( int col : row ) {
                if ( col == 0 )
                    return true;
            }
        }
        return false;
    }

    static int getGraphMax () {
        int max = Integer.MIN_VALUE;
        for ( int[] row : graph ) {
            for ( int col : row ) {
                if ( col > max )
                    max = col;
            }
        }
        return max;
    }

    static class Dot {
        public int row;
        public int col;
        public Dot ( int row, int col ) {
            this.row = row;
            this.col = col;
        }
    }
    
} // class
