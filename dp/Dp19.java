package org.example.dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//BOJ9252 LCS2
public class Dp19 {

    public static char[] str1,str2;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();
        dp = new int[str1.length+1][str2.length+1];

        doLCS();

        System.out.println(dp[str1.length][str2.length]);
        System.out.println(getLCS(str1.length, str2.length));

    }

    private static void doLCS() {

        for(int p1=1;p1<=str1.length;p1++){
            for(int p2=1;p2<=str2.length;p2++){
                if(str1[p1-1] == str2[p2-1]){
                    dp[p1][p2] = dp[p1-1][p2-1] + 1;
                }
                else{
                    dp[p1][p2] = Math.max(dp[p1][p2-1],dp[p1-1][p2]);
                }
            }
        }
    }

    private static String getLCS(int length1, int length2) {
        StringBuilder sb = new StringBuilder();
        int i = length1;
        int j = length2;

        Stack<Character> stack = new Stack<>();

        while( i>0 && j > 0){

            if( dp[i][j] == dp[i-1][j] ){
                i--;
            }
            else if( dp[i][j] == dp[i][j-1]){
                j--;
            }else{
                stack.push(str1[i-1]);
                i--;
                j--;
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
