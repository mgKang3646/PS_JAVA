package org.example.dp;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


//BOJ2655 가장높은탑쌓기
public class Dp12 {
    public static class Block{
        int num;
        int width;
        int height;
        int weight;

        public Block(int num, int width, int height, int weight) {
            this.num = num;
            this.width = width;
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Block[] blocks = new Block[n]; // 블록 리스트
        List<Block>[] dp = new List[n]; // DP 테이블
        int[] heights = new int[n]; // 높이 테이블

        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            blocks[i] = new Block(i+1,width,height,weight);
            dp[i] = new ArrayList<>();
        }

        Arrays.sort(blocks,(b1,b2)->b1.width - b2.width); // 밑면의 넓이 오름차순 정렬

        // DP 테이블 초기데이터 저장
        dp[0].add(blocks[0]);
        heights[0] = blocks[0].height;
        int maxHeightIndex = 0;

        // DP 테이블 생성 시작
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){ // 이전 블록의 경우와 비교하여 DP 테이블 완성하기
                if( blocks[i].weight > blocks[j].weight ){
                    if( heights[i] <  heights[j] + blocks[i].height ) {
                        dp[i] = dp[j].stream().collect(Collectors.toList());
                        dp[i].add(blocks[i]);
                        heights[i] = heights[j] + blocks[i].height;
                    }
                }
            }

            // 조건을 찾지 못한 경우
            if(dp[i].size() == 0){
                dp[i].add(blocks[i]);
                heights[i] = blocks[i].height;
            }

            maxHeightIndex = ( heights[maxHeightIndex] > heights[i] ) ? maxHeightIndex : i;
        }


        //출력
        sb.append(dp[maxHeightIndex].size()).append("\n");

        for (Block block : dp[maxHeightIndex]) {
            sb.append(block.num).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
