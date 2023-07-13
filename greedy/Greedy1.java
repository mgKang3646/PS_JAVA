package org.example.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//BOJ1202 보석도둑
public class Greedy1 {

    static StringTokenizer st;
    static Jew[] jews;
    static int[] bags;
    static int k;
    static int n;

    static class Jew {
        int m;
        int v;

        public Jew(int m, int v) {
            this.m = m;
            this.v = v;
        }

    }
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        jews = new Jew[n];
        bags = new int[k];

        for(int i =0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jews[i] = new Jew(m,v);
        }

        for(int j=0;j<k;j++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            bags[j]= c;
        }

        Arrays.sort(jews, new Comparator<Jew>() {
            @Override
            public int compare(Jew o1, Jew o2) {
                if(o1.m==o2.m) return o2.v - o1.v; // 가격으로 내립차순 정렬
                return o1.m - o2.m; // 무게로 오름차순 정렬
            }
        });

        Arrays.sort(bags); // 가방 무게로 오름차순 정렬
    }

    public static void solution(){
        PriorityQueue<Jew> pq = new PriorityQueue<>((j1,j2)-> j2.v - j1.v); // 내림차순으로 우선순위큐 정렬
        long ans = 0;
        int j =0;
        for(int i =0; i<k; i++){
            while(j<n&&jews[j].m<=bags[i]){
                pq.offer(jews[j++]);
            }
            if(!pq.isEmpty()) ans += pq.poll().v;
        }
        System.out.println(ans);
    }

}
