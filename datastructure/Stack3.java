package org.example.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Stack3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1;i<=n;i++){
            queue.add(i);
        }

        int count = 1;
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            if( count == k ){
                result.add(queue.remove());
                count = 1;
                continue;
            }
            queue.add(queue.remove());
            count++;
        }

        sb.append("<");
        for (int i = 0; i<result.size();i++) {
            if( i == result.size()-1) {
                sb.append(result.get(i)).append(">");
            }else{
                sb.append(result.get(i)).append(", ");
            }
        }
        System.out.println(sb);
    }
}
