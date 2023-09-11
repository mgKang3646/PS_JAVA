package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ1520 내리막 길 ( DP + DFS )
public class Dp14 {
    static int m,n,ans;
    static int[][] graph,dp;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        graph = new int[m][n];
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        dfs(0,0);
        System.out.println(dp[0][0]);


    }

    public static int dfs(int x, int y){

        if(x==n-1&&y==m-1) return 1;
        if(dp[y][x]!=-1) return dp[y][x];

        dp[y][x] = 0;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isValidate(nx,ny)){
                if(graph[y][x] > graph[ny][nx] ) {
                    dp[y][x] += dfs(nx,ny);
                }
            }
        }

        return dp[y][x];

    }
    public static boolean isValidate(int x, int y){
        if(x>=0&&y>=0&&x<n&&y<m) return true;
        else return false;
    }

}
