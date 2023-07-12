package org.example.bfs;


import java.io.*;
import java.util.*;

import static java.lang.Math.max;

//BOJ7576 토마토
public class Bfs1 {

    static Queue<int[]> queue = new LinkedList<>();
    static StringTokenizer st;
    static int[][] box;
    static int[][] cost;//BFS는 1회차씩 돌아가기 때문에 누군가가 먼저 가있다면 그 사람이 최단거리인거다. => DFS적 생각
    static int n;
    static int m;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    // 시간초과가 난 이유는 BFS로 풀었는데 결국은 DFS가 되었기 때문이다.
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        box = new int[n][m];

        for(int i =0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if( box[i][j]==1 ){
                    int[] pos = {i,j};
                    queue.add(pos);
                }
            }
        }
    }

    public static void solution(){
        bfs(queue);
        System.out.println(getResult());
    }

    public static void bfs(Queue<int[]> queue){
        while(!queue.isEmpty()){
            int[] pos = queue.remove();
            int y = pos[0];
            int x = pos[1];

            for(int i =0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(isValidate(nx,ny) && box[ny][nx] == 0){
                    box[ny][nx] = box[y][x]+1;
                    int[] nextPos = {ny,nx};
                    queue.add(nextPos);
                }
            }
        }
    }

    public static boolean isValidate(int x, int y){
        if( x>=0 && y>=0 && x < m && y < n ) return true;
        else return false;
    }

    public static int getResult(){
        int maxValue = 1;
        for(int i =0; i<n;i++){
            for(int j =0;j<m;j++){
                if(box[i][j] == -1) continue;
                if(box[i][j] == 0) return -1;
                maxValue = max(maxValue,box[i][j]);
            }
        }
        if(maxValue == 1) return 0;
        else return maxValue -1;
    }
}
