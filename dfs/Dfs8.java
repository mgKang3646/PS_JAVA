package org.example.dfs;

import java.io.*;
import java.util.*;

//BOJ1707 이분그래프
public class Dfs8 {

    private static final int R = 1;
    private static int n,m;
    private static int[] colors;
    private static List<Integer>[] graph;
    private static boolean isBipartite;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            colors = new int[n+1];
            graph = new List[n+1];
            isBipartite = true;

            for(int i=1;i<n+1;i++){
                graph[i] = new ArrayList<>();
            }

            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine());

                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());

                graph[node1].add(node2);
                graph[node2].add(node1);
            }

            for(int i=1;i<=n;i++){
                if(!isBipartite) break;
                if(colors[i] == 0) dfs(i,R);
            }

            if(isBipartite) System.out.println("YES");
            else System.out.println("NO");

        }
    }

    public static void dfs(int node, int color){
        colors[node] = color;

        for( int nextNode : graph[node] ){
            if(colors[nextNode] != 0){
                if(colors[nextNode] == colors[node] ) isBipartite = false;
            }
            else{
                colors[nextNode] = colors[node] * -1;
                dfs(nextNode,colors[nextNode]);
            }
        }
    }
}