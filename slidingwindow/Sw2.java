package org.example.slidingwindow;


import java.io.*;
import java.util.*;

//BOJ21921 블로그
public class Sw2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int window = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int leftP = 1;
        int count = 1;
        int ans = 0;
        int beforeSum = 0;

        for(int i=leftP;i<leftP+window;i++){
            ans += arr[i];
        }

        beforeSum = ans;
        leftP += 1;

        while( leftP+window-1 < arr.length ){

            int sum = beforeSum;
            sum -= arr[leftP-1];
            sum += arr[leftP+window-1];

            if (ans == sum) {
                count++;
            }else if ( ans < sum ){
                ans = sum;
                count = 1;
            }

            leftP += 1;
            beforeSum = sum;
        }


        if(ans == 0) System.out.println("SAD");
        else {
            System.out.println(ans);
            System.out.println(count);
        }

    }
}
