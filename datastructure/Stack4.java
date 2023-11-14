package org.example.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//BOJ2493 탑
public class Stack4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=n;i++){
            while(!stack.isEmpty()){
                int top = stack.peek();
                if( arr[i] > arr[top] ) stack.pop();
                else {
                    stack.push(i);
                    sb.append(top).append(" ");
                    break;
                }
            }

            if(stack.isEmpty()){
                sb.append(0).append(" ");
                stack.push(i);
            }
        }

        System.out.println(sb.toString());
    }
}
