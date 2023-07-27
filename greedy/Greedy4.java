package org.example.greedy;
// 1. 음수는 1이상의 양수와 곱하면 오히려 총합이 작아진다.
// 2. 0은 양수와 곱하면 작아지게 만들지만 음수를 사라지게 한다.
// 3. 1은 양수와 곱하면 1이 사라지는 꼴이 된다.
// 4. 음수와 음수의 곱, 양수와 양수의 곱이 가장 커지려면 절대값이 가장 큰 값끼리 곱해야 한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

//BOJ1744 수묶기
public class Greedy4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> positives = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negatives = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            int value = Integer.parseInt(br.readLine());
            if(value > 0 ) positives.add(value);
            else  negatives.add(value);
        }

        int ans = 0;
        int multiValue = 0;
        while(!positives.isEmpty()){
            Integer item = positives.remove();
            if( item == 1 ) {
                ans += 1;
            }else {
                if (multiValue == 0) multiValue = item;
                else {
                    ans += multiValue * item;
                    multiValue = 0;
                }
            }
        }
        ans += multiValue;

        multiValue = 0;
        while(!negatives.isEmpty()){
            Integer item = negatives.remove();
            if(multiValue == 0) multiValue = item;
            else {
                ans += multiValue*item;
                multiValue = 0;
            }
        }
        ans += multiValue;

        System.out.println(ans);
    }
}
