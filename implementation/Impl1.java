package org.example.implementation;

import java.io.*;


//BOJ20125 쿠키의 신체측정
public class Impl1 {

    // 머리좌표 : 최초 *이 등장하는 곳
    // 심장좌표 : 머리좌표 x , 머리좌표 y+1
    // 왼쪽팔길이 : 머리좌표 y-2 행에서 심장 * - 최초 *
    // 오름팔길이 : 머리좌표 y-2 행에서 마지막 * - 심장*
    // 허리길이 : 머리좌표 x 열에서 마지막 *행 - 심장* 행

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        char[][] cookie = new char[n+1][n+1];


        for(int i=1;i<n+1;i++){
            char[] arr =  br.readLine().toCharArray();
            for(int j=1;j<n+1;j++){
                cookie[i][j] = arr[j-1];
            }
        }

        int headX = 0;
        int headY = 0;

        // 1. 머리 찾기
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(cookie[i][j]=='*'){
                    headX = j;
                    headY = i;
                }
            }
            if(headY!=0) break;
        }

        // 2. 심장 찾기
        int heartX = headX;
        int heartY = headY+1;

        sb.append(heartY).append(" ").append(heartX).append("\n");


        // 3. 왼팔, 오른팔 길이 구하기
        int currX = 0;
        int startX = 0;
        for(int i=1;i<n+1;i++){
            if(cookie[heartY][i]=='*'){
                if(currX==0) startX = i;
                currX = i;
            }
        }

        int leftArmLength = heartX - startX;
        int rightArmLength = currX - heartX;

        sb.append(leftArmLength).append(" ").append(rightArmLength).append(" ");

        // 4. 허리길이 구하기

        int waistY = 0;
        for(int i=1;i<n+1;i++){
            if(cookie[i][heartX]=='*'){
                waistY=i;
            }
        }

        int waistLength = waistY - heartY;

        sb.append(waistLength).append(" ");

        // 왼다리 길이 구하기

        int leftLegY = 0;
        for(int i = waistY+1;i<n+1;i++){
            if(cookie[i][heartX-1]=='*'){
                leftLegY=i;
            }
        }

        int leftLegLength = leftLegY - waistY;

        // 오른다리 길이 구하기
        int rightLegY = 0;
        for(int i = waistY+1;i<n+1;i++){
            if(cookie[i][heartX+1]=='*'){
                rightLegY=i;
            }
        }

        int rightLegLength = rightLegY-waistY;

        sb.append(leftLegLength).append(" ").append(rightLegLength);
        System.out.println(sb.toString());



    }
}
