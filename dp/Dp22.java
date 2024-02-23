package org.example.dp;

import java.io.*;
import java.util.*;

//BOJ12865 평범한 배낭
public class Dp22 {

    public static class Item{

        int weight;
        int value;

        public Item(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Item[] items = new Item[n+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            items[i] = new Item(weight,value);
        }

        int[][] dp = new int[n+1][k+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                dp[i][j] = dp[i-1][j];

                if(j-items[i].weight < 0) continue;
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j-items[i].weight] + items[i].value );
            }
        }

        System.out.println(dp[n][k]);

    }
}