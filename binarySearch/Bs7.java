package org.example.binarySearch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//BOJ1939 중량제한 ( BinarySearch + BFS  )
public class Bs7 {


    public static List<Bridge>[] bridges;
    public static boolean[] visited;
    public static int ans,n,m;
    public static int factoryNode1;
    public static int factoryNode2;

    public static class Bridge {
        int nextNode;
        int weight;

        public Bridge(int nextNode, int weight) {
            this.nextNode = nextNode;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        bridges = new List[n+1];

        for(int i=0;i<n+1;i++){
            bridges[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            bridges[node1].add(new Bridge(node2,limit));
            bridges[node2].add(new Bridge(node1,limit));
        }

        st = new StringTokenizer(br.readLine());

        factoryNode1 = Integer.parseInt(st.nextToken());
        factoryNode2 = Integer.parseInt(st.nextToken());

        int ans = binarySearch(1,1000000000); // 이분탐색 시작
        System.out.println(ans);

    }

    public static int binarySearch(int left, int right){
        if(left > right) return right;

        int mid = ( left + right ) / 2 ;

        if(bfs(mid)) return binarySearch(mid+1, right); // 중간중량이 이동가능하다면 우측범위 탐색
        else return binarySearch(left, mid-1); // 중간중량이 이동이 불가능하다면 좌측범위 탐색
    }

    //BFS 로직
    public static boolean bfs(int weight) {
        Queue<Bridge> queue = new LinkedList<>();
        visited = new boolean[n + 1];
        addInQueue(weight,factoryNode1,queue); // 시작지점 큐에 넣기

        while (!queue.isEmpty()) {
            Bridge curr = queue.remove();
            if (curr.nextNode == factoryNode2) return true;
            addInQueue(weight,curr.nextNode,queue);
        }

        return false;
    }

    private static void addInQueue(int weight, int node, Queue<Bridge> queue) {
        for (Bridge bridge : bridges[node]) {
            if( weight <= bridge.weight && !visited[bridge.nextNode]) {
                queue.add(bridge);
                visited[bridge.nextNode] = true;
            }
        }
    }

}
