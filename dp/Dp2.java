package org.example.dp;


import java.io.*;

//BOJ15988 1,2,3 더하기2
public class Dp2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        long mod = 1000000009;
        int max = 1000000;
        long[] dp = new long[max+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4;i<=max;i++){
            dp[i]= (dp[i-1]+dp[i-2]+dp[i-3])%mod;
            //dp[i-1]+dp[i-2]+dp[i-3] 덧셈시 int 범위를 넘어서서 데이터에 문제가 생긴다.
            //문제가 생긴후 %mod를 하면 의미가 없다.
            //처음부터 데이터타입을 long으로 해주면 해결된다.
        }

        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            int t = Integer.parseInt(br.readLine());
            sb.append(dp[t]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
