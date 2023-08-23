package org.example.greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

//BOJ1715 카드 정렬하기
public class Greedy13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;

        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            pq.add(sc.nextInt());
        }

        while(pq.size() >= 2){
            int num1 = pq.remove();
            int num2 = pq.remove();
            int sum = num1 + num2;
            ans += sum;
            pq.add(sum);
        }

        System.out.println(ans);

    }
}
