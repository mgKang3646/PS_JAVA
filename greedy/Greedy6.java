package org.example.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//BOJ2875 대회 or 인턴
public class Greedy6 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int k = Integer.parseInt(str[2]);

        int t = 1;
        while (2 * t <= n && t <= m && (n + m) - 3 * t >= k) {
            t++;
        }

        System.out.println(t-1);
    }

}
