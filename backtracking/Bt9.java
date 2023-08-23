package org.example.backtracking;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//BOJ1759 암호 만들기
public class Bt9 {

    static int n,c;
    static char[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        visited = new boolean['z'-'a'+1];
        arr = new char[c];


        st = new StringTokenizer(br.readLine());
        for(int i=0;i<c;i++){
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        dfs("",-1,0,0,0 );

    }

    public static void dfs(String ans, int index, int depth, int ic, int cc ){

        if(depth == n){
            if(ic < 1) return;
            if(cc < 2) return;

            System.out.println(ans);
            return;
        }

        for(int i=index+1;i<c;i++){
            if(visited[arr[i]-'a']) continue;

            visited[arr[i]-'a'] = true;
            String tmp = ans;

            if(isGather(arr[i])) dfs(tmp+arr[i],i,depth+1,ic+1,cc);
            else dfs(tmp+arr[i],i,depth+1,ic,cc+1);

            visited[arr[i]-'a'] = false;
        }

    }

    public static boolean isGather(char c){
        List<Character> charList = List.of('a','e','i','o','u');
        return charList.contains(c);
    }
}
