package org.example.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//BOJ18126 너구리 구구
public class Dijk3 {

    public static class Dist implements Comparable<Dist>{
        int node;
        long cost;

        public Dist(int node,long cost){
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Dist d1){
            if( this.cost < d1.cost ){
                return -1;
            }else if (this.cost == d1.cost){
                return 0;
            }else{
                return 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Dist>[] graph = new List[n+1];

        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[a].add(new Dist(b,cost));
            graph[b].add(new Dist(a,cost));
        }

        long[] arr = new long[n+1];
        Arrays.fill(arr,Long.MAX_VALUE);

        arr[1] = 0;
        PriorityQueue<Dist> pq = new PriorityQueue<>();
        pq.add(new Dist(1,0));

        while(!pq.isEmpty()){
            Dist dist = pq.poll();

            if(arr[dist.node] < dist.cost) continue;

            for(Dist nextDist : graph[dist.node]){
                if(arr[nextDist.node] > dist.cost + nextDist.cost){
                    arr[nextDist.node] = dist.cost + nextDist.cost;
                    pq.add(new Dist(nextDist.node,(dist.cost + nextDist.cost)));
                }
            }
        }

        long ans = 0;
        for(int i=1;i<=n;i++){
            ans = Math.max(ans,arr[i]);
        }

        System.out.println(ans);

    }
}