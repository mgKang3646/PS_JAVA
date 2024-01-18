package org.example.dfs;

import java.io.*;
import java.util.*;

//BOJ15686 치킨 배달
public class Dfs7 {

    public static List<ChickenHouse> chickenHouses;
    public static List<House> houses;
    public static List<ChickenHouse[]> chickenHouseSet;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[n][n];
        chickenHouses = new ArrayList<>();
        houses = new ArrayList<>();
        chickenHouseSet = new ArrayList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int value = Integer.parseInt(st.nextToken());
                matrix[i][j] = value;

                if(value == 2) chickenHouses.add(new ChickenHouse(j,i));
                if(value == 1) houses.add(new House(j,i));
            }
        }

        // 1. 치킨집 M개 조합 완전탐색 -> 재귀호출 ( DFS )
        dfs(0,0,m,new ChickenHouse[m],new boolean[chickenHouses.size()]);

        // 2. M개 조합 중 치킨거리가 가장 최소인 거리 구하기
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<chickenHouseSet.size();i++){
            ans = Math.min(ans,getChickenDistAll(chickenHouseSet.get(i)));
        }

        System.out.println(ans);

    }

    // 치킨집 M개 조합 완전탐색 -> 재귀호출 ( DFS )
    public static void dfs(int index, int depth, int limit, ChickenHouse[] chickenHouseArray, boolean[] visited){

        if(depth == limit) {
            chickenHouseSet.add(chickenHouseArray);
            return;
        }

        for(int i=index;i<chickenHouses.size();i++){
            if(!visited[i]){
                visited[i] = true;
                ChickenHouse[] tmpArray = Arrays.copyOf(chickenHouseArray,chickenHouseArray.length);
                tmpArray[depth] = chickenHouses.get(i);
                dfs(i,depth+1,limit,tmpArray,visited);
                visited[i] = false;
            }
        }
    }


    // 조합에 따른 최소 치킨거리 구하기
    public static int getChickenDistAll(ChickenHouse[] chArray){
        int total = 0;
        for(int i=0;i<houses.size();i++){
            House house = houses.get(i);
            int dist = Integer.MAX_VALUE;
            for(int j=0;j<chArray.length;j++){
                dist = Math.min(dist,getChickenDist(chArray[j],house));
            }
            total += dist;
        }
        return total;
    }

    // 치킨 거리 구하기
    public static int getChickenDist(ChickenHouse chickenHouse, House house){
        return Math.abs(chickenHouse.x - house.x) + Math.abs(chickenHouse.y - house.y);
    }

    public static class House{
        int x;
        int y;

        public House(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static class ChickenHouse {
        int x;
        int y;

        public ChickenHouse(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
