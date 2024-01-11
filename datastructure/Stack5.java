package org.example.datastructure;

import java.io.*;
import java.util.*;

//BOJ10431 줄세우기
public class Stack5 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[20];


        StringTokenizer st ;
        while(t-- >0 ){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Stack<Integer> stack = new Stack();
            Stack<Integer> tmpStack = new Stack();

            for(int i=0;i<20;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int ans = 0;
            for( int value : arr){
                if(stack.isEmpty()){
                    stack.push(value);
                }else{
                    while(!stack.isEmpty()&&stack.peek()>value){
                        tmpStack.push(stack.pop());
                    }

                    stack.push(value);
                    ans += tmpStack.size();

                    while(!tmpStack.isEmpty()){
                        stack.push(tmpStack.pop());
                    }
                }
            }
            sb.append(n).append(" ").append(ans).append("\n");

        }

        System.out.println(sb.toString());



    }

}
