package org.example.backtracking;

import java.io.*;
import java.util.*;

public class Bt10 {

    static int n,m;
    static int[][] matrix;
    static List<int[]> houses;
    static List<int[]> chickenStores;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][n];
        houses = new ArrayList<>();
        chickenStores = new ArrayList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int value = Integer.parseInt(st.nextToken());
                matrix[i][j] = value;

                if(value==1) houses.add(new int[]{i,j});
                if(value==2) chickenStores.add(new int[]{i,j});
            }
        }

        visited = new boolean[chickenStores.size()];
        backtracking(0,0);

        System.out.println(ans);

    }

    public static void backtracking(int size, int index){

        if(size == m){
            int result = 0;
            for(int i=0;i<houses.size();i++){
                int[] house = houses.get(i);
                int dist = Integer.MAX_VALUE;
                for(int j=0;j<chickenStores.size();j++){
                    if(!visited[j]) continue;
                    int[] chickenStore = chickenStores.get(j);
                    dist = Math.min(dist, Math.abs(chickenStore[0]-house[0])+Math.abs(chickenStore[1]-house[1]));
                }
                result += dist;
            }
            ans = Math.min(ans,result);
            return;
        }

        for(int i=index;i<chickenStores.size();i++){
            if(visited[i]) continue;
            visited[i] = true;
            backtracking(size+1,i);
            visited[i] = false;
        }
    }
}
