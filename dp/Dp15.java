package org.example.dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ11066 파일 합치기
public class Dp15 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- >0){

            int ans = 0;
            int n = Integer.parseInt(br.readLine());
            int[] sum = new int[n+1];
            int[][] dp = new int[n+1][n+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1;i<=n;i++){
                int file = Integer.parseInt(st.nextToken());
                sum[i] = sum[i-1] + file; // 누적합
            }

            // DP테이블 만들기
            for(int i=1;i<=n;i++){ // 1부터 n까지 DP테이블 만들기
                for(int from=1; from+i<=n; from++ ){ // from-to 묶음별 최댓값 구하기
                    int to = from+i;
                    dp[from][to] = Integer.MAX_VALUE;
                    for(int mid=from;mid<to;mid++){ // from-mid , mid+1-to 두개 묶음으로 최댓값 구하기
                        dp[from][to] = Math.min(dp[from][to],dp[from][mid] + dp[mid+1][to] + sum[to] - sum[from-1]);
                    }
                }
            }

            System.out.println(dp[1][n]);

        }
    }
}
