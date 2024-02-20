package org.example.bitmasking;
import java.io.*;

public class BitMasking2{


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int ans = 0;

        while(Integer.bitCount(n) > k){

            ans += n & (-n);
            n += n & (-n);

        }

        System.out.println(ans);

    }
}