package org.example.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Math.*;

//BOJ1459 걷기
public class Greedy20_1 {

    static int[] dx = { 1, 1, 0, 1 };
    static int[] dy = { 1, -1, 1, 0 };

    static int[][] graph;

    static int row,col,direct,cross,length;

    public static class Pos{
        int x;
        int y;

        public Pos(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        length = max(col,row);
        direct = Integer.parseInt(st.nextToken());
        cross = Integer.parseInt(st.nextToken());
        graph = new int[length+1][length+1];

        bfs();

        System.out.println(graph[row][col]);

    }

    public static void bfs(){

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0,0));

        while(!queue.isEmpty()){
            Pos pos = queue.poll();

            for(int i=0;i<4;i++){
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if(isValidate(nx,ny)){

                    // 대각선 이동인 경우
                    if(i<2){
                        if(graph[ny][nx]==0){
                            graph[ny][nx] = graph[pos.y][pos.x] + cross;
                            queue.add(new Pos(nx,ny));
                        }
                        else if(graph[ny][nx] > graph[pos.y][pos.x] + cross){
                            graph[ny][nx] = graph[pos.y][pos.x] + cross;
                            queue.add(new Pos(nx,ny));
                        }
                    }
                    // 가로,세로 이동인 경우
                    else{
                        if(graph[ny][nx]==0){
                            graph[ny][nx] = graph[pos.y][pos.x] + direct;
                            queue.add(new Pos(nx,ny));
                        }
                        else if(graph[ny][nx] > graph[pos.y][pos.x] + direct){
                            graph[ny][nx] = graph[pos.y][pos.x] + direct;
                            queue.add(new Pos(nx,ny));
                        }
                    }
                }
            }

        }

    }

    public static boolean isValidate(int x,int y){
        if( x >= 0 && y >=0 && x <= length && y <= length ) return true;
        else return false;
    }
}
