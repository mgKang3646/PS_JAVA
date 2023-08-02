package org.example.fenwicktree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//BOJ3653 영화 수집 ( Stack을 이용한 풀이, 선형탐색,  시간초과 발생 )
public class Ft1 {
    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] dvdNums = new int[m];
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();

            st = new StringTokenizer(br.readLine());

            for(int i=n;i>0;i--){
                stack1.push(i);
            }
            for(int i =0;i<m;i++){
                dvdNums[i] = Integer.parseInt(st.nextToken());
            }

            for (int dvdNum : dvdNums) {
                while(!stack1.empty()){
                    int value = stack1.pop();
                    if( value == dvdNum ) {
                        sb.append(stack2.size()+" ");
                        while(!stack2.empty()) stack1.push(stack2.pop());
                        stack1.push(value);
                        break;
                    }
                    else stack2.push(value);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
