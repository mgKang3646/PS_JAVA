package org.example.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ15652 N과M(4)
public class BackTracking4 {

    static int n;
    static int m;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=1;i<=n;i++){
            recursive(i,1,i+"");
        }
        System.out.println(sb.toString());
    }

    public static void recursive(int index,int depth, String arr){

        if(depth == m){
            sb.append(arr).append("\n");
            return;
        }

        for(int i=index; i<=n;i++){
            String tmp = arr + " " + i;
            recursive(i,depth+1,tmp);
        }
    }
}
