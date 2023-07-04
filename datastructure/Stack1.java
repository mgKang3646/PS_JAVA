package org.example.datastructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//BOJ1874 스택수열 ( 자료구조 )
public class Stack1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = true;

        int pointer = 1;
        for(int i=1;i<=n;i++){
            int k = Integer.parseInt(br.readLine());
            while(pointer <= k ){
                stack.push(pointer++);
                sb.append("+").append("\n");
            }
            if(stack.peek() == k){
                stack.pop();
                sb.append("-").append("\n");
            }else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}
