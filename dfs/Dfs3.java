package org.example.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

//BOJ18511 큰 수 구성하기
public class Dfs3 {
    static int[] nums;
    static int maxValue;
    static int k;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        nums = new int[3];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);
        System.out.println(maxValue);

    }

    public static void dfs(int value,int depth){

        if( depth == 8 ) return;
        value *= 10;

        for(int i=0;i<k;i++){
            int tmp = value + nums[i];
            if(tmp > n) continue;
            maxValue = max(maxValue,tmp);
            dfs(tmp,depth+1);
        }
    }
}
