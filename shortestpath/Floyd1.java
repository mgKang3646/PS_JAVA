package org.example.shortestpath;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

//BOJ1238 파티
public class Floyd1 {

    static int[][] graph;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j) graph[i][j] = 0;
                else graph[i][j] = 1000000000;
            }
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph[start][end] = value;
        }

        for(int mid=1;mid<=n;mid++){
            for(int start=1;start<=n;start++){
                for(int end=1;end<=n; end++){
                    int curr = graph[start][end];
                    int value = graph[start][mid] + graph[mid][end];
                    graph[start][end] = min(curr,value);
                }
            }
        }

        int ans = 0;
        for(int i=1;i<=n;i++){
            ans = max(ans, graph[i][x] + graph[x][i] );
        }

        System.out.println(ans);
    }
}
