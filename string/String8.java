package org.example.string;

import java.util.Scanner;

//BOJ14405 피카츄
public class String8 {

    static String[] values = { "pi", "ka", "chu"};
    static String ans;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ans = sc.next();

        if(dfs("")) System.out.println("YES");
        else System.out.println("NO");

    }


    public static boolean dfs(String str){
        if( ans.length() <= str.length() ){
            if( ans.equals(str) ) return true;
            else return false;
        }

        for(int i=0;i<3;i++){
            String tmp = str;
            tmp += values[i];
            if(!ans.contains(tmp)) continue;
            if(dfs(tmp)) return true;
        }

        return false;
    }
}
