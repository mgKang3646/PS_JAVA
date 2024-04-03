package org.example.backtracking;

import java.io.*;
import java.util.*;


public class Bt12 {

    public static int[] dx = { 1,-1,0,0};
    public static int[] dy = { 0,0,1,-1};
    public static int r,c,k,ans;
    public static char[][] matrix;
    public static int[] desPos;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        matrix = new char[r][c];
        visited = new boolean[r][c];

        for(int i=0;i<r;i++){
            matrix[i] = br.readLine().toCharArray();
        }

        desPos = new int[2];
        desPos[0] = 0;
        desPos[1] = c-1;

        visited[r-1][0] = true;
        dfs(0,r-1,1);

        System.out.println(ans);


    }

    public static void dfs(int currX, int currY, int length){

        if(currX == desPos[1] && currY == desPos[0]){
            if(length == k) ans++;
            return;
        }

        for(int i=0;i<4;i++){
            int nextX = currX + dx[i];
            int nextY = currY + dy[i];

            if(isValidate(nextX, nextY)&&!visited[nextY][nextX]&&matrix[nextY][nextX]!='T'){
                visited[nextY][nextX] = true;
                dfs(nextX,nextY,length+1);
                visited[nextY][nextX] = false;
            }
        }

    }

    public static boolean isValidate(int x, int y){
        return (x>=0&&y>=0&&x<c&&y<r)? true : false;
    }
}