package org.example.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

//BOJ15649 N과M(1)
public class Bf1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n+1]; //자동 false 세팅
        int[] arr = new int[n+1];

        for(int i=0;i<=n;i++){
            arr[i]=i;
        }

        for(int i=1;i<=n;i++){
            visited[i] = true;
            String str = i + "";
            recursive(i,1,m,arr,visited,str,sb);
            visited[i] = false;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void recursive(int value, int count, int m,int[] arr,boolean[] visited,String str,StringBuilder sb){
        if( count == m ){
            sb.append(str).append("\n");
            return;
        }

        for( int i=1;i<arr.length;i++) {
            if(visited[i]) continue;
            visited[i] = true;
            String str2 = str+" "+i;
            recursive(i,count+1,m,arr,visited,str2,sb);
            visited[i] = false;
        }
    }
}
