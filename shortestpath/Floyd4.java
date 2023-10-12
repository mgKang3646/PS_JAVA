package org.example.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ1613 역사
public class Floyd4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] floyd = new int[n+1][n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            floyd[n1][n2] = -1; // n1이 n2 앞이다. ( -1 )
            floyd[n2][n1] = 1; //  n2가 n1 뒤이다. (  1 )
        }

        for(int mid=1;mid<=n;mid++){
            for(int front=1;front<=n;front++){
                for(int end=1;end<=n;end++){
                    // front가 mid 뒤이고 mid가 end 뒤이면 front가 end 뒤이다.
                    if(floyd[front][mid] == 1 && floyd[mid][end] == 1){
                        floyd[front][end] = 1 ;
                    }

                    // front가 mid 앞이고 mid가 end 앞이면 front가 end 앞이다.
                    else if(floyd[front][mid] == -1 && floyd[mid][end] == -1){
                        floyd[front][end] = -1;
                    }
                }
            }
        }

        // 결과 출력
        int s = Integer.parseInt(br.readLine());

        for(int i=0;i<s;i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if(floyd[n1][n2] == 1) System.out.println(1);
            else if(floyd[n1][n2] == -1) System.out.println(-1);
            else System.out.println(0);
        }
    }
}
