package org.example.sweeping;


import java.io.*;
import java.util.*;

//BOJ2170 선긋기
public class Sweeping1 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] lines;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        int start = lines[0][0];
        int end = lines[0][1];
        int ans = 0;

        for (int[] line : lines) {
            int s = line[0];
            int e = line[1];

            if( s <= end && e <= end ) continue;
            else if ( s <= end && end < e) {
                end = e;
            }
            else if ( end < s){
                ans += end - start;
                start = s;
                end = e;
            }
        }
        ans += end - start;
        System.out.println(ans);
    }


    public static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        lines = new int[n][2];
        for(int i =0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lines[i][0] = start;
            lines[i][1] = end;
        }
        Arrays.sort(lines,(line1, line2)->Integer.compare(line1[0],line2[0]));
    }
}
