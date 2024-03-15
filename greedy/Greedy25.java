package org.example.greedy;

import java.io.*;
import java.util.*;

//BOJ2138 전구와 스위치
public class Greedy25 {

    static char[] light;
    static char[] target;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        light = new char[n];
        target = new char[n];

        light = br.readLine().toCharArray();
        target = br.readLine().toCharArray();

        // 첫 번째 버튼을 누르지 않은 경우
        int ans1 = doPressButton(Arrays.copyOf(light,light.length),0);

        // 첫 번째 버튼을 누른 경우
        light[0] = changeLight(light[0]);
        light[1] = changeLight(light[1]);

        int ans2 = doPressButton(Arrays.copyOf(light,light.length),1);

        if(ans1==Integer.MAX_VALUE && ans2 == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(Math.min(ans1,ans2));


    }

    public static int doPressButton(char[] lightArr, int pressCount){
        for(int i=1;i<n;i++){
            if(lightArr[i-1] != target[i-1]) {
                pressCount++;
                lightArr[i-1] = changeLight(lightArr[i-1]);
                lightArr[i] = changeLight(lightArr[i]);
                if( i+1 < n ) lightArr[i+1] = changeLight(lightArr[i+1]);
            }
        }

        if(lightArr[n-1] == target[n-1]) return pressCount;
        else return Integer.MAX_VALUE;
    }

    public static char changeLight(char ch){
        return ( ch == '0' )? '1' : '0' ;
    }
}