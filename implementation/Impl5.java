package org.example.implementation;

import java.io.*;
import java.util.*;

//BOJ17266 어두운 굴다리
public class Impl5 {

    public static void main(String[] arg) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxDist = 0;
        int before = Integer.parseInt(st.nextToken());

        int frontH = before;

        for(int i=1;i<size;i++){
            int curr = Integer.parseInt(st.nextToken());
            int dist = curr-before;
            maxDist = Math.max(maxDist,dist);
            before = curr;
        }

        int midH = (maxDist%2==0)? maxDist/2 : maxDist/2+1;
        int lastH = n-before;

        int ans = Math.max(frontH,Math.max(midH,lastH));

        System.out.println(ans);


    }
}
