package org.example.binarySearch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOJ1920 수찾기
public class Bs5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] target = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            target[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(target);

        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<m;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int value : arr) {
            int index = Arrays.binarySearch(target,value);

            if(index < 0 ){
                System.out.println(0);
            }else{
                System.out.println(1);
            }
        }
    }
}
