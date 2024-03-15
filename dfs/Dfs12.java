package org.example.dfs;

import java.io.*;
import java.util.*;


//BOJ2138 전구와스위치

public class Dfs12 {

    static int[] arr;
    static int n;
    static HashSet<Integer> ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=n;i>0;i--){
            if(dfs(1,new HashSet<>(),i)){
                for(int value : ans){
                    pq.add(value);
                }
                break;
            }
        }

        if(ans == null ) System.out.println(0);
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(ans.size()).append("\n");
            while(!pq.isEmpty()){
                sb.append(pq.poll()).append("\n");
            }
            System.out.println(sb.toString());
        }


    }

    public static boolean dfs(int index,HashSet<Integer> hashSet, int maxSize){
        if(hashSet.size() == maxSize ){
            HashSet<Integer> tmpSet = new HashSet<>();

            for(int idx: hashSet){
                tmpSet.add(arr[idx]);
                if(!hashSet.contains(arr[idx])){
                    return false;
                }
            }


            if(tmpSet.size() == hashSet.size()) {
                ans = hashSet;
                return true;
            }

            else return false;
        }

        for(int i=index;i<=n;i++){
            if(!hashSet.contains(i)){
                hashSet.add(i);
                if(dfs(index+1,hashSet,maxSize)) return true;
                hashSet.remove(i);
            }
        }

        return false;

    }
}