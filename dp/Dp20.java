package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//BOJ15989 1,2,3 더하기4
public class Dp20 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[n+1][4];

            for(int i=1;i<=n;i++){
                if(i==1) dp[1][1] = 1;
                if(i==2) dp[2][2] = 1;
                if(i==3) dp[3][3] = 1;

                if(i>1) dp[i][1] = dp[i-1][1];
                if(i>2) dp[i][2] = dp[i-2][1] + dp[i-2][2];
                if(i>3) dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
            }

            System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);


        }
    }
}
