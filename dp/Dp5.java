package org.example.dp;

import java.util.Scanner;

//BOJ1105 오르막 수
public class Dp5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[][] dp = new long[n+1][10];

        for(int i =0;i<10;i++){
            dp[1][i] = 1;
        }

        for(int i =2; i<n+1;i++){
            for(int j =0;j<10;j++){
                for(int z=0; z<=j;z++){
                    dp[i][j] = (dp[i][j] + dp[i-1][z])%10007;
                }
            }
        }

        long ans = 0;
        for (long value : dp[n]) {
            ans = ( ans + value )%10007;
        }

        System.out.println(ans);

    }

}
