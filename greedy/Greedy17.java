package org.example.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//BOJ8980 택배
public class Greedy17 {

    public static class Deploy implements Comparable<Deploy>{

        int start;
        int des;
        int quantity;

        public Deploy(int start, int des,int quantity){
            this.start = start;
            this.des = des;
            this.quantity = quantity;
        }

        @Override
        public int compareTo(Deploy d) {
            if(this.des == d.des) return this.start - d.start;
            return this.des - d.des;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ans = 0;
        int n = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        PriorityQueue<Deploy>  pq = new PriorityQueue<>();
        int[] pos = new int[n+1];
        Arrays.fill(pos,limit);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            int quantity = Integer.parseInt(st.nextToken());

            pq.add(new Deploy(start,des,quantity));
        }

        while(!pq.isEmpty()){
            Deploy d = pq.remove();

            int start = d.start;
            int des = d.des;
            int quantity = d.quantity;

            int maxNum = Integer.MAX_VALUE;


            // 트럭에 실을 수 있는 최댓값 구하기
            for(int i=start;i<des;i++){
                // 시작점과 도착점 사이 지점 중 실을 수 있는 최소 중량 구하기
                maxNum = Math.min(maxNum,pos[i]);
            }

            // 택배 개수가 최댓값보다 작은 경우
            if( maxNum >= quantity ){
                for(int i=start;i<des;i++){
                    pos[i] -= quantity;
                }
                ans += quantity;
            }

            // 택배 개수가 최댓값보다 큰 경우
            else {
                for(int i=start;i<des;i++){
                    pos[i] -= maxNum;
                }
                // 최대 개수의 택배만 이동
                ans += maxNum;
            }

        }

        System.out.println(ans);

    }

}
