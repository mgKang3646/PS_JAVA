package org.example.dp;

import java.io.*;

//BOJ10844 쉬운 계단수
public class Dp24 {

    public static final int PIVOT = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n+1][10];

        for(int i=1;i<=9;i++){
            dp[1][i] = 1;
        }

        for(int i=2;i<=n;i++){
            for(int j=0;j<=9;j++){
                if(j-1 >= 0) dp[i][j-1] = (dp[i][j-1] + dp[i-1][j])%PIVOT;
                if(j+1 <= 9) dp[i][j+1] = (dp[i][j+1] + dp[i-1][j])%PIVOT;
            }
        }

        long ans = 0;

        for(int i=0;i<=9;i++){
            ans += dp[n][i];
        }

        System.out.println(ans%PIVOT);


    }
}