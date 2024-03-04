package org.example.slidingwindow;

import java.io.*;
import java.util.*;

//BOJ2531 회전초밥
public class Sw3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int c = Integer.parseInt(input[3]);

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int startLeftP = 0;
        int startRightP = k-1;

        HashMap<Integer,Integer> map = new HashMap<>();

        // 초기화
        for(int i=startLeftP;i<=startRightP;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }
            else{
                map.put(arr[i],1);
            }
        }

        int ans = map.size();
        if(!map.containsKey(c)) ans += 1;

        int leftP = startLeftP;
        int rightP = startRightP;

        do{

            // LeftP 제거
            if(map.get(arr[leftP]) == 1){
                map.remove(arr[leftP]);
            }else{
                map.put(arr[leftP],map.get(arr[leftP])-1);
            }

            leftP = moveIndex(leftP+1,n);
            rightP = moveIndex(rightP+1,n);

            // rightP 추가
            if(map.containsKey(arr[rightP])){
                map.put(arr[rightP],map.get(arr[rightP])+1);
            }
            else{
                map.put(arr[rightP],1);
            }

            int result = map.size();
            if(!map.containsKey(c)) result += 1;

            ans = Math.max(ans,result);

        }while(leftP != startLeftP || rightP != startRightP );

        System.out.println(ans);
    }

    public static int moveIndex(int idx, int length){
        return ( idx % length );
    }
}