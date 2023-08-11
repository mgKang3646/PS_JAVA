package org.example.backtracking;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ15651 N과M(3)
public class Bt3 {

    static int n;
    static int m;

    static StringBuilder sb;

    //static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        //visited = new boolean[n];

        recursive(0,"");
        System.out.println(sb.toString());


    }

    public static void recursive(int depth, String result){
        if(depth == m) {
            sb.append(result).append("\n");
            return;
        }
        for(int i=1;i<=n;i++){
            String tmp = result + i + " ";
            recursive(depth+1,tmp);
        }
    }
}
