package org.example.string;

import java.util.Scanner;

//BOJ1251 단어나누기
public class String9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb;

        String ans = "";

        for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){
                if(i != j && i != 0 ){
                    sb = new StringBuilder();

                    //1. substring으로 문자열 자르고 StringBuffer에 문자열 저장
                    StringBuffer first = new StringBuffer(str.substring(0,i));
                    StringBuffer second = new StringBuffer(str.substring(i,j));
                    StringBuffer third = new StringBuffer(str.substring(j));

                    //2. StringBuffer 뒤집기
                    sb
                            .append(first.reverse())
                            .append(second.reverse())
                            .append(third.reverse());

                    //3. 사전순 비교하기
                    if(ans.equals("")) ans = sb.toString();
                    else{
                        int value = ans.compareTo(sb.toString());
                        if(value > 0) ans = sb.toString();
                    }

                }
            }
        }

        System.out.println(ans);
    }
}
