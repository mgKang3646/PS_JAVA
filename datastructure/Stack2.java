package org.example.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.IntStream;

//BOJ1406 에디터 STACK
public class Stack2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        IntStream str = br.readLine().chars(); //문자열을 스트림 객체로 변환하기
        str.forEach( ch -> stack1.push((char)ch));

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String[] op = br.readLine().split(" ");

            if(op[0].equals("L")){
                if(!stack1.empty()) stack2.push(stack1.pop());
            }else if(op[0].equals("D")){
                if(!stack2.empty()) stack1.push(stack2.pop());
            }else if (op[0].equals("B")){
                if(!stack1.empty()) stack1.pop();
            }else {
                stack1.push(op[1].charAt(0));
            }
        }

        while(!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        stack1.forEach(sb::append); //STACK의 0부처 차례대로 반복문을 돌린다.
        System.out.println(sb);
    }
}
