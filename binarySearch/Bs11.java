package org.example.binarySearch;

import java.io.*;
import java.util.*;

//BOJ2343 기타레슨
public class Bs11 {

    static int n,m;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        int minValue = 1;
        int maxValue = 0;

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());

            minValue = Math.max(minValue,arr[i]);
            maxValue += arr[i];
        }

        int ans = binarySearch(minValue,maxValue);
        System.out.println(ans);

    }

    public static int binarySearch(int left, int right){

        if(left > right) return left;

        int mid = (left+right)/2;

        int sum = 0;
        int count = 1;
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(sum > mid){
                sum = arr[i];
                count++;
            }
        }

        if(count > m) return binarySearch(mid+1,right);
        else return binarySearch(left,mid-1);
    }
}