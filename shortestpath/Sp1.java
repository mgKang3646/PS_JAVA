package org.example.shortestpath;

import java.io.*;
import java.util.*;

//BOJ1753 최단경로
public class Sp1 {

    public static PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(); // 우선순위큐
    public static int[] dist; // 최단경로테이블
    public static boolean[] visited; // 방문여부테이블
    public static List<Edge>[] nextNodes; // 인접노드테이블

    //Edge 이동경로 데이터를 담은 객체
    public static class Edge implements Comparable<Edge> {
        int index; //이동할 인접노드 인덱스
        int cost; // 이동할 경우 인접노드까지 드는 비용

        public Edge(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        nextNodes = new ArrayList[v+1];
        dist = new int[v+1];
        visited = new boolean[v+1];

        for(int i=1;i<=v;i++){
            nextNodes[i] = new ArrayList<Edge>();
            dist[i] = Integer.MAX_VALUE;
        }

        //인접노드테이블 초기화
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());

            int index = Integer.parseInt(st.nextToken());
            int nextIndex = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nextNodes[index].add(new Edge(nextIndex,cost));
        }

        // 다익스트라 알고리즘 시작
        dijkstra(start);

        //출력
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=v;i++){
            if( dist[i]== Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra(int start){
        //시작점
        dist[start] = 0;
        visited[start] = true;
        List<Edge> next = nextNodes[start];
        priorityQueue.add(new Edge(start,0));


        while(!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll(); // 우선순위큐에서 가장 낮은 비용의 이동경로 객체 Edge 가져오기
            if( edge.cost > dist[edge.index] ) continue; // 최적 비용 여부 탐색 ( 백트래킹 )
            dist[edge.index] = edge.cost; // 최적의 비용으로 초기화

            for (Edge nextEdge : nextNodes[edge.index]) { // 인접노드 탐색
                if(!visited[nextEdge.index]){ // 이미 방문된 노드인 경우 X
                    int nextDist = dist[edge.index] + nextEdge.cost; // 이동경로 데이터 최신화
                    priorityQueue.add(new Edge(nextEdge.index,nextDist)); // Edge 생성하여 우선순위큐에넣기
                }
            }
            visited[edge.index] =true; // 탐색완료
        }
    }
}
