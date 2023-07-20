package org.example.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//BOJ1541 잃어버린 괄호
public class Greedy3 {
    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean isPlus = true;

        int ans = 0;
        for (int i =0;i<str.length();i++) {
            String digit = "";

            if(Character.isDigit(str.charAt(i))){
                while(i < str.length() && Character.isDigit(str.charAt(i))){
                    digit += str.charAt(i);
                    i++;
                }
                if(isPlus) ans += Integer.parseInt(digit);
                else ans -= Integer.parseInt(digit);
            }
            if( i < str.length() && str.charAt(i) == '-') isPlus = false;
        }
        System.out.println(ans);
    }
}
