package org.example.lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//BOJ2352 반도체 설계
public class Lis1 {

    static List<Integer> lines = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        lines.add(Integer.parseInt(st.nextToken()));

        for(int i=1;i<n;i++){
            int value = Integer.parseInt(st.nextToken());
            if( value > lines.get(lines.size()-1)) lines.add(value);
            else {
                int index = binarySearch(0, lines.size()-1, value);
                lines.set(index,value);
            }
        }

        System.out.println(lines.size());
    }

    public static int binarySearch(int start, int end, int value){
        if( start >= end ) return end;

        int mid = (start+end)/2;

        if (lines.get(mid) < value) return binarySearch(mid+1,end,value);
        else return binarySearch(start,mid,value);
    }
}