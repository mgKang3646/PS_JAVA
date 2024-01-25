package org.example.greedy;

import java.io.*;
import java.util.*;

//BOJ19941 햄버거분배
public class Greedy22 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();
        boolean[] isEat = new boolean[n];
        int ans = 0;

        for(int i=0;i<n;i++){
            if(arr[i]=='H') continue;

            int leftP = ( i - k < 0 )? 0 : i-k;
            int rightP = ( i + k >= arr.length )? arr.length-1: i+k;

            for(int j=leftP;j<=rightP;j++){
                if(arr[j]=='P') continue;
                if(isEat[j]) continue;

                ans++;
                isEat[j] = true;
                break;
            }

        }

        System.out.println(ans);

    }
}
