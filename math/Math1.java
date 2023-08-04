package org.example.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

//BOJ10610 30
public class Math1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = br.readLine().toCharArray(); // 입력받기
        Integer[] numArr = new Integer[charArr.length]; // 각 자리 수의 배열
        int sum = 0; // 각 자리 숫자의 합

        // 각 자리수 숫자를 정수형 배열로 저장
        for(int i=0;i<numArr.length;i++){
            numArr[i] = charArr[i] -'0';
            sum += numArr[i]; // 동시에 합도 계산
        }

        Arrays.sort(numArr, Comparator.reverseOrder()); // 내림차순 정렬

        if(numArr[numArr.length-1] != 0 || sum%3 != 0){ // 끝이 0으로 끝나지 않거나 각 자리 숫자의 합이 3으로 나누어지지 않는다면 -1 출력
            System.out.println(-1);
        }else{ // 30의 배수인 경우, 결과 출력
            StringBuilder sb = new StringBuilder();
            Arrays.stream(numArr).forEach(sb::append);
            System.out.println(sb.toString());
        }
    }
}
