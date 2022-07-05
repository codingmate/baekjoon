import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Baekjoon_sort_s5_11651 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Dot> dotList = new ArrayList<>();
        for ( int i = 0; i < N; i++ ) {
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            dotList.add(new Dot(x, y));
        }

        Collections.sort(dotList, (Dot d1, Dot d2) -> {
            if ( d1.y == d2.y && d1.x == d2.x ) return 0;
            if ( d1.y > d2.y ) return 1;
            if ( d1.y == d2.y && d1.x > d2.x) return 1;
            else return -1;
        });
            
        StringBuilder result = new StringBuilder();
        for ( int i = 0; i < N; i++ ) {
            Dot d = dotList.get(i);
            result.append(d.x + " " + d.y + "\n");
        }
            
        if (result.length() > 0)
            result.deleteCharAt(result.lastIndexOf("\n"));
        System.out.print(result.toString());
        
        br.close();
    } // main

    public static class Dot {
        public int x;
        public int y;
        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
