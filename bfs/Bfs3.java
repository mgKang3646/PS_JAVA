package org.example.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BOJ18404 현명한 나이트 시간초과가 발생했을때 시간 복잡도를 계산해서 문제를 리빌딩하는 능력이 부족해서 틀림
public class Bfs3 {

    static int[] dx = {-2,-1,1,2,-2,-1,1,2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    static int[][] costs;

    static int n;
    static int m;

    public static class ChessObject{
        int x;
        int y;
        public ChessObject(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        costs= new int[n+1][n+1];
        bfs(new ChessObject(x,y),costs);

        for(int i =0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int ix = Integer.parseInt(st.nextToken());
            int iy = Integer.parseInt(st.nextToken());

            sb.append(costs[iy][ix]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(ChessObject start,int[][] costs){
        Queue<ChessObject> queue = new LinkedList<>();
        costs[start.y][start.x] = 0;
        queue.add(start);

         while(!queue.isEmpty()){
            ChessObject currNight = queue.remove();
            for(int i=0;i<8;i++){
                int nx = currNight.x + dx[i];
                int ny = currNight.y + dy[i];

                if(!isValid(nx,ny)) continue;
                if(costs[ny][nx] == 0 ) {
                    costs[ny][nx] = costs[currNight.y][currNight.x] + 1;
                    queue.add(new ChessObject(nx,ny));
                }
            }
        }
    }

    public static boolean isValid(int x, int y){
        if( x>0 && y>0 && x<=n && y<=n ) return true;
        else return false;
    }

}
