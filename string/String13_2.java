package org.example.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//BOJ20437 문자열 게임2
public class String13_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        while(t-- > 0) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());

            // 문자열 안의 알파벳 개수 세기
            int[] alphabets = new int['z' - 'a' + 1];
            for (int i = 0; i < str.length(); i++) {
                alphabets[str.charAt(i) - 'a']++;
            }

            int maxValue = 0;
            int minValue = Integer.MAX_VALUE;

            // 문자열 탐색 시작
            for(int i=0;i<str.length();i++){
                char value = str.charAt(i);
                if(alphabets[value-'a'] < k) continue; // 문자열 개수가 K보다 작으면 건너뛰기 ( 가지치기 )

                // K개 이상이면 문자열 탐색
                String subStr = getSubStr(str,value,i,k);

                // 최소길이 최대길이 초기화
                if(subStr != null){
                    if(minValue > subStr.length()) minValue = subStr.length();
                    if(maxValue < subStr.length()) maxValue = subStr.length();
                }
            }

            // 결과 출력
            if(minValue != Integer.MAX_VALUE) System.out.println(minValue+ " " + maxValue);
            else System.out.println(-1);
        }


    }

    // 문자열 탐색 함수
    public static String getSubStr(String str, char target, int start, int k){
        int count = 0;
        for(int i=start;i<str.length();i++){
            if(str.charAt(i) == target) count++;
            if(count == k) { // 동일한 문자가 K개 있으면 부분문자열 반환
                return str.substring(start,i+1);
            }
        }
        return null;
    }


}
