package org.example.dfs;

import java.util.*;
import java.io.*;

//BOJ2210 숫자판 점프
public class Dfs4 {

    private static HashSet<String> hashSet = new HashSet();
    private static int[][] matrix = new int[5][5];
    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                dfs(j,i,matrix[i][j]+"");
            }
        }

        System.out.println(hashSet.size());

    }

    private static void dfs(int x, int y, String str){

        if(str.length()>=6){
            hashSet.add(str);
            return;
        }

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isValid(nx,ny)){
                dfs(nx,ny,str + matrix[ny][nx]);
            }
        }
    }

    private static boolean isValid(int x, int y){
        return ( x < 5 && y < 5 && x >= 0 && y >= 0 )? true : false;
    }
}
