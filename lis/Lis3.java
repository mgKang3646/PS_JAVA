package org.example.lis;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//BOJ12738 가장 긴 증가하는 부분 수열3
public class Lis3 {

    static List<Integer> lis;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        lis = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis.add(arr[0]);

        for(int i=1;i<n;i++){

            int last = lis.get(lis.size()-1);

            if( last < arr[i] ) lis.add(arr[i]);
            else {
                int index = binarySearch(0, lis.size() - 1, arr[i]);
                lis.set(index,arr[i]);
            }
        }

        System.out.println(lis.size());
    }

    public static int binarySearch(int start, int end, int value){
        if( start == end ) return end;

        int mid = ( start + end )/2;

        if( lis.get(mid) >= value ) return binarySearch(start,mid,value);
        else return binarySearch(mid+1,end,value);
    }

}
