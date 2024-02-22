package org.example.bfs;

import java.io.*;
import java.util.*;


//BOJ14940 쉬운 최단거리
public class Bfs6 {

    static int n ;
    static int ans = Integer.MAX_VALUE;
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,new boolean[n],new boolean[n]);

        System.out.println(ans);


    }

    public static void dfs(int idx, boolean[] teamA, boolean[] teamB){
        if(idx == n){

            int sumA = 0;
            int sumB = 0;

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(teamA[i] && teamA[j]) sumA += matrix[i][j];
                    else if(teamB[i] && teamB[j]) sumB += matrix[i][j];
                }
            }

            ans = Math.min(ans,Math.abs(sumA-sumB));
            return;

        }

        // teamA에 속하는 경우
        teamA[idx] = true;
        dfs(idx+1,teamA,teamB);
        teamA[idx] = false;

        // teamB에 속하는 경우
        teamB[idx] = true;
        dfs(idx+1,teamA,teamB);
        teamB[idx] = false;


    }
}