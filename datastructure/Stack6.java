package org.example.datastructure;

import java.io.*;
import java.util.*;

// BOJ2075 N번째 큰 수

public class Stack6 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer>[] stacks = new Stack[n];

        for(int i=0;i<n;i++){
            stacks[i] = new Stack();
        }

        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                stacks[j].push(Integer.parseInt(st.nextToken()));
            }
        }

        int count = 0;
        int ans = 0;

        while(count < n){
            int maxValue = Integer.MAX_VALUE;
            int maxIndex = -1;

            for(int i=0;i<n;i++){
                if(stacks[i].isEmpty()) continue;
                if(maxValue == Integer.MAX_VALUE || stacks[i].peek() > maxValue ){
                    maxValue = stacks[i].peek();
                    maxIndex = i;
                }

            }

            ans = stacks[maxIndex].pop();
            count++;

        }

        System.out.println(ans);

    }
}