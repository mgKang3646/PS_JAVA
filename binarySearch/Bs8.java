package org.example.binarySearch;

import java.io.*;
import java.util.*;

//BOJ1205 등수 구하기
public class Bs8 {

    // 내림차순으로 정렬된 리스트에서 새로운 점수가 몇 번째 자리에 위치하는지 찾기 ( 이분탐색 )

    // 극빈값으로 반례 생성 시도 X
    // 이분탐색에 대한 지식 부족

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        // 입력된 점수가 없는 경우
        if(n==0) {
            System.out.println(1);
            return;
        }

        // 입력된 점수가 있는 경우
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 이분탐색으로 새로운 점수가 위치할 인덱스 구하기
        int index = binarySearch(0,arr.length-1,arr,newScore);

        // 랭크 설정하기
        int[] arrRank = new int[n];
        int rank = 1;
        int rankSize = 0;
        int ans = -1;

        for(int i=0;i<n;i++){
            // 더이상 점수를 추가할 수 없는 경우
            if(rankSize >= size) break;

            if(i==index){
                // index의 점수가 새로운 점수보다 작은 경우 ( 교체 )
                if(newScore > arr[index]) ans = rank;

                // index의 점수가 새로운 점수보다 같거나 작은 경우
                else if(rankSize+1 < size) { // 사이즈 여유가 있을때만 가능
                    if(newScore == arr[index]) { // 점수가 같으면 index 점수의 랭크와 동일
                        setRank(i,arr,arrRank,rank);
                        ans = arrRank[i];
                    }
                    else ans = rank+1; // 점수가 다르면 랭크 +1 올리기
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

    // 이분탐색
    public static int binarySearch(int left, int right, int[] arr, int target){

        // 탐색 종료 조건
        if( left > right ) {
            // right가 배열의 범위를 벗어나는 경우
            if(right >= arr.length) right = arr.length-1;
            if(right < 0) right = 0;
            return right;
        }

        int mid = (left+right)/2;
        if(arr[mid] < target) return binarySearch(left,mid-1,arr,target);
        else return binarySearch(mid+1,right,arr,target);
    }
}
