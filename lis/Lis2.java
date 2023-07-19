package org.example.lis;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//BOJ12015 가장 긴 증가하는 부분 수열 2
public class Lis2 {

    static List<Integer> lis = new ArrayList<>();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis.add(0);
        for (int i=0; i < n; i++) {
            if (arr[i] > lis.get(lis.size()-1)) lis.add(arr[i]); // 끝값보다 크면 최장부분수열 끝에 추가하기
            else {
                int index = binarySearch(0,lis.size()-1,arr[i]); //끝값보다 작으면 이분탐색
                lis.set(index,arr[i]); // 촘촘하게 만들기
            }
        }

        System.out.println(lis.size()-1); // 처음에 추가했던 0 빼기 (-1)
    }

    // 이분탐색
    public static int binarySearch(int start, int end, int value){
        if(start <= end ) return end; //같거나 가장 가까운 큰수

        int mid = ( start + end )/2;
        if( lis.get(mid) >= value ) return binarySearch(start, mid, value);
        else return binarySearch(mid+1,end,value);

    }
}
