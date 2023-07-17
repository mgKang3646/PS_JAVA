package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Math.*;

//BOJ9465 스티커
public class Dp6 {

    public static void main(String[] args) throws IOException {
        solution();
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[n+1][2];
            int[][] dp = new int[n+1][3];

            for(int i=0; i<2;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=1;j<n+1;j++){
                    stickers[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=1;i<n+1;i++){
                dp[i][0] = max(max(dp[i-1][0],dp[i-1][1]),dp[i-1][2]);
                dp[i][1] = max(dp[i-1][0],dp[i-1][2])+stickers[i][0];
                dp[i][2] = max(dp[i-1][0],dp[i-1][1])+stickers[i][1];
            }

            System.out.println(max(max(dp[n][0],dp[n][1]),dp[n][2]));

        }
    }
}
