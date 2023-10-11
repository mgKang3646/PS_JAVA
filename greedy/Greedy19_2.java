package org.example.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Math.min;

//BOJ1826 연료 채우기 ( 우선순위큐 사용 )
public class Greedy19_2 {

    public static StringTokenizer st;
    public static int n,target, currGas;
    public static int ans = 0;
    public static PriorityQueue<GasStation> gasStationQueue = new PriorityQueue<>();
    public static PriorityQueue<Integer> gasQueue = new PriorityQueue<>( (i1,i2) -> i2-i1 );

    public static class GasStation implements Comparable<GasStation>{
        public int des;
        public int gas;

        public GasStation(int des, int gas){
            this.des = des;
            this.gas = gas;
        }

        @Override
        public int compareTo(GasStation g){
            return this.des - g.des;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int des = Integer.parseInt(st.nextToken());
            int gas = Integer.parseInt(st.nextToken());

            gasStationQueue.add(new GasStation(des,gas));
        }

        st = new StringTokenizer(br.readLine());
        target = Integer.parseInt(st.nextToken()); // 트럭과 마을 사이의 거리
        currGas = Integer.parseInt(st.nextToken()); // 트럭 초기 연료량

        // 현재주유량 < 마을거리
        while( currGas < target ){

            while(!gasStationQueue.isEmpty() && gasStationQueue.peek().des <= currGas ){
                gasQueue.add( gasStationQueue.poll().gas);
            }

            // 더이상 주유소가 없으면 -1
            if(gasQueue.isEmpty()) {
                ans = -1;
                break;
            }

            // 주유하기
            ans++;
            currGas += gasQueue.poll();
        }

        System.out.println(ans);


    }





}
