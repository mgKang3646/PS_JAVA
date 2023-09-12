package org.example.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//BOJ17420 깊콘이 넘쳐흘러 ( 어렵누... )
public class Greedy15 {

    static PriorityQueue<GiftCon> pq  = new PriorityQueue<>();


    public static class GiftCon implements Comparable<GiftCon> {
        public int expire;
        public int plan;

        public GiftCon(int expire, int plan) {
            this.expire = expire;
            this.plan = plan;
        }

        @Override
        public int compareTo(GiftCon o) {
            if(this.expire == o.expire){
                return this.plan - o.plan;
            }
            return this.expire -o.expire;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            pq.add(new GiftCon(Integer.parseInt(st1.nextToken()),Integer.parseInt(st2.nextToken())));
        }

        long ans = 0;
        int preMax = pq.peek().plan;
        int currMax = -1;
        while(!pq.isEmpty()){
            GiftCon giftCon = pq.poll();
            System.out.println("gifitCon Expire : " + giftCon.expire);
            System.out.println("preMax : " + preMax);

            if(preMax > giftCon.expire){

                if(preMax < giftCon.plan){
                    preMax = giftCon.plan;
                }

                int count = ((preMax - giftCon.expire) + 29)/30;
                giftCon.expire += ( count * 30 );
                System.out.println("count : " + count);

                ans += count;
            }

            currMax = Math.max(currMax,giftCon.expire);

            if( !pq.isEmpty() && pq.peek().plan != giftCon.plan){
                preMax = currMax;
            }


        }

        System.out.println(ans);
    }
}
