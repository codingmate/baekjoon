import java.io.*;
import java.util.*;

public class Baekjoon_bfs_s2_17086 {
    
    static List<Dot> q = new LinkedList<>();
    static int[][] graph;
    static int[][] dist;
    static int[] dRow = { 0, 0, -1, 1, -1, -1, 1, 1 };
    static int[] dCol = { 1, -1, 0, 0, 1,  -1, 1, -1};
    static int ROW;
    static int COL;
    public static void main(String[] args ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] MN = br.readLine().split(" ");
        ROW = Integer.parseInt(MN[0]);
        COL = Integer.parseInt(MN[1]);

        graph = new int[ROW][COL];
        dist = new int[ROW][COL];
        for ( int row = 0; row < ROW; row++ ) {
            String[] numbers = br.readLine().split(" ");
            for ( int col = 0; col < COL; col++ ) {
                int num = Integer.parseInt(numbers[col]);
                if ( num == 1 ) {
                    graph[row][col] = num;
                    q.add(new Dot(row, col));
                }
            } // for : col
        } // for : row
        // for ( int[] row : dist ) {
        //     System.out.println();
        //     for ( int col : row) {
        //         System.out.print(col + " ");
        //     }
        // }
        bfs();
        int max = 0;
        for ( int[] cols : dist )
            for ( int col : cols)
                if ( col > max )
                    max = col;
        // System.out.println();
        // for ( int[] row : dist ) {
        //     System.out.println();
        //     for ( int col : row) {
        //         System.out.print(col + " ");
        //     }
        // }
        System.out.print(max);
        
    } // main

    public static void bfs( ) {
                    
        while( q.size() > 0 ) {
            Dot d = q.get(0);
            q.remove(0);
            for ( int i = 0; i < 8; i++ ) {
                int nextRow = d.row + dRow[i];
                int nextCol = d.col + dCol[i];
                if ( nextRow > -1 && nextRow < ROW 
                  && nextCol > -1 && nextCol < COL
                  && graph[nextRow][nextCol] == 0
                   ) {
                     int prev = dist[d.row][d.col];
                     int next = dist[nextRow][nextCol];
                     
                     if( next == 0 ) {
                        dist[nextRow][nextCol] = prev + 1;
                        q.add(new Dot(nextRow, nextCol));
                     }
                   }
            } // for : i
        } // while
    }

    static class Dot {
        int row;
        int col;
        public Dot(int row, int col ) {
            this.row = row;
            this.col = col;
        }
    }
} // class
