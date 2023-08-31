package org.example.twopointer;


import java.util.Scanner;
import static java.lang.Math.*;

//BOJ2118 두 개의 탑
public class Tp2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dist = new int[n];
        int sum = 0;
        int ans = 0;
        for(int i=0;i<n;i++){
            dist[i] = sc.nextInt();
            sum += dist[i];
        }

        int pointerA = 0;
        int pointerB = 1;

        int right = dist[pointerA];
        int left = sum - right;

        // PointerA를 기준으로 탐색
        while(pointerA < n){
            ans = max(ans, min(right,left));

            // 왼쪽 경로가 크면 PointerB를 이동
            if( right < left ){
                right += dist[pointerB];
                left -= dist[pointerB];
                pointerB++;
                pointerB %= n;
            }

            // 오른쪽 경로가 크면 PointerA를 이동
            else{
                right -= dist[pointerA];
                left += dist[pointerA];
                pointerA++;
            }
        }

        //결과 출력
        System.out.println(ans);


    }
}
