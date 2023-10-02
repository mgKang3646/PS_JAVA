package org.example.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

//BOJ2467 용액
public class Tp4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int pointer1 = 0;
        int pointer2 = arr.length-1;

        int ans1 = pointer1;
        int ans2 = pointer2;
        int min = Integer.MAX_VALUE;

        while(pointer1 != pointer2){

            int sum = arr[pointer1] + arr[pointer2];

            if( abs(sum) <= min ){
                ans1 = pointer1;
                ans2 = pointer2;
                min = abs(sum);
            }

            if(sum > 0) pointer2--;
            else if(sum < 0 ) pointer1++;
            else{
                ans1 = pointer1;
                ans2 = pointer2;
                break;
            }
        }

        System.out.println( arr[ans1] + " " + arr[ans2]);

    }
}
