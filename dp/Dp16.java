package org.example.dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.max;

//BOJ2579 계단 오르기
public class Dp16 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] stairs = new int[n];
        int[][] dp = new int[n][2]; // 0 : 1칸으로 올라온 경우 , 1: 2칸으로 올라온 경우

        for(int i =0; i<n;i++){
            int cost = Integer.parseInt(br.readLine());
            stairs[i] = cost;
        }

        dp[0][0] = stairs[0];

        if(n>1) {
            dp[1][0] = dp[0][0] + stairs[1];
            dp[1][1] = stairs[1];
        }

        for(int i=2;i<n;i++){
            dp[i][0] = dp[i-1][1] + stairs[i];
            dp[i][1] = max(dp[i-2][0],dp[i-2][1]) + stairs[i];
        }

        System.out.println(max(dp[n-1][0],dp[n-1][1]));

    }
}
