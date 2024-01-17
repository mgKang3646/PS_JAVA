package org.example.implementation;

import java.io.*;
import java.util.*;

//BOJ16926 배열돌리기1
public class Impl7 {

    public static int[][] matrix;
    public static int n,m,r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(r-- > 0){

            int startX = 0;
            int endX = m-1;
            int startY = 0;
            int endY = n-1;
            int[][] tmpMatrix = new int[n][m];

            while((startX<endX) && (startY<endY)){

                rotateMatrix(startX,endX,startY,endY,tmpMatrix);

                startX += 1;
                endX -= 1;
                startY += 1;
                endY -= 1;

            }

            matrix = tmpMatrix;

        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(matrix[i][j]);

                if(j==m-1) sb.append("\n");
                else sb.append(" ");
            }
        }

        System.out.println(sb.toString());

    }

    public static void rotateMatrix(int startX, int endX, int startY, int endY, int[][] tmpMatrix){

        // 상단 좌측 이동
        for(int i=startX+1;i<=endX;i++){
            tmpMatrix[startY][i-1] = matrix[startY][i];
        }
        // 하단 우측 이동
        for(int i=startX;i<=endX-1;i++){
            tmpMatrix[endY][i+1] = matrix[endY][i];
        }
        // 좌측 하강 이동
        for(int i=startY;i<=endY-1;i++){
            tmpMatrix[i+1][startX] = matrix[i][startX];
        }
        // 우측 상승 이동
        for(int i=startY+1;i<=endY;i++){
            tmpMatrix[i-1][endX] = matrix[i][endX];
        }

    }
}
