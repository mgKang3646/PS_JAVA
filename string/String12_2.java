package org.example.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//BOJ12919 A 와 B 2 ( String12_1과 시간 복잡도 계산해서 블로그 정리하기 )
public class String12_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        if(dfs(t,s)) System.out.println(1);
        else System.out.println(0);

    }

    public static boolean dfs(String curr , String target){

        if(curr.length() == target.length()){
            return curr.equals(target);
        }

        // 앞이 B인 경우, B를 제가하고 뒤집기
        if(curr.charAt(0) == 'B'){
            StringBuilder sb = new StringBuilder(curr.substring(1,curr.length()));
            if(dfs(sb.reverse().toString(),target)) return true;
        }

        // 뒤가 A인 경우, A를 제거하기
        if(curr.charAt(curr.length()-1) == 'A'){
            if(dfs(curr.substring(0,curr.length()-1),target)) return true;
        }

        return false;

    }
}

