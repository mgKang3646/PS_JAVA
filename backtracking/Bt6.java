package org.example.backtracking;


import java.util.Scanner;

//BOJ9663 N-Queen ( 메모리 초과 버전 )
public class Bt6 {

    static int n;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(0,new boolean[n][n]);

        System.out.println(ans);
    }

    public static void dfs(int depth, boolean[][] board){
        if(depth == n) {
            ans += 1;
            return;
        }

        for(int i=0;i<n;i++){
            if(board[depth][i]) continue;

            boolean[][] tmpBoard = copy(board);
            updateChessBoard(i,depth,tmpBoard);
            dfs(depth+1,tmpBoard);
        }
    }

    public static boolean[][] copy(boolean[][] original){
        boolean[][] copy = new boolean[n][n];
        for(int i=0;i<n;i++){
            copy[i] = original[i].clone();
        }
        return copy;
    }

    public static void updateChessBoard(int x, int y, boolean[][] board ){

        int[] dx = { 0, 1, 0, -1, 1, -1, 1, -1 };
        int[] dy = { 1, 0, -1, 0,  1, -1, -1, 1 };

        for(int i=0;i<8;i++){
            update(x,y,dx[i],dy[i],board);
        }
    }

    public static void update(int x, int y, int dx, int dy,boolean[][] board){

        while(x<n&&y<n&&x>=0&&y>=0){
            board[y][x] = true;
            x += dx;
            y += dy;
        }

    }
}
