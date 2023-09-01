package org.example.string;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//BOJ17609 회문
public class String4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            String str = br.readLine();
            System.out.println(process(str,0,str.length()-1,0));
        }
    }

    public static int process(String str, int left, int right, int count){
        if(count == 2) return 2;

        while( left < right ) {

            // 문자가 서로 다른 경우
            if (str.charAt(left) != str.charAt(right)) {
                int leftMove = process(str,left+1,right,count+1); // 왼쪽 이동후 비교로직 재귀호출
                int rightMove = process(str,left,right-1,count+1); // 오른쪽 이동후 비교로직 재귀호출
                return Math.min(leftMove,rightMove); // 최소 비교횟수 return
            }

            left++;
            right--;
        }
        return count;
    }
}
