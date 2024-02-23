package org.example.dp;

import java.io.*;
import java.util.*;


//BOJ1446 지름길
public class Dp23 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] dp = new int[d+1];
        HashMap<Integer, List<int[]>> map = new HashMap<>();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            List<int[]> shortCut = map.getOrDefault(end, new ArrayList<>());
            shortCut.add(new int[]{start, dist});
            map.put(end, shortCut);

        }

        dp[0] = 0;
        for (int i = 1; i <= d; i++) {
            int minDist = dp[i - 1] + 1;

            if (map.containsKey(i)) {
                for (int[] shortCut : map.get(i)) {
                    minDist = Math.min(minDist, dp[shortCut[0]] + shortCut[1]);
                }
            }

            dp[i] = minDist;
        }

        System.out.println(dp[d]);

    }

}