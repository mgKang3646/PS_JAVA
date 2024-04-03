package org.example.dfs;

import java.io.*;
import java.util.*;


//BOJ15686 치킨배달
public class Dfs13 {

    public static int[] arr;
    public static boolean[] visited;
    public static boolean[] result;
    public static int MAX_SIZE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            MAX_SIZE += arr[i];
        }

        result = new boolean[MAX_SIZE+1];

        // DFS 탐색
        dfs(0,0,n);

        // 출력
        boolean flag = false;
        for(int i=1;i<result.length;i++){
            if(!result[i]){
                flag = true;
                System.out.println(i);
                break;
            }
        }

        if(!flag){
            System.out.println(MAX_SIZE+1);
        }



    }

    public static void dfs(int sum,int depth, int limit){

        if(depth == limit){
            result[sum] = true;
            return;
        }

        // 부분집합에 포함되는 경우
        dfs(sum + arr[depth],depth+1,limit);

        // 부분집합에 포함되지 않는 경우
        dfs(sum, depth+1,limit);
    }


}