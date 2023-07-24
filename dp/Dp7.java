package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.*;

//BOJ2156 포도주 시식
public class Dp7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1;i<=n;i++){
            wines[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = wines[1];

        if(n>=2) dp[2] = wines[1] + wines[2];

        for(int i=3;i<=n;i++){
            //OOX
            int case1 = dp[i-1];
            //OXO
            int case2 = dp[i-2] + wines[i];
            //XOO
            int case3 = dp[i-3] + wines[i-1] + wines[i];

            dp[i] = max(case1,max(case2,case3));
        }

        System.out.println(dp[n]);

    }
    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n+1];
        int[][] dp = new int[10001][4];

        for(int i=1;i<=n;i++){
            wines[i] = Integer.parseInt(br.readLine());
        }

        dp[1][0] = 0; //XX
        dp[1][1] = 0; //OX
        dp[1][2] = wines[1]; // OO
        dp[1][3] = wines[1]; // XO

        dp[2][0] = 0; //XX
        dp[2][1] = wines[1]; //OX
        dp[2][2] = wines[1] + wines[2]; // OO
        dp[2][3] = wines[2]; // XO

        for(int i =3;i<=n;i++){
            dp[i][0] = max(max(dp[i-2][0],dp[i-2][2]),max(dp[i-2][2],dp[i-2][3]));
            dp[i][1] = max(max(dp[i-2][0],dp[i-2][1]),dp[i-2][3]) + wines[i-1];
            dp[i][2] = max(dp[i-2][0],dp[i-2][1]) + wines[i-1] + wines[i];
            dp[i][3] = max(max(dp[i-2][0],dp[i-2][2]),max(dp[i-2][2],dp[i-2][3])) + wines[i];
        }

        int ans = max(max(dp[n][0],dp[n][1]),max(dp[n][2],dp[n][3]));
        System.out.println(ans);

    }

}
