package org.example.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//BOJ10282 해킹
public class Dijk2 {


    public static List<Edge>[] graph;
    public static int[] costTable;
    public static boolean[] visited;

    public static class Edge{
        int node;
        int cost;

        public Edge(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while(t-- >0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            graph = new List[n+1];
            costTable = new int[n+1];
            visited = new boolean[n+1];

            for(int i=1;i<=n;i++){
                graph[i] = new ArrayList<>();
                costTable[i] = Integer.MAX_VALUE;
            }

            for(int i=0;i<d;i++){
                st = new StringTokenizer(br.readLine());
                int next = Integer.parseInt(st.nextToken());
                int node = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph[node].add(new Edge(next,cost));
            }

            dijkstra(start);

            int count = 0;
            int time = 0 ;

            for(int i=1;i<=n;i++){
                if(costTable[i] != Integer.MAX_VALUE){
                    count++;
                    time = Math.max(time,costTable[i]);
                }
            }

            sb.append(count).append(" ").append(time).append("\n");

        }

        System.out.println(sb.toString());
    }


    public static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1,e2)->e1.cost-e2.cost);
        StringBuilder sb = new StringBuilder();

        pq.add(new Edge(start,0));

        while(!pq.isEmpty()){

            Edge currEdge = pq.poll();
            int currNode = currEdge.node;
            int currCost = currEdge.cost;

            if( currCost > costTable[currNode] ) continue;

            costTable[currNode] = currCost;

            for (Edge edge : graph[currNode]) {
                int nextNode = edge.node;
                int nextCost = edge.cost;

                if(!visited[nextNode]){
                    pq.add(new Edge(nextNode,nextCost + currCost));
                }
            }
            visited[currNode] = true;
        }
    }
}
