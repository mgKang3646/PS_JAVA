package org.example.dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

//BOJ15486 퇴사2
public class Dp13 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+2];
        int maxCost = 0;


        StringTokenizer st;
        for(int i=1;i<=n;i++){

            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            //현재 날짜 DP 갱신
            //전날 비용이 더 크면 그대로 가져온다.
            dp[i] = max(dp[i],dp[i-1]);

            //다음 날짜 DP 갱신
            int next = i+t;
            if( next > n+1 ) continue;
            dp[next] = max(dp[next],dp[i]+p);
            maxCost = max(maxCost,dp[next]);

        }

        System.out.println(maxCost);

    }
}
