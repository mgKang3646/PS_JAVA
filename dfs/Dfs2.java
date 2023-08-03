package org.example.dfs;

import java.io.*;
import java.util.*;

//BOJ16947 서울 지하철 2호선
public class Dfs2 {
    static Node[] nodes; // 그래프
    static boolean[] visited; // 방문여부 테이블

    //Node 데이터
    public static class Node{
        int index; // Node의 index
        boolean isCycle; // 싸이클에 Node 포함 여부
        int dist; // 싸이클과의 거리
        List<Node> nextNodes = new ArrayList<>(); // 인접노드 리스트

        public Node(int index){
            this.index = index;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        nodes = new Node[n+1]; // 그래프 생성
        visited = new boolean[n+1]; // 방문여부 테이블 생성

        // STEP1. 그래프를 인접리스트로 구현하기
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i); // 그래프 초기화
        }

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 인접리스트에 데이터 세팅하기
            nodes[a].nextNodes.add(nodes[b]); // 양방향 그래프
            nodes[b].nextNodes.add(nodes[a]); // 양방향 그래프
        }

        // STEP2. 싸이클 찾기 ( DFS )
        for(int i=1;i<n+1;i++){
            visited[i] = true;
            if(findCycle(nodes[i],nodes[i],1)) break; // 싸이클은 1개 이므로 찾으면 break
            visited[i] = false;
        }

        // STEP3. 싸이클과의 거리 계산하기 ( DFS )
        for(int i=1;i<=n;i++){
            if(nodes[i].isCycle) nodes[i].dist = 0; // 싸이클에 포함되어 있는 Node의 경우, 거리 = 0
            else{ // 싸이클에 포함되어 있지 않은 경우, DFS로 거리 계산하기
                visited = new boolean[n+1];
                visited[i] = true;
                setDist(nodes[i],nodes[i],0);
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(nodes[i].dist).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 싸이클 찾기 DFS
    public static boolean findCycle(Node node, Node startNode, int depth){

        for (Node nextNode : node.nextNodes) {
            if(depth > 2 && nextNode == startNode) { // 다음 노드가 시작노드이면 순환 탐색 완료
                node.isCycle = true; // 싸이클에 포함 true
                return true;
            }
            if(!visited[nextNode.index]) {
                visited[nextNode.index] = true; // 방문이력 남기기
                if (findCycle(nextNode, startNode, depth + 1)) {
                    node.isCycle = true; //싸이클에 포함 true
                    return true;
                }
                visited[nextNode.index] = false; // DFS 종료 후, 방문이력 지우기
            }
        }
        return false; // 싸이클을 찾지 못하면 false 반환
    }

    // 싸이클과의 거리 계산하기 DFS
    public static void setDist(Node node, Node startNode, int depth){
        if(node.isCycle) { // 지선은 경로가 하나이므로, 싸이클을 만나면 바로 종료
            startNode.dist = depth; // DFS 깊이로 싸이클과의 거리 구하기
            return;
        }

        // 싸이클에 포함된 노드를 발견하지 못하면 DFS 탐색
        for( Node nextNode : node.nextNodes ) {
            if(!visited[nextNode.index]){
                visited[nextNode.index] = true; // 역행 방지
                setDist(nextNode,startNode,depth+1); // DFS 탐색
            }
        }
    }

}


