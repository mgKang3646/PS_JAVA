package org.example.bfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BOJ16234 인구이동
public class Bfs5 {

    public static int n, L, R, ans;
    public static int[][] matrix;
    public static boolean[][] isVisited;
    public static int[] dCol = { 1, -1, 0, 0 };
    public static int[] dRow = { 0, 0, 1, -1};

    public static class Pos{
        int row;
        int col;

        public Pos(int row,int col){
            this.row = row;
            this.col = col;
        }
    }

    // 예제입력5번이 계속 1이 나옴
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        matrix = new int[n][n];

        //초기화 작업
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            isVisited = new boolean[n][n];
            boolean flag = false;

            // 하루동안의 인구이동
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(isVisited[i][j]) continue; // 인구이동이 일어난 지역은 제외
                    if(bfs(i,j)) flag = true; // 인구이동이 없었으면 BFS 탐색 시작
                }
            }

            // 인구이동이 더이상 없으면 출력
            if(!flag){
                System.out.println(ans);
                return;
            }
            // 인구이동이 있었으면 카운트
            else{
                ans++;
            }
        }

    }


    public static boolean bfs(int startRow, int startCol){

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(startRow,startCol));
        isVisited[startRow][startCol] = true;

        ArrayList<Pos> arrayList = new ArrayList(); // 인구이동이 일어난 지역들
        arrayList.add(new Pos(startRow,startCol) );

        int sum = 0;
        int count = 0;

        while(!queue.isEmpty()){
            Pos pos = queue.poll();
            int row = pos.row;
            int col = pos.col;

            count++;
            sum += matrix[row][col];

            for(int i=0;i<4;i++){
                int nRow = row+dRow[i];
                int nCol = col+dCol[i];

                // 인구이동이 가능하면 큐에 등록
                if(isValidate(nRow,nCol)&&!isVisited[nRow][nCol]){
                    int value = Math.abs(matrix[row][col]-matrix[nRow][nCol]);
                    if( value >= L && value <= R ){ // L보다 크거나 같고 R보다 작거나 같은 경우
                        isVisited[nRow][nCol] = true;
                        arrayList.add(new Pos(nRow,nCol));
                        queue.add(new Pos(nRow,nCol));
                    }
                }
            }
        }

        // 인구이동이 일어난 영역들 값변경
        if(arrayList.size() > 1){
            refresh(arrayList,sum/count);
            return true;
        }else {
            return false;
        }

    }

    public static void refresh(ArrayList<Pos> arrayList, int value){
        for (Pos pos : arrayList) {
            matrix[pos.row][pos.col] = value;
        }
    }

    public static boolean isValidate(int row, int col){
        if(col>=0&&row>=0&&col<n&&row<n) return true;
        else return false;
    }


}
