package org.example.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

//BOJ11404 플로이드
public class Floyd2 {

    static int n,m;
    static final int INF = Integer.MAX_VALUE;
    static int[][] floyd;


    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();

    }

    private static void solution() {
        for(int mid=1;mid<=n;mid++){
            for(int start=1;start<=n;start++){
                for(int end=1;end<=n;end++){
                    if(floyd[start][mid] == INF || floyd[mid][end] == INF) continue;
                    int cost = floyd[start][mid] + floyd[mid][end];
                    floyd[start][end] = min(floyd[start][end],cost);
                }
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        floyd = new int[n+1][n+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==j) floyd[i][j] = 0;
                else floyd[i][j] = INF;
            }
        }

        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            floyd[start][des] = min(floyd[start][des],cost);

        }
    }

    private static void print() {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(floyd[i][j] != INF) System.out.print(floyd[i][j]+" ");
                else System.out.print(0 + " ");
            }
            System.out.println();
        }
    }
}
