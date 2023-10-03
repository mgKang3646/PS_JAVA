package org.example.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//BOJ1911 흙길 보수하기
public class Greedy18 {


    public static class Pool implements Comparable<Pool>{
        int start;
        int end;

        public Pool(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pool p) {
            if(this.start == p.start) return this.end - p.end;
            return this.start - p.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Pool[] pools = new Pool[n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pools[i] = new Pool(start,end);
        }

        // 물웅덩이 정렬
        Arrays.sort(pools);

        int ans = 0;
        int range = 0;

        for (Pool pool : pools) {
            // start와 range 비교
            if(pool.start > range){
                range = pool.start; //range 갱신
            }

            // end오 range 비교
            if(pool.end > range){
                while( pool.end > range ){
                    range += l; // range 갱신
                    ans+=1; // 널빤지 갱신
                }
            }
        }

        System.out.println(ans);
    }

}
