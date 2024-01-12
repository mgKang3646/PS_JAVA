package org.example.implementation;

import java.io.*;
import java.util.*;

//BOJ8979 올림픽
public class Impl3 {

    public static class Country implements Comparable<Country> {

        int num;
        int gold;
        int silver;
        int bronze;

        public Country(int num, int gold, int silver, int bronze){
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public boolean isEqualRank(Country c){
            return (this.gold == c.gold && this.silver == c.silver && this.bronze == c.bronze)? true : false;
        }

        @Override
        public int compareTo(Country c){
            if(this.gold == c.gold){
                if(this.silver == c.silver) return c.bronze - this.bronze;
                else return c.silver - this.silver;
            }else{
                return c.gold - this.gold;
            }
        }


    }

    public static void main(String[] args) throws IOException{

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Country> pq = new PriorityQueue();

        int t = Integer.parseInt(st.nextToken());
        int[] rank = new int[1001];
        int target = Integer.parseInt(st.nextToken());

        // 나라별 메달정보 초기화
        while(t-- > 0){

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            pq.add(new Country(n,gold,silver,bronze));

        }

        // 나라별 랭크 초기화
        int currRank = 1;
        Country beforeCountry = new Country(-1,-1,-1,-1);

        while(!pq.isEmpty()){
            Country country = pq.poll();
            if(country.isEqualRank(beforeCountry)) rank[country.num] = rank[beforeCountry.num];
            else rank[country.num] = currRank;

            beforeCountry = country;
            currRank++;
        }

        //출력
        System.out.println(rank[target]);

    }
}
