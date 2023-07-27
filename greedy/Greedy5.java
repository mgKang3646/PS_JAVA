package org.example.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//BOJ1744 수묶기
public class Greedy5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();

        for(int i=0;i<n;i++){
            int value = Integer.parseInt(br.readLine());
            if(value > 0) positives.add(value);
            else negatives.add(value);
        }

        Collections.sort(positives,Collections.reverseOrder()); //양수 내림차순
        Collections.sort(negatives); //음수 오름차순

        int ans = 0;

        // 양수인 경우
        int i =0;
        while(i < positives.size()){
            // 곱하기 연산의 경우
            if( i+1 < positives.size() && positives.get(i) !=1 && positives.get(i+1) != 1){
                ans += positives.get(i++)*positives.get(i++);
            }
            // 더하기 연산의 경우
            else{
                ans += positives.get(i++);
            }
        }

        // 음수인 경우
        i =0;
        while(i < negatives.size()){
            //곱하기 연산의 경우
            if(i+1< negatives.size()) ans += negatives.get(i++)*negatives.get(i++);

            // 더하기 연산의 경우
            else ans += negatives.get(i++);
        }

        System.out.println(ans);
    }
}
