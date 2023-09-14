package org.example.twopointer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOJ2230 수 고르기
public class Tp3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int pointer1 = 0;
        int pointer2 = 0;
        int ans = 2000000000;

        while(true){
            int diff = arr[pointer2] - arr[pointer1];

            if(diff == m){
                ans = diff;
                break;
            }
            else if(diff>m){
                ans = Math.min(ans,diff);
                pointer1++;
            }
            else if(diff<m){
                if(pointer2 == n-1) break;
                pointer2++;
            }
            else{ //diff == 0
                if(pointer2 == n-1) break;
                pointer2++;
            }
        }

        System.out.println(ans);

    }
}
