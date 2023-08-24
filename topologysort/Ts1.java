package org.example.topologysort;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//BOJ1756 문제집
public class Ts1 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new List[n+1];
        int[] degrees = new int[n+1];

        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int index= Integer.parseInt(st.nextToken());
            int nextIndex = Integer.parseInt(st.nextToken());

            graph[index].add(nextIndex);
            degrees[nextIndex]++;

        }

        for(int i=1;i<=n;i++){
            if(degrees[i] == 0 ){
                pq.add(i);
            }
        }

        while(!pq.isEmpty()){
            int problem = pq.remove();
            sb.append(problem).append(" ");

            for(int next : graph[problem]) {
                degrees[next]--;
                if(degrees[next] == 0) pq.add(next);
            }

        }

        System.out.println(sb.toString());

    }
}
