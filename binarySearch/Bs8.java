package org.example.binarySearch;

import java.io.*;
import java.util.*;

//BOJ1205 등수 구하기
public class Bs8 {

    // 내림차순으로 정렬된 리스트에서 새로운 점수가 몇 번째 자리에 위치하는지 찾기 ( 이분탐색 )

    // 극빈값으로 반례 생성 능력 부족
    // 이분탐색에 대한 지식 부족

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        if(n==0) {
            System.out.println(1);
            return;
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int index = binarySearch(0,arr.length-1,arr,newScore);

        int[] arrRank = new int[n];
        int rank = 1;
        int rankSize = 0;
        int ans = -1;

        for(int i=0;i<n;i++){
            if(rankSize >= size) break;

            if(i==index){
                if(newScore > arr[index]) ans = rank;
                else if(rankSize+1 < size) {
                    if(newScore == arr[index]) {
                        setRank(i,arr,arrRank,rank);
                        ans = arrRank[i];
                    }
                    else ans = rank+1;
                }
                break;
            }

            setRank(i,arr,arrRank,rank);
            rank++;
            rankSize++;

        }

        System.out.println(ans);

    }

    public static void setRank(int i, int[] arr, int[] arrRank, int rank){
        if(i==0) arrRank[i] = rank;
        else {
            if (arr[i] == arr[i-1]) arrRank[i] = arrRank[i-1];
            else arrRank[i] = rank;
        }
    }

    public static int binarySearch(int left, int right, int[] arr, int target){

        if( left > right ) {
            if(right >= arr.length) right = arr.length-1;
            if(right < 0) right = 0;
            return right;
        }

        int mid = (left+right)/2;

        if(arr[mid] < target) return binarySearch(left,mid-1,arr,target);
        else return binarySearch(mid+1,right,arr,target);
    }
}
