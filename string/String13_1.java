package org.example.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


//BOJ20437 문자열 게임 ( 시간초과 발생 )
public class String13_1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int[] alphabets = new int['z'-'a'+1];
            Arrays.fill(alphabets,-1);
            String str = br.readLine();
            int k  = Integer.parseInt(br.readLine());
            int minStr = Integer.MAX_VALUE;
            int maxStr = 0;


            for(int i=0;i<str.length();i++){
                char value = str.charAt(i);
                int idx = value - 'a';
                if(alphabets[idx] != -1){
                    int start = alphabets[idx];
                    int end = i;

                    String subStr = getSubStr(str,start,end,value,k);
                    if(subStr != null){
                        if(minStr > subStr.length()){
                            minStr = subStr.length();
                        }
                        if(maxStr < subStr.length()){
                            maxStr = subStr.length();
                        }
                    }
                }else{
                    alphabets[idx] = i;
                }
            }

            if(minStr != Integer.MAX_VALUE) System.out.println(minStr+" "+maxStr);
            else System.out.println(-1);

        }
    }

    static public String getSubStr(String str, int start, int end, char target, int k){
        while(start<str.length()){
            String subStr = str.substring(start, end + 1);
            long count = subStr.chars().filter(c -> c == target).count();

            if( count == k ) return subStr;
            if( count < k ) return null;
            if( count > k ){
                int i = start+1;
                while(i<str.length()){
                    if(i != str.length()-1 && str.charAt(i) == target ){
                        start = i;
                        break;
                    }
                    i++;
                }
            }
        }
        return null;
    }
}
