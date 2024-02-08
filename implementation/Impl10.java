package org.example.implementation;

import java.io.*;
import java.util.*;

//BOJ2034 창고다각형
public class Impl10 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            arr[i][0] = x;
            arr[i][1] = h;

        }

        Arrays.sort(arr,(a1,a2) -> a1[0] - a2[0]);

        int maxH = 0;
        int index = 0;
        for(int i=0;i<n;i++){
            if( arr[i][1] > maxH ){
                maxH = arr[i][1];
                index = i;
            }
        }

        int sum = 0;
        int currX = arr[0][0];
        int currH = arr[0][1];

        // 좌측 면적 계산
        for(int i=1;i<=index;i++){

            if( i==index ){
                sum += ( arr[i][0] - currX ) * currH;
                break;
            }

            if( arr[i][1] > currH ){
                sum += ( arr[i][0] - currX ) * currH;
                currH = arr[i][1];
                currX = arr[i][0];
            }
        }

        // 우측 면적 계산
        currX = arr[arr.length-1][0]+1;
        currH = arr[arr.length-1][1];

        for(int i=arr.length-2;i>=index;i--){

            if( i == index ){
                sum += ( currX - ( arr[i][0]+1 ) ) * currH;
                break;
            }

            if( arr[i][1] > currH ){
                sum += ( currX - ( arr[i][0]+1 ) ) * currH;
                currH = arr[i][1];
                currX = arr[i][0] + 1;
            }
        }

        // 가장 큰 기둥 면적 더하기
        sum += arr[index][1];

        //출력
        System.out.println(sum);


    }
}