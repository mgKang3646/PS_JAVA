package org.example.implementation;

import java.io.*;
import java.util.*;


//BOJ16236 아기 상어
public class Impl9 {

    static int n;
    static int[][] matrix;
    static int startX,startY;

    static int[] dx= {0,-1,1,0};
    static int[] dy= {-1,0,0,1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(st.nextToken());
                matrix[i][j] = value;

                if(value == 9){
                    startX = j;
                    startY = i;
                }
            }
        }

        SharkMove currSharkMove = new SharkMove(startX,startY,0);

        int sharkSize = 2;
        int eatCount = 0;
        int ans = 0;

        while(true){
            PriorityQueue<SharkMove> queue = new PriorityQueue<>();
            boolean[][] visited = new boolean[n][n];
            boolean isEat = false;
            queue.add(currSharkMove);
            visited[currSharkMove.y][currSharkMove.x] = true;
            matrix[currSharkMove.y][currSharkMove.x]=0;


            while(!queue.isEmpty()){
                SharkMove sharkMove = queue.poll();


                if(matrix[sharkMove.y][sharkMove.x] != 0 && matrix[sharkMove.y][sharkMove.x] < sharkSize) {
                    ans += sharkMove.move;
                    currSharkMove = new SharkMove(sharkMove.x, sharkMove.y,0);
                    eatCount += 1;
                    if(eatCount == sharkSize) {
                        sharkSize += 1;
                        eatCount = 0;
                    }
                    isEat = true;
                    break;
                }

                for(int i=0;i<4;i++){
                    int nx = sharkMove.x + dx[i];
                    int ny = sharkMove.y + dy[i];

                    if(isValid(nx,ny)&&!visited[ny][nx]) {
                        if(matrix[ny][nx] <= sharkSize){
                            visited[ny][nx] = true;
                            queue.add(new SharkMove(nx,ny,sharkMove.move+1));
                        }
                    }
                }
            }

            if(!isEat) break;
        }


        System.out.println(ans);

    }

    public static boolean isValid(int x, int y){
        return ( x<n&&y<n&&x>=0&&y>=0 )? true : false;
    }


    public static class SharkMove implements Comparable<SharkMove>{
        int x;
        int y;
        int move;

        public SharkMove(int x, int y, int move){
            this.x = x;
            this.y = y;
            this.move = move;
        }

        @Override
        public int compareTo(SharkMove s){
            if(this.move == s.move){
                if(this.y == s.y) return this.x - s.x;
                else return this.y - s.y;
            }else{
                return this.move - s.move;
            }

        }
    }


}
