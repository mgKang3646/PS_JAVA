package org.example.prefixsum;

import java.io.*;
import java.util.*;

//BOJ21921 블로그
public class PrefixSum4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] prefixSum = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        prefixSum[0] = arr[0];

        for(int i=1;i<n;i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        int index = 0;
        int ans = 0;
        int result = 0;
        int count = 1;
        while(index+x-1 < n){

            if( index == 0 ) result = prefixSum[index+x-1];
            else result = prefixSum[index+x-1] - prefixSum[index-1];

            if( ans == result ) count++;
            else if( ans < result ){
                ans = result;
                count = 1;
            }

            index++;

        }

        if(ans==0) System.out.println("SAD");
        else{
            System.out.println(ans);
            System.out.println(count);
        }
    }
}
