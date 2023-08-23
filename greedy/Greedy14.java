package org.example.greedy;

import java.util.Scanner;

//BOJ5585 거스름돈
public class Greedy14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int change = 1000 - n;
        int ans = 0;

        if(change >= 500){
            ans += change/500;
            change = change%500;
        }

        if(change >= 100){
            ans += change/100;
            change = change%100;
        }

        if(change >= 50){
            ans += change/50;
            change = change%50;
        }

        if(change >= 10){
            ans += change/10;
            change = change%10;
        }
        if(change >= 5){
            ans += change/5;
            change = change%5;
        }

        ans += change;
        System.out.println(ans);


    }
}
