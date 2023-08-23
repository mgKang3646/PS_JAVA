package org.example.string;


import java.util.Scanner;

//BOJ165000 문자열 판별 ( 백트래킹 )
public class String2 {

    public static String[] words;
    public static boolean[] visited;
    public static boolean flag;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int n = sc.nextInt();
        words = new String[n];
        visited = new boolean[n];

        for(int i=0;i<n;i++){
            words[i] = sc.next();
        }

        dfs("",str);

        if(flag) System.out.println(1);
        else System.out.println(0);

    }

    public static void dfs(String ans, String target){

        if(ans.equals(target)) {
            flag = true;
            return;
        }

        for(int i=0;i<words.length;i++){
            if(visited[i]) continue;

            String tmp = ans;
            String value = tmp+words[i];

            if(target.length() < value.length() ) continue; // 가지치기 조건1
            if(target.substring(0,value.length()).equals(value)){ // 가지치기 조건2
                visited[i] = true;
                dfs(value, target);
                visited[i] = false;
            }
        }
    }
}
