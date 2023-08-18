package org.example.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

//BOJ1939 중량제한 ( BinarySearch를 이용하지 않은 DFS 풀이, 시간초과 발생 )
public class Bs6 {

    public static List<Bridge>[] nodes;
    public static boolean[] visited;
    public static int ans;

    public static class Bridge{
        int nextNode;
        int limit;

        public Bridge(int nextNode, int limit) {
            this.nextNode = nextNode;
            this.limit = limit;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        nodes = new List[n+1];
        visited = new boolean[n+1];

        for(int i=0;i<n+1;i++){
            nodes[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            nodes[node1].add(new Bridge(node2,limit));
            nodes[node2].add(new Bridge(node1,limit));
        }

        st = new StringTokenizer(br.readLine());

        int factoryNode1 = Integer.parseInt(st.nextToken());
        int factoryNode2 = Integer.parseInt(st.nextToken());

        visited[factoryNode1] = true;
        dfs(factoryNode1,factoryNode2,Integer.MAX_VALUE);

        System.out.println(ans);
    }

    public static void dfs(int curr, int dest, int limit){
        if(curr == dest) {
            ans = max(ans,limit);
            return;
        }

        for (Bridge bridge : nodes[curr]) {
            if(visited[bridge.nextNode]) continue;

            visited[bridge.nextNode] = true; // 역행방지
            dfs(bridge.nextNode,dest, min(limit,bridge.limit));
            visited[bridge.nextNode] = false; // 완전탐색을 위해 원복
        }
    }
}
