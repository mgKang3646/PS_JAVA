package org.example.implementation;

import java.io.*;
import java.util.*;

//BOJ14502 연구소
public class Impl8 {
    private static int n,m;
    private static int[][] matrix;
    private static Queue<Virus> virusQueue;
    private static List<Empty> emptyList;
    private static List<Empty[]> threeBlockList;

    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        virusQueue = new LinkedList<>();
        emptyList = new ArrayList<>();
        threeBlockList = new ArrayList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int value = Integer.parseInt(st.nextToken());
                matrix[i][j] = value;

                if(value == 2) virusQueue.add(new Virus(j,i));
                if(value == 0) emptyList.add(new Empty(j,i));
            }
        }

        dfs(0,0,new Empty[3],new boolean[emptyList.size()]);

        int count = Integer.MAX_VALUE;

        for(Empty[] threeBlock : threeBlockList ){
            int[][] tmpMatrix = copyMatrix();
            tmpMatrix[threeBlock[0].y][threeBlock[0].x] = 1;
            tmpMatrix[threeBlock[1].y][threeBlock[1].x] = 1;
            tmpMatrix[threeBlock[2].y][threeBlock[2].x] = 1;

            Queue<Virus> tmpVirusQueue = copyQueue();
            count = Math.min(count,bfs(tmpVirusQueue, tmpMatrix));
        }

        int ans = emptyList.size() - count - 3;
        System.out.println(ans);

    }

    public static int[][] copyMatrix(){
        int[][] tmpMatrix = new int[n][m];
        for(int i=0;i<n;i++){
            tmpMatrix[i] = Arrays.copyOf(matrix[i],m);
        }
        return tmpMatrix;
    }

    public static Queue<Virus> copyQueue(){
        Queue<Virus> tmpVirusQueue = new LinkedList<>();
        for(Virus virus : virusQueue){
            tmpVirusQueue.add(virus);
        }
        return tmpVirusQueue;
    }

    public static void dfs(int index, int depth, Empty[] threeBlock, boolean[] visited){
        if(depth == 3) {
            threeBlockList.add(threeBlock);
            return;
        }

        for(int i = index;i<emptyList.size();i++){
            if(visited[i]) continue;

            visited[i] = true;
            Empty[] tmp = Arrays.copyOf(threeBlock,threeBlock.length);
            tmp[depth] = emptyList.get(i);
            dfs(i,depth+1,tmp,visited);
            visited[i] = false;
        }

    }

    public static int bfs(Queue<Virus> tmpVirusQueue, int[][] tmpMatrix){

        int count = 0;
        while(!tmpVirusQueue.isEmpty()){
            Virus virus = tmpVirusQueue.poll();

            for(int i=0;i<4;i++){
                int nx = virus.x + dx[i];
                int ny = virus.y + dy[i];

                // 0이어야함 ...
                if(isValid(nx,ny)){
                    if(tmpMatrix[ny][nx] == 0) {
                        tmpMatrix[ny][nx] = 2;
                        tmpVirusQueue.add(new Virus(nx,ny));
                        count++;
                    }

                }
            }
        }

        return count;

    }

    public static boolean isValid(int x, int y){
        return (y<n&&x<m&&x>=0&&y>=0)? true : false;
    }

//    public static void print(){
//        StringBuilder sb = new StringBuilder();
//        for (Empty[] empties : threeBlockList) {
//            for (Empty empty : empties) {
//                sb.append("(" +empty.x +"," + empty.y +")").append(" ");
//            }
//            sb.append("\n");
//        }
//
//        System.out.println(sb.toString());
//    }

    public static class Virus{
        int x;
        int y;

        public Virus(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static class Empty{
        int x;
        int y;

        public Empty(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}





