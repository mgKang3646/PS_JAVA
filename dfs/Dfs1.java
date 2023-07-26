package org.example.dfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ16929 Two Dots
public class Dfs1 {

    static int n;
    static int m;

    static int startX;
    static int startY;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            board[i] = br.readLine().toCharArray();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                startX = j;
                startY = i;
                visited[i][j] = true;
                if(dfs(j,i,1)){
                    System.out.println("Yes");
                    return;
                }
                visited[i][j] = false;
            }
        }

        System.out.println("No");

    }

    public static boolean dfs(int x,int y,int depth){
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isValidate(nx,ny)){
                if(startX == nx && startY == ny && depth >= 4 ) return true;
                if(!visited[ny][nx] && board[ny][nx] == board[startX][startY]){
                    visited[ny][nx] = true;
                    if(dfs(nx,ny,depth+1)) {
                        visited[ny][nx] = false;
                        return true;
                    }
                    else visited[ny][nx] = false;
                }
            }
        }
        return false;
    }

    public static boolean isValidate(int x,int y){
        return ( x >=0 && y>=0 && x < m & y < n ) ? true : false;
    }
}
