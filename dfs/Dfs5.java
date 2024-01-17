package org.example.dfs;

import java.io.*;
import java.util.*;

//BOJ2468 안전 영역
public class Dfs5 {
        public static int n;
        public static int[][] matrix;
        public static boolean[][] visited;

        public static int[] dx = {1,-1,0,0};
        public static int[] dy = {0,0,1,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];

        int maxH = 0;
        int minH = 100;

        StringTokenizer st ;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int h = Integer.parseInt(st.nextToken());
                matrix[i][j] = h;

                maxH = Math.max(maxH,h);
                minH = Math.min(minH,h);
            }
        }

        int ans = 0;
        for(int i=minH-1;i<=maxH;i++){
            visited = new boolean[n][n];
            ans = Math.max(ans,checkMatrix(i));
        }

        System.out.println(ans);
    }

    public static int checkMatrix(int h){
        int count = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]&&!isUnderWater(h,matrix[i][j])){
                    dfs(j,i,h);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int x, int y, int h){
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isValid(nx,ny)){
                if(!visited[ny][nx]&&!isUnderWater(h,matrix[ny][nx])){
                    visited[ny][nx] = true;
                    dfs(nx,ny,h);
                }
            }
        }
    }

    public static boolean isValid(int x, int y){
        return ( x < n && y < n && x >=0  && y >= 0 )? true : false;
    }

    public static boolean isUnderWater(int h, int localH){
        return ( h - localH >= 0)? true : false;
    }
}
