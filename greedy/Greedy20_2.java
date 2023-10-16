package org.example.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Math.*;

//BOJ1459 걷기
public class Greedy20_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long direct = Integer.parseInt(st.nextToken());
        long cross = Integer.parseInt(st.nextToken());

        long cost1, cost2, cost3;

        // 수평으로 이동하는 경우
        cost1 = ( x + y ) * direct;

        // 대각선으로 이동하는 경우
        // 짝수인 경우, 대각선으로만 이동가능
        if((x+y) % 2 == 0) cost2 = max(x,y) * cross;
        // 홀수인 경우, 대각선 이동후 수평이동 한칸
        else cost2 = ((max(x,y)-1)*cross) + direct;

        // 대각선 + 수평 콜라보로 이동하는 경우 ( 대각선으로 최대한 이동 )
        cost3 = min(x,y)*cross + abs(x-y)*direct;

        long ans = min(cost1, min(cost2,cost3));
        System.out.println(ans);

    }
}
