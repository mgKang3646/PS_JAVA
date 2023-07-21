package org.example.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

//BOJ2805 나무 자르기
public class Bs2 {

    static int[] woods;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        woods = new int[n];

        int maxHigh = 0;
        for(int i =0;i<n;i++){
            woods[i] = Integer.parseInt(st.nextToken());
            maxHigh = max(maxHigh,woods[i]);
        }

        int left = 1;
        int right = maxHigh;

        while(left <= right) {
            int mid = (left+right)/2;
            long remain = getWoodRemain(mid);
            if ( remain > m) left = mid+1;
            else if(remain < m ) right = mid-1;
            else{
                System.out.println(mid);
                return;
            }
        }
        System.out.println(right);
    }

    public static long getWoodRemain(int mid){
        long remain = 0;
        for (int wood : woods) {
            if( wood > mid ) remain += wood-mid;
        }
        return remain;
    }
}
