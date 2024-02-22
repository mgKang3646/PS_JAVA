package org.example.twopointer;

import java.io.*;
import java.util.*;


//BOJ20922 겹치는 건 싫어
public class Tp5 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int leftP = 0;
        int rightP = 0;
        int ans = 1;

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(arr[0],1);

        while(true){

            if( map.getOrDefault(arr[rightP],0) > k ){
                map.replace(arr[leftP],map.get(arr[leftP])-1);
                leftP += 1;
                continue;
            }

            ans = Math.max(ans, rightP - leftP + 1);

            rightP += 1;
            if(rightP == n) break;
            if(map.containsKey(arr[rightP])) map.replace(arr[rightP],map.get(arr[rightP])+1);
            else map.put(arr[rightP],1);

        }

        System.out.println(ans);


    }
}