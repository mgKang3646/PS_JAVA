package org.example.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.*;

//BOJ1826 연료 채우기 ( 우선순위큐 사용 X, DFS사용, 시간초과 )
public class Greedy19_1 {

    public static GasStation[] gasStations;
    public static StringTokenizer st;
    public static int n,l,p;
    public static int ans = Integer.MAX_VALUE;

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
        gasStations = new GasStation[n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int des = Integer.parseInt(st.nextToken());
            int gas = Integer.parseInt(st.nextToken());

            gasStations[i] = new GasStation(des,gas);
        }

        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken()); // 트럭과 마을 사이의 거리
        p = Integer.parseInt(st.nextToken()); // 트럭 초기 연료량

        Arrays.sort(gasStations);
        dfs(0,0,0,p);

        System.out.println(ans);

    }


    public static void dfs(int depth, int fillCount, int truckDes, int truckGas){

        if(depth == n){
            truckGas -= ( l - truckDes ) ;
            if(truckGas >= 0) ans = min(ans,fillCount);
            return;
        }

        GasStation gasStation = gasStations[depth];
        truckGas -= ( gasStation.des - truckDes );

        if( fillCount > ans || truckGas < 0 ) return;
        else truckDes = gasStation.des;

        // 주유소에서 기름을 넣고 가지 않는 경우
        dfs(depth+1,fillCount,truckDes,truckGas);

        // 주유소에서 기름을 넣고가는 경우
        dfs(depth+1,fillCount+1, truckDes, truckGas+gasStation.gas);

    }
}
