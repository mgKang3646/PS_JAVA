package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//BOJ1932 정수 삼각형
public class Dp8 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] triangle = new List[n+1];
        List<Integer>[] dp = new List[n+1];

        StringTokenizer st;

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            triangle[i] = new ArrayList<>();
            dp[i] = new ArrayList<>();
            while(st.hasMoreTokens()){
                triangle[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        dp[1].add(triangle[1].get(0));

        for(int i=2;i<=n;i++){
            for(int j=0; j<triangle[i].size();j++){
                if(j==0) dp[i].add( (dp[i-1].get(j) + triangle[i].get(j)) );
                else if(j==triangle[i].size()-1) dp[i].add( dp[i-1].get(j-1) + triangle[i].get(j));
                else{
                    int maxValue = Math.max(dp[i-1].get(j),dp[i-1].get(j-1));
                    dp[i].add( triangle[i].get(j) + maxValue);
                }
            }
        }
        System.out.println(Collections.max(dp[n]));
    }

}

