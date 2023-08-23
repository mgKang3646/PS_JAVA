package org.example.datastructure;


import java.util.PriorityQueue;
import java.util.Scanner;

//BOJ1927 최소 힙
public class Queue1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            int input = sc.nextInt();

            if(input==0){
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.remove());
            }

            else{
                pq.add(input);
            }
        }

    }
}
