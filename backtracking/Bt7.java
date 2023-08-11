package org.example.backtracking;


import java.util.Scanner;


//BOJ9663 N-Queen
public class Bt7 {

    static int n;
    static int ans;
    static int[] queens;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        queens = new int[n];

        dfs(0); // DFS 탐색

        System.out.println(ans);

    }

    public static void dfs(int row){ // 행을 기준으로 탐색
        if(row == n){
            ans+=1;
            return;
        }

        for(int col=0;col<n;col++){ // 열을 기준으로 탐색
            if(isValid(row,col)){
                queens[row] = col;
                dfs(row+1);
            }
        }
    }

    public static boolean isValid(int row, int col){
        for(int r =0;r<row;r++){
            if(queens[r] == col) return false; // 열에 겹치는 경우
            if(row-r == Math.abs(queens[r]-col)) return false; // 대각선에 겹치는 경우
        }
        return true;
    }
}

