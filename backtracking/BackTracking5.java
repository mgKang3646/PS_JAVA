package org.example.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOJ15654 N과M(5)
public class BackTracking5 {

    static int n;
    static int m;
    static StringBuilder sb;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i =0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i =0;i<n;i++){
            visited[i] = true;
            String result = arr[i]+" ";
            recursive(1,result);
            visited[i] = false;
        }

        System.out.println(sb.toString());

    }


    public static void recursive(int depth, String result){
        if(depth == m) {
            sb.append(result).append("\n");
            return;
        }
        for(int i=0; i<n;i++){
            if(visited[i]) continue;
            visited[i] = true;
            String tmp = result + arr[i] + " ";
            recursive(depth+1,tmp);
            visited[i] = false;
        }
    }
}
