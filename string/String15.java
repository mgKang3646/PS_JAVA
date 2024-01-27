package org.example.string;

import java.util.*;

//BOJ20310 타노스
public class String15 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int zeroCount = 0;
        int oneCount = 0;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0') zeroCount++;
            else oneCount++;
        }

        zeroCount /= 2;
        oneCount /= 2;

        // 1 제거하기
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'&&count != oneCount){
                count++;
                continue;
            }
            sb.append(str.charAt(i));
        }

        str = sb.toString();

        // 0 제거하기
        sb = new StringBuilder();
        count = 0;

        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)=='0'&& count != zeroCount ){
                count++;
                continue;
            }

            sb.append(str.charAt(i));
        }

        System.out.println(sb.reverse().toString());
    }
}
