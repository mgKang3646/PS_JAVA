package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ2225 합분해
public class Dp1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int MOD = 1000000000;

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[k+1][n+1];

        // n이 0일때
        for(int i=1;i<k+1;i++){
            dp[i][0] = 1;
        }
        // k가 1일때
        for(int i=0;i<n+1;i++){
            dp[1][i] = 1;
        }
        // DP풀이
        for(int i=1;i<k+1;i++){
            for(int j=1;j<n+1;j++){
                for(int z=0;z<=j;z++){ // k-1개일때 0~n까지 합
                    dp[i][j] += dp[i-1][z];
                    dp[i][j] %= MOD;
                }
            }
        }
        System.out.println(dp[k][n]);
    }
}
