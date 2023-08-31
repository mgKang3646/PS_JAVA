package org.example.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

//BOJ1967 트리의 지름 ( tree + dfs )
public class Tree5 {

    static List<Edge>[] tree;
    static boolean[] visited;
    static int n, ans, maxNode;

    public static class Edge{
        int next;
        int cost;

        public Edge(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new List[n+1];

        for(int i=0;i<=n;i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            tree[parent].add(new Edge(child,cost));
            tree[child].add(new Edge(parent,cost));

        }

        visited = new boolean[n+1];
        findMaxDiameter(1,0); // 노드1 DFS 탐색
        visited = new boolean[n+1];
        findMaxDiameter(maxNode,0); // 가중치가 높은 노드 DFS 탐색

        System.out.println(ans);

    }

    public static void findMaxDiameter(int node, int diameter){

        if(ans < diameter){
            ans = diameter;
            maxNode = node; // 가중치 높은 노드 갱신
        }

        visited[node] = true; // 양방향 관계에서 역행방지

        for( Edge edge : tree[node] ){
            if(visited[edge.next]) continue;
            findMaxDiameter(edge.next,diameter+edge.cost);
        }
    }

}
