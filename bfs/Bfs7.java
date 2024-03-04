package org.example.bfs;

import java.io.*;
import java.util.*;


//BOJ9372 상근이의 여행
public class Bfs7 {

    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;


        while(t-- > 0 ){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            graph = new List[n+1];
            visited = new boolean[n+1];

            for(int i=1;i<=n;i++){
                graph[i] = new ArrayList<>();
            }

            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            // 연결그래프이니 BFS 탐색을 한 개의 노드에서만 한다. 어차피 간선의 개수만 세어주면 된다.
            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            visited[1] = true;
            System.out.println(bfs(queue));
        }

    }


    public static int bfs(Queue<Integer> queue){
        int result = 0;
        while(!queue.isEmpty()){
            int nation = queue.poll();
            for(int neighbor : graph[nation]){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    result++;
                    queue.add(neighbor);
                }
            }
        }

        return result;
    }
}