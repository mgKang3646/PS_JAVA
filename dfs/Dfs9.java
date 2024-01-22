package org.example.dfs;

import java.io.*;
import java.util.*;

//BOJ9466 텀프로젝트 ( 방향그래프에서 싸이클 찾기 )
public class Dfs9 {

    public static int n,ans;
    public static int[] arr;
    public static boolean[] isDone,visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){

            ans = 0;
            n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            isDone = new boolean[n+1];
            visited = new boolean[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=1;i<=n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1;i<=n;i++){
                if(!isDone[i]) {
                    dfs(i);
                }

            }
            System.out.println(n-ans);

        }

    }

    public static void dfs( int curr ){

        if(visited[curr]){
            isDone[curr] = true;
            ans++;
        }

        else {
            visited[curr] = true;
        }

        int next = arr[curr];
        if(!isDone[next]){
            dfs(next);
        }

        visited[curr] = false;
        isDone[curr] = true;
    }
}
