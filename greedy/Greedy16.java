package org.example.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ3109 빵집
public class Greedy16 {

    static int[] dr = {-1,0,1};
    static int r,c,ans;

    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        graph = new int[r][c];

        // 그래프 초기화
        for(int i=0;i<r;i++){
            char[] charArray = br.readLine().toCharArray();
            for(int j=0;j<c;j++){
                if(charArray[j] == 'x') graph[i][j] = -1;
            }
        }

        // DFS 탐색 ( 0 ~ r-1 )
        for(int i=0;i<r;i++){
            dfs(i,0);
        }

        // 출력
        System.out.println(ans);
    }

    public static boolean dfs( int row, int col ){
        boolean flag = false;

        // 끝열에 도달한 경우
        if(col == c-1){
            ans += 1;
            return true; // true 리턴
        }

        // 오른쪽위, 오른쪽, 오른쪽 아래 순으로 탐색
        for(int i=0;i<3;i++){

            int nRow = row + dr[i];
            int nCol = col + 1;

            if(isValidate(nRow, nCol) && graph[nRow][nCol] != -1){
                // 건물이거나 누가 방문해서 실패했거나 성공했거나
                // 재방문해도 의미가 없으므로 -1로 설정한 후 다시 원복할 필요없다.
                graph[nRow][nCol] = -1;

                // dfs 탐색
                if(dfs(nRow,nCol)) {
                    flag = true;
                    // 탐색을 완료하면 경로가 겹치면 안되므로 break
                    break;
                }
            }
        }

        if(flag) return true;
        else return false;
    }

    public static boolean isValidate(int row, int col){
        if(row>=0 && col>=0 && row < r && col< c) return true;
        else return false;
    }
}
