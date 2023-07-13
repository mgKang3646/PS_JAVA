package org.example.twopointer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.*;

//BOJ2470 두 용액
public class TwoPointer1 {
    static StringTokenizer st;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i =0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
    }

    public static void solution(){
        int leftP = 0;
        int rightP = arr.length-1;

        int ansLeft = 0;
        int ansRight = 0;
        int pivot = Integer.MAX_VALUE;

        while( leftP < rightP ) {
            int sum = arr[rightP] + arr[leftP];

            if(pivot > abs(sum)){
                pivot = abs(sum);
                ansLeft = arr[leftP];
                ansRight = arr[rightP];
            }

            if(sum>0) rightP--;
            else leftP++;
        }

        System.out.println(ansLeft + " "+ ansRight);
    }

}
