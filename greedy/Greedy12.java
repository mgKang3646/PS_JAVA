package org.example.greedy;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//BOJ1781 컵라면 ( HeapQueue )
public class Greedy12 {
    public static class Problem implements Comparable<Problem>{
        int deadLine;
        int reward;

        public Problem(int deadLine,int reward){
            this.deadLine = deadLine;
            this.reward = reward;
        }

        @Override
        public int compareTo(Problem o){
            return this.deadLine - o.deadLine;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Problem[] problems = new Problem[n];

        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int deadLine = Integer.parseInt(st.nextToken());
            int reward = Integer.parseInt(st.nextToken());

            problems[i] = new Problem(deadLine,reward);
        }

        Arrays.sort(problems);
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 디폴트 오름차순 정렬

        for(int i=0;i<n;i++){
            int deadLine = problems[i].deadLine;
            int reward = problems[i].reward;

            pq.add(reward);

            if(pq.size() > deadLine){
                pq.remove();
            }
        }

        int ans = 0;
        while(!pq.isEmpty()){
            ans += pq.remove();
        }

        System.out.println(ans);
    }
}
