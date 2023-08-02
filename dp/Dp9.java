package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

//BOJ11055 가장 큰 증가하는 부분 수열
public class Dp9 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = arr[1];
        int ans = dp[1];
        for(int i=2;i<=n;i++) {
            int maxValue = 0;
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {
                    maxValue = max(maxValue, dp[j]);
                }
            }
            dp[i] = maxValue + arr[i];
            ans = max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
