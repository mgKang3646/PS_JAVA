package org.example.dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

//BOJ11049 행렬곱셈순서
public class Dp17 {

    public static class Matrix{
        int row;
        int col;

        public Matrix(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Matrix[] matrix = new Matrix[n];
        int[][] dp = new int[n][n];

        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            matrix[i] = new Matrix(row,col);
        }

        for(int i=0;i<n-1;i++){
            dp[i][i+1] = matrix[i].row*matrix[i].col*matrix[i+1].col;
        }

        for(int gap=2;gap<n;gap++){
            for(int i=0;i+gap<n;i++){
                int j = i+gap;
                dp[i][j] = Integer.MAX_VALUE;

                for(int k=i;k<j;k++){
                    dp[i][j] = min(dp[i][j],dp[i][k] + dp[k+1][j] + (matrix[i].row*matrix[k].col*matrix[j].col));
                }
            }
        }

        System.out.println(dp[0][n-1]);

    }
}
