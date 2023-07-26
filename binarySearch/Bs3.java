package org.example.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOJ10815 숫자 카드
public class Bs3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] nArr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] mArr = new int[m];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<m;i++){
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArr); // 이분탐색 전 정렬하기
        for (int value : mArr) {
            if( Arrays.binarySearch(nArr, value) < 0 ) sb.append(0).append(" "); // 이분탐색
            else sb.append(1).append(" ");
        }

        System.out.println(sb.toString());
    }
}
