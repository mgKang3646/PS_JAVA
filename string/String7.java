package org.example.string;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//BOJ2204 도비의 난독증 테스트
public class String7 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;

            String[] arr = new String[n];

            for(int i=0;i<n;i++){
                arr[i] = br.readLine();
            }

            String ans = arr[0];

            for(int i=1;i<n;i++){
                ans = compare(ans, arr[i]);
            }

            System.out.println(ans);
        }
    }

    public static String compare(String str1, String str2){
        int value = str1.compareToIgnoreCase(str2);
        if(value < 0) return str1;
        else return str2;
    }
}
