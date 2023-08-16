package org.example.dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ1495 기타리스트
public class Dp11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] volumes = new int[n+1];
        boolean[][] dp = new boolean[n+1][m+1]; // DP 테이블

        dp[0][s] = true; // 시작 볼륨

        // 매곡 볼륨 초기화
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<n+1;i++){
            volumes[i] = Integer.parseInt(st.nextToken());
        }

        // DP 시작
        for(int i=1;i<n+1;i++){
            int volume = volumes[i];
            for(int j=0;j<=m;j++){ // 0 - 최대 1000 볼륨 사이에 변경 가능한 경우에 true 초기화하기
                if(dp[i-1][j]){
                    if(j+volume <= m) dp[i][j+volume] = true;
                    if(j-volume >= 0) dp[i][j-volume] = true;
                }
            }
        }

        // n번째 곡에서 변경 가능한 볼륨 중 최대값 출력하기
        int ans = -1;
        for(int i=m;i>-1;i--){
            if(dp[n][i]){
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }
}
