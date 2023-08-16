package org.example.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

//BOJ1461 도서관
public class Greedy10 {

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        List<Integer> leftBooks = new ArrayList<>(); // 좌측 책 리스트
        List<Integer> rightBooks = new ArrayList<>(); // 우측 책 리스트

        st = new StringTokenizer(br.readLine());

        int rightMax = 0;
        int leftMax = 0;

        for(int i =0; i<n;i++){
             int value = Integer.parseInt(st.nextToken());

            // 좌우 측 분리
             if(value < 0) {
                 leftMax = max(leftMax,abs(value));
                 leftBooks.add(abs(value)); // 음수는 절대값로 변환하여 넣기
             }
             else {
                 rightMax = max(rightMax,abs(value));
                 rightBooks.add(value);
             }
        }

        // 가장 멀리 있는 책들을 우선 묶기 위해 내림차순으로 정렬
        Collections.sort(leftBooks,Collections.reverseOrder());
        Collections.sort(rightBooks,Collections.reverseOrder());

        // 가장 멀리 있는 책을 가장 마지막에 방문하기 위해, 좌측 리스트와 우측 리스트의 최대 거리를 비교하여 메소드 호출
        int ans =0;
        if(leftMax > rightMax) ans = getStepCount(rightBooks,leftBooks);
        else ans = getStepCount(leftBooks,rightBooks);

        System.out.println(ans);

    }

    public static int getStepCount(List<Integer> firstBooks, List<Integer> secondBooks){
        int result = 0;

        int pointer = 0;
        while(pointer < firstBooks.size()){ // 멀리 있는 것부터 m개씩 묶기
            result += firstBooks.get(pointer)*2; // 왕복
            pointer += m; // m 개씩 묶기
        }

        pointer = 0;
        while(pointer < secondBooks.size()){
            if(pointer == 0) result += secondBooks.get(pointer); // 가장 멀리 있는 책은 한번만 왕복X
            else result += secondBooks.get(pointer)*2; // 그외 책은 왕복
            pointer += m; // m개식 묶기
        }

        return result;
    }
}
