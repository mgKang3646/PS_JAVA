package org.example.greedy;

import java.io.*;
import java.util.*;

//BOJ13305 주유소
public class Greedy21 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] distArr = new int[n];
        int[] gasCost = new int[n];
        long[] cityArr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<n;i++){
            distArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            gasCost[i] = Integer.parseInt(st.nextToken());
        }

        long minGasCost = gasCost[0];

        for(int i=1;i<n;i++){
            cityArr[i] = cityArr[i-1] + minGasCost*distArr[i];
            minGasCost = Math.min(minGasCost,gasCost[i]);
        }

        System.out.println(cityArr[n-1]);

    }
}
