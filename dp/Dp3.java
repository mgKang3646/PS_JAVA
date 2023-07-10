package org.example.dp;


import java.io.*;
import java.util.StringTokenizer;
import static java.lang.Math.min;

//BOJ1149 RGB거리
public class Dp3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int dp[][];

        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1][3];

        for(int i =1;i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dp[i][0] = min(dp[i-1][1],dp[i-1][2]) + r;
            dp[i][1] = min(dp[i-1][0],dp[i-1][2]) + g;
            dp[i][2] = min(dp[i-1][1],dp[i-1][0]) + b;

        }

        int ans = dp[n][0];
        for(int i =0;i<3;i++){ ans = min(ans,dp[n][i]); }

        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
