package org.example.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class PrefixSum1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        int[] sum = new int[n+1];

        arr[1] = Integer.parseInt(st2.nextToken());
        sum[0] = 0;
        sum[1] = arr[1];

        int i = 2;
        while(st2.hasMoreTokens()){
            arr[i] = Integer.parseInt(st2.nextToken());
            sum[i] = sum[i-1] + arr[i];
            i++;
        }

        while(m-- > 0){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st3.nextToken());
            int b = Integer.parseInt(st3.nextToken());
            System.out.println(sum[b]-sum[a-1]);
        }
    }
}
