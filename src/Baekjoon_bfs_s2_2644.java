import java.io.*;
import java.util.*;

public class Baekjoon_bfs_s2_2644 {
    
    static List<Integer> q = new LinkedList<>();
    static int[][] graph;
    static int[] dist;

    static int M;
    static int N;
    
    public static void main(String[] args ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        String[] SE = br.readLine().split(" ");
        int start = Integer.parseInt(SE[0]);
        int end = Integer.parseInt(SE[1]);
        N = Integer.parseInt(br.readLine());
        graph = new int[M+1][M+1];
        dist = new int[M+1];

        
        for ( int i = 0; i < N; i++ ) {
            String[] node = br.readLine().split(" ");
            int s = Integer.parseInt(node[0]);
            int e = Integer.parseInt(node[1]);
            graph[s][e] = 1;
        }

        start = start > end ? end : start;
        q.add(start);
        dist[start] = -1;
        bfs();
        System.out.print(dist[start > end ? start : end]);
        
    } // main

    public static void bfs( ) {
                    
        while( q.size() > 0 ) {
            int start = q.get(0);
            q.remove(0);
            int distance = dist[start];
            System.out.println("start : " + start);
            for ( int i = 1; i <= M; i++ ) {
                if ( ( graph[start][i] == 1 )
                   && dist[i] > -1 ) {
                    System.out.println(" i : " + i);
                    dist[i] = distance + 1;
                    q.add(i);
                }
            }
        } // while
    }

} // class
