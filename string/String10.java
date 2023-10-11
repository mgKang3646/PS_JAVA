package org.example.string;


import java.util.Scanner;

//BOJ9086 문자열
public class String10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String str;
        for(int i=0;i<n;i++){
            str = sc.next();
            System.out.println(str.charAt(0)+""+str.charAt(str.length()-1));
        }
    }
}
