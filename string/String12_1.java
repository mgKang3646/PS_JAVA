package org.example.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//BOJ12919 A 와 B 2 ( 시간 초과 발생 )
public class String12_1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        boolean flag = dfs(t,s);

        if(flag) System.out.println(1);
        else System.out.println(0);

    }

    public static boolean dfs(String t , String curr){

        if(t.length() == curr.length()){
            return t.equals(curr);
        }

        // 1. A 추가 하기
        if(dfs(t,curr+"A")) return true;

        // 2. B 추가하고 문자열 뒤집기
        StringBuffer sb = new StringBuffer(curr+"B");
        if(dfs(t,sb.reverse().toString())) return true;

        return false;

    }
}

