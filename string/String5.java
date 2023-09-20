package org.example.string;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//BOJ9081 단어 맞추기 ( DFS + 메모리 초과 )
public class String5 {

    public static String str, before, ans;
    public static char[] arr;
    public static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            before = "";
            ans = "";
            str = br.readLine();
            arr = str.toCharArray();
            visited = new boolean[arr.length];
            Arrays.sort(arr);

            dfs("",0);

            if(ans.equals("")) System.out.println(before);
            else System.out.println(ans);

        }
    }

    public static void dfs(String value, int depth){
        if(depth == arr.length){
            if(str.equals(before)){
                ans = value;
            }

            before = value;
            return;
        }

        for(int i=0;i<arr.length;i++){
            String tmp = value;
            if(!visited[i]){
                visited[i] = true;
                dfs(tmp+arr[i],depth+1);
                visited[i] = false;
            }
        }
    }
}
