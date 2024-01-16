package org.example.implementation;

import java.io.*;
import java.util.*;

//BOJ18111 마인크래프트
public class Impl6 {

    private static int n,m;
    private static long b;
    private static int[][] matrix;


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());
        matrix = new int[n][m];

        // 최대높이, 최소높이
        int maxValue = 0;
        int minValue = Integer.MAX_VALUE;

        // 좌표별 높이 입력받기
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int value = Integer.parseInt(st.nextToken());
                maxValue = Math.max(maxValue, value);
                minValue = Math.min(minValue, value);

                matrix[i][j] = value;
            }
        }

        // 높이 범위 ( 최대 256 - 최소 0 ) 중 평탄화 작업에 걸리는 최소시간 구하기
        int minH = -1;
        int minTime = Integer.MAX_VALUE;

        for(int h = maxValue; h>=minValue;h--){

            int time = calculateTime(h); // 특정 높이를 평탄화 하는데 걸리는 시간 구하기

            if( time == -1 ) continue; // 블록이 부족하면 넘어가기

            // 최소시간 비교하기
            if(time < minTime || ((time==minTime)&&(h>minH)) ){
                minH = h;
                minTime = time;
            }
        }

        // 답출력
        System.out.println(minTime+" "+minH);
    }

    public static int calculateTime(int targetH){
        Long inventoryBlockCount = b;
        int stackBlockCount = 0;
        int removeBlockCount = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int currH = matrix[i][j];
                // 쌓아야 하는 블록 개수
                if( (targetH - currH) > 0 ){
                    stackBlockCount += targetH-currH;
                }
                // 제거해야 하는 블록 개수
                else if( (targetH - currH) < 0 ){
                    removeBlockCount += Math.abs(targetH - currH);
                }
            }
        }

        inventoryBlockCount += removeBlockCount; // 인벤토리에 존재하는 블록 개수

        if( inventoryBlockCount < stackBlockCount ) return -1; // 블록 개수가 부족하면 -1 return
        else return stackBlockCount + removeBlockCount*2; // 블록 개수가 맞으면 시간 계산 후 return

    }


}
