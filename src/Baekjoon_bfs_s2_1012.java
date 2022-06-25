import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.LinkedList;

class Baekjoon_bfs_s2_1012 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int ROW;
    static int COL;
    static int NAPA_CABBAGE_COUNT;
    static int[][] graph;
    static List<Dot> queue = new LinkedList<>();
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {

        StringBuilder result = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for ( int i = 0; i < N; i++ ) {

            String[] splitLine = br.readLine().split(" ");
            ROW = Integer.parseInt(splitLine[0]);
            COL = Integer.parseInt(splitLine[1]);
            graph = new int[ROW][COL];
            NAPA_CABBAGE_COUNT = Integer.parseInt(splitLine[2]);

            for ( int j = 0; j < NAPA_CABBAGE_COUNT; j++ ) {
                String[] NC_POSITION = br.readLine().split(" ");
                int row = Integer.parseInt(NC_POSITION[0]);
                int col = Integer.parseInt(NC_POSITION[1]);
                graph[row][col] = 1;
            } // for : j
            
            
            Dot d;
            int count = 1;
            // graph에 1이 존재할 때
            while ( (d = getFirst1Dot()) != null ) {
                count++;
                // 첫 1에서 bfs 시작
                bfs(d, count);
                
                while ( queue.size() > 0 ) {
                    Dot dot = queue.get(0);
                    queue.remove(0);
                    bfs(dot, count);
                }
            }   
            result.append( (count-1) + "\n" );
        } // for : i
        result.deleteCharAt(result.length()-1);
        System.out.print(result);        
    } // main

    static void bfs( Dot d, int count ) {
        graph[d.row][d.col] = count;
            for ( int i = 0; i < 4; i++ ) {
                int nextRow = d.row + dRow[i];
                int nextCol = d.col + dCol[i];
                if ( nextRow > -1
                  && nextRow < ROW
                  && nextCol > -1
                  && nextCol < COL
                  && graph[nextRow][nextCol] == 1 
                   ) {
                    queue.add(new Dot(nextRow, nextCol));
                  }
            } // for
    }

    static Dot getFirst1Dot() {
        for ( int row = 0; row < ROW; row++ )
            for ( int col = 0; col < COL; col++ ) 
                if ( graph[row][col] == 1 )
                    return new Dot(row, col);
        return null;
    }
    
   static class Dot {
        public int row;
        public int col;
        public Dot(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
} // class
