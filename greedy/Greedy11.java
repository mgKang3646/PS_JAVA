package org.example.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOJ1781 컵라면 ( 이전 풀이 )
public class Greedy11 {

    public static class Problem{
        int deadLine;
        int reward;

        public Problem(int deadLine,int reward){
            this.deadLine = deadLine;
            this.reward = reward;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Problem[] problems = new Problem[n];

        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int deadLine = Integer.parseInt(st.nextToken());
            int reward = Integer.parseInt(st.nextToken());

            problems[i] = new Problem(deadLine,reward);
        }

        Arrays.sort(problems,(p1,p2) -> Math.toIntExact(p2.reward - p1.reward));
        Arrays.sort(problems,(p1,p2)-> p1.deadLine - p2.deadLine);

        long[] day = new long[n+1];
        int currDay = 1;
        int pointer = 0;
        int ans = 0;

        while(pointer < n){
            if(problems[pointer].deadLine == 0) ans += problems[pointer].reward;
            if(problems[pointer].deadLine >= currDay) {
                day[currDay] += problems[pointer].reward;
                ans += problems[pointer].reward;
                currDay++;
            }else{
                for(int i=1;i<currDay;i++){
                    if(day[i] < problems[pointer].reward){
                        ans -= day[i];
                        day[i] = problems[pointer].reward;
                        ans += day[i];
                        break;
                    }
                }
            }

            pointer++;

        }

        System.out.println(ans);

    }
}
