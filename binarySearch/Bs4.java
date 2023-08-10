package org.example.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOJ2110 공유기 설치
public class Bs4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] houses = new int[n];

        for(int i =0;i<n;i++){
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        int start = 1;
        int end = houses[n-1] - houses[0];
        while(start <= end){
            int mid = (start+end)/2;
            int count = getWifiCount(houses,mid);

            if(count >= c) start = mid+1;
            else end = mid-1;
        }

        System.out.println(end);
    }

    public static int getWifiCount(int[] houses, int length){
        int count = 0;
        int value = 0;
        for (int house : houses) {
            if( value == 0 || value <= house){
                value = house + length;
                count++;
            }
        }
        return count;
    }
}
