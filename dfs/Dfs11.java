package org.example.dfs;
import java.io.*;
import java.util.*;

//BOJ2961 도영이가 만든 맛있는 음식
public class Dfs11 {

    static int n;
    static long ans = Long.MAX_VALUE;
    static Gradient[] gradients;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        gradients = new Gradient[n];

        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());

            gradients[i] = new Gradient(sour,bitter);
        }

        dfs(0,1,0);

        System.out.println(ans);

    }

    public static void dfs(int index, long sour, long bitter){
        if(index == n){
            if(bitter != 0) ans = Math.min(ans,Math.abs(bitter-sour));
            return;
        }

        // 재료가 들어간 경우
        dfs(index+1,sour*gradients[index].sour,bitter+gradients[index].bitter);

        // 재료가 들어가지 않은 경우
        dfs(index+1,sour,bitter);
    }

    public static class Gradient{
        int sour;
        int bitter;

        public Gradient(int sour, int bitter){
            this.sour = sour;
            this.bitter = bitter;
        }
    }
}