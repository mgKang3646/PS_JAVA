package org.example.slidingwindow;

import java.util.Scanner;

//BOJ1522 문자열교환
public class Sw1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int aCount = 0;
        int ans = Integer.MAX_VALUE;

        // 윈도우 크기 계산하기 : a의 개수 세기
        for(int i=0;i<str.length();i++ ){
            if(str.charAt(i)=='a'){
                aCount++;
            }
        }

        // 윈도우 안에 b의 개수 세기
        for(int i=0;i<str.length();i++){
            int end = i + aCount -1;
            int count = 0;
            for(int j=i;j<=end;j++){
                int pointer = j;
                if(j >= str.length()) pointer = j-str.length();
                if(str.charAt(pointer)=='b') count++;
            }

            // 윈도우 안의 b의 개수의 최솟값
            ans = Math.min(ans,count);
        }

        //출력
        System.out.println(ans);

    }
}
