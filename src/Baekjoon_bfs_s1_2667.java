import java.util.*;
import java.io.*;
public class Baekjoon_bfs_s1_2667 {

    static int N;
    static int[][] matrix;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    static List<Dot> first1DotList = new LinkedList<>();
    static List<Dot> queue = new LinkedList<>();
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        for ( int row = 0; row < N; row++ ) {
            String[] splitLine = br.readLine().split("");
            for ( int col = 0; col < N; col++ ) {
                matrix[row][col] = Integer.parseInt(splitLine[col]);
                if ( matrix[row][col] == 1 )
                    first1DotList.add(new Dot(row, col));
            }
        }
        int value = 1;
        while( first1DotList.size() > 0 ) {
            Dot startDot = first1DotList.get(0);
            if( matrix[startDot.row][startDot.col] == 1) {
                value++;
                matrix[startDot.row][startDot.col] = value;
                queue.add(startDot);
                bfs(value);
            }
            first1DotList.remove(0);
        }

        
        List<Integer> countList = new ArrayList<>();
        for ( int i = 2; i <= value; i++ ) {
            int count = 0;
            for ( int row = 0; row < N; row++ )
                for ( int col = 0; col < N; col++ )
                    if ( matrix[row][col] == i )
                        count++;
            countList.add(count);
        }
        
        // for ( int[] line : matrix) {
        //     for ( int element : line) {
        //         System.out.print(element + " ");
        //     }
        //     System.out.println();
        // }
        StringBuilder result = new StringBuilder();
        result.append((value-1) + "\n");
        Collections.sort(countList);
        for (int count : countList )
            result.append(count + "\n");
        System.out.print(result.toString());
        
    }
    
    public static void bfs(int value) {
        while( queue.size() > 0 ) {

            Dot d = queue.get(0);
            queue.remove(0);
            
            for ( int i = 0; i < 4; i++ ) {
                int nextRow = d.row + dx[i];
                int nextCol = d.col + dy[i];
                if ( nextRow > -1 && nextRow < N
                  && nextCol > -1 && nextCol < N
                  && matrix[nextRow][nextCol] == 1
                   ) {
                    matrix[nextRow][nextCol] = value;
                    queue.add(new Dot(nextRow, nextCol));
                  }
            }
        }
            
    }
    public static class Dot {
        public int row;
        public int col;
        public Dot(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}