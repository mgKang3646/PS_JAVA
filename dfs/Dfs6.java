package org.example.dfs;

import java.io.*;

//BOJ10026 적록색약
public class Dfs6 {

    public static int n ;
    public static char[][] matrix;
    public static boolean[][] visited;

    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        matrix = new char[n][n];

        for(int i=0;i<n;i++){
            matrix[i] = br.readLine().toCharArray();
        }

        System.out.println(getDfsCount(false) + " " + getDfsCount(true));
    }

    public static int getDfsCount(boolean isBlind){
        visited = new boolean[n][n];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    dfs(j,i,matrix[i][j],isBlind);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int x, int y, char color,boolean isBlind){
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isValidPos(nx,ny)){
                if(isValidCondition(nx,ny,color,isBlind)){
                    visited[ny][nx] = true;
                    dfs(nx,ny,matrix[ny][nx],isBlind);
                }
            }
        }
    }

    public static boolean isValidPos(int x, int y){
        return ( x<n && y<n && x>=0 && y>=0 )? true : false;
    }

    public static boolean isValidCondition(int x, int y, char color, boolean isBlind){
        if(isBlind&&(color=='G'||color=='R')) return (!visited[y][x] && (matrix[y][x]=='G'|| matrix[y][x]=='R'));
        else return (!visited[y][x] && matrix[y][x] == color);

    }


}
