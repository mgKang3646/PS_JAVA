package org.example.binarySearch;

import java.io.*;

//BOJ1072 게임
public class Bs10 {

    static long X,Y;
    static long avg;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        X = Integer.parseInt(input[0]);
        Y = Integer.parseInt(input[1]);
        avg = (Y*100)/X;

        if(avg >= 99) System.out.println(-1);
        else System.out.println(binarySearch(0,X));


    }


    public static long binarySearch(long left, long right){
        if(left > right) return left;


        long mid = (left + right)/2;
        long value = ((Y+mid)*100)/(X+mid);

        if( value - avg >= 1) return binarySearch(left,mid-1);
        else return binarySearch(mid+1,right);

    }
}