package org.example.implementation;
import java.io.*;
import java.util.*;

//BOJ9017 크로스 컨트리
public class Impl4 {

    public static class Score{
        int score;
        int size;
        int spare;

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] member = new int[201];
            Score[] score = new Score[201];
            int[] arr = new int[n];

            for(int i=0;i<=200;i++){
                score[i] = new Score();
            }
            // 멤버체크
            for(int i=0;i<n;i++){
                int team = Integer.parseInt(st.nextToken());
                arr[i] = team;
                member[team]++;
            }

            // 점수합산
            int rank = 1;
            for(int i=0;i<n;i++){
                int team = arr[i];
                if(member[team] >= 6) {
                   if(score[team].size < 4) score[team].score += rank;
                   else if(score[team].size == 4) score[team].spare += rank;

                   score[team].size++;
                   rank++;
                }
            }

            // 1등 추출
            int ans = 0;

            for(int i=1;i<=200;i++){
                if(score[i].score == 0) continue;
                if(ans == 0){
                    ans = i;
                    continue;
                }

                if(score[i].score < score[ans].score) {
                    ans = i;
                }else if(score[i].score == score[ans].score){
                    if(score[i].spare < score[ans].spare){
                        ans = i;
                    }
                }
            }

            System.out.println(ans);

        }


    }
}
