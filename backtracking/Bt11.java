package org.example.backtracking;

import java.io.*;
import java.util.*;


public class Bt11 {

    public static int n;
    public static int[] input;
    public static int[] arr;
    public static boolean[] visited;
    public static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        input = new int[n]; // 입력받은 배열
        arr = new int[n]; // 탐색된 배열
        visited = new boolean[n]; // 방문 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(ans);


    }

    public static void dfs(int depth){

        // 탐색을 모두 완료한 경우
        if(depth == n){
            int sum = 0;
            for(int i=1;i<n;i++){
                sum += Math.abs(arr[i]-arr[i-1]);
            }
            ans = Math.max(ans,sum);
            return;
        }


        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = input[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}