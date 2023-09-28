package org.example.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ10159 저울
public class Floyd3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] floyd = new int[n + 1][n + 1];

        // floyd 자료구조 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==j) floyd[i][j] = 1;
            }
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            // 양방향 관계
            floyd[num1][num2] = 1;  // num1 > num2(num1이 크다)
            floyd[num2][num1] = -1; // num2 < num1(num2가 작다)

        }

        for (int mid = 1; mid <= n; mid++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {

                    // start > mid 이고 mid > end 인 경우
                    if (floyd[start][mid] == 1 && floyd[mid][end] == 1) {
                        floyd[start][end] = 1;
                    }

                    // start < mid 이고 mid < end 인 경우
                    if (floyd[start][mid] == -1 && floyd[mid][end] == -1) {
                        floyd[start][end] = -1;
                    }
                }
            }
        }

        // 출력
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                // 관계가 성립되지 않은 경우만 카운트
                if (floyd[i][j] == 0) count++;
            }
            System.out.println(count);
        }

    }


}
