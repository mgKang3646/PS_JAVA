package org.example.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ1987 알파벳
public class Bt8 {
    static int[] dx = { 1,-1,0,0 };
    static int[] dy = { 0,0,1,-1 };

    static int row;
    static int col;

    static char[][] board;
    static boolean[] visited;

    static int ans;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        board = new char[row][col];
        visited = new boolean['Z'-'A'+1];

        for(int i=0;i<row;i++){
            board[i] = br.readLine().toCharArray();
        }

        visited[board[0][0]-'A'] = true;
        dfs(0,0,1);

        System.out.println(ans);

    }

    public static void dfs(int x, int y,int depth){

        ans = Math.max(ans,depth);

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isValid(nx,ny)){
                char nextChar = board[ny][nx];
                if(!visited[nextChar-'A']){
                    visited[nextChar-'A'] = true;
                    dfs(nx,ny,depth+1);
                    visited[nextChar-'A'] = false;
                }

            }
        }
    }

    public static boolean isValid(int x, int y){
        if(x>=0&&y>=0&&x<col&&y<row) return true;
        else return false;
    }



}
