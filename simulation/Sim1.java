package org.example.simulation;

import java.io.*;
import java.util.*;


//BOJ14053 로봇 청소기
public class Sim1 {

    static int[][] matrix;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] isClean;
    static int n,m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] pos = new int[2];
        int direction = 0;
        st = new StringTokenizer(br.readLine());

        pos[0] = Integer.parseInt(st.nextToken());
        pos[1] = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        isClean = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        while(true){

            // 현재칸이 아직 청소되지 않은 경우
            if(matrix[pos[0]][pos[1]] == 0 && !isClean[pos[0]][pos[1]] ){
                ans++;
                isClean[pos[0]][pos[1]] = true;
            }

            // 청소되지 않은 빈칸이 '있는' 경우
            if(isMoveOk(pos[1],pos[0])){
                int t = 4;
                while(t-- > 0){
                    direction = rotate(direction);
                    int[] nextPos = moveForward(pos,direction);
                    if(nextPos == null) continue;
                    else {
                        pos = nextPos;
                        break;
                    }
                }
            }

            // 청소되지 않은 빈칸이 '없는' 경우
            else{
                int[] nextPos = moveBackward(pos,direction);

                if(nextPos == null) break;
                else {
                    pos = nextPos;
                }
            }
        }

        System.out.println(ans);

    }

    public static boolean isMoveOk(int x, int y){

        int count = 0;
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(isValid(nx,ny)){
                if(matrix[ny][nx] == 0 && !isClean[ny][nx]) count++;
            }
        }

        return ( count > 0 ) ? true : false;
    }

    public static boolean isValid(int x, int y){
        return ( x<m&&y<n&&x>=0&&y>=0 ) ? true : false;
    }


    public static int rotate(int direction){
        if(direction == 0) return 3;
        else return direction-1;
    }

    public static int[] moveForward(int[] currPos, int currDirection){

        int ny = currPos[0];
        int nx = currPos[1];

        if(currDirection == 0) ny = ny -1;
        else if(currDirection == 1) nx = nx +1;
        else if(currDirection == 2) ny = ny +1;
        else nx = nx -1;

        if(isValid(nx,ny)&&matrix[ny][nx]==0&&!isClean[ny][nx]){
            int[] nextPos = new int[2];
            nextPos[0] = ny;
            nextPos[1] = nx;
            return nextPos;
        }
        else{
            return null;
        }
    }

    public static int[] moveBackward(int[] currPos, int currDirection){
        int ny = currPos[0];
        int nx = currPos[1];

        if(currDirection == 0) ny = ny+1;
        else if(currDirection == 1) nx = nx-1;
        else if(currDirection == 2) ny = ny-1;
        else nx = nx+1;

        if(isValid(nx,ny)&&matrix[ny][nx]==0){
            int[] nextPos = new int[2];
            nextPos[0] = ny;
            nextPos[1] = nx;
            return nextPos;
        }

        else{
            return null;
        }


    }
}