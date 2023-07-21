package org.example.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BOJ7562 나이트의 이동
public class Bfs2 {


    static int[] dx = {2,1,-1,-2,-2,-1,1,2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};

    static int[][] board;

    static int size;

    public static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while(n-- >0){
            size = Integer.parseInt(br.readLine());
            board = new int[size][size];

            StringTokenizer st = new StringTokenizer(br.readLine());

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            Position startPos = new Position(startX,startY);

            st = new StringTokenizer(br.readLine());

            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            Position endPos = new Position(endX,endY);

            Queue<Position> queue = new LinkedList<>();
            queue.add(startPos);
            board[startPos.y][startPos.x] = 1;

            System.out.println(bfs(queue,endPos));
        }
    }

    public static int bfs(Queue<Position> queue,Position endPos){

        while(!queue.isEmpty()){
            Position currPos = queue.remove();
            int x = currPos.x;
            int y = currPos.y;

            if(x == endPos.x && y == endPos.y) break;

            for(int i=0;i<8;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(isValidate(nx,ny) && board[ny][nx] == 0 ){
                    board[ny][nx] += board[y][x] + 1;
                    Position nextPos = new Position(nx,ny);
                    queue.add(nextPos);
                }
            }
        }

        return board[endPos.y][endPos.x] - 1;
    }

    public static boolean isValidate(int x, int y) {
        if ( x >= 0 && y >= 0 && x < size && y < size ) return true;
        else return false;
    }
}
