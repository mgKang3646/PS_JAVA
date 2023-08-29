package org.example.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//BOJ13549 숨바꼭질3
public class Bfs4 {

    public static final int MAX = 100000;
    public static int[] time = new int[MAX+1]; // 시간 테이블

    public static class Pos{
        int index;
        int time;

        public Pos(int index, int time){
            this.index = index;
            this.time = time;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Arrays.fill(time,Integer.MAX_VALUE);

        bfs(n); // BFS 탐색으로 시간테이블 만들기

        System.out.println(time[k]); // 출력

    }

    public static void bfs(int start){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(start,0));
        time[start] = 0;

        while(!queue.isEmpty()){
            Pos curr = queue.remove();

            // 시간테이블 입력된 시간보다 작은 경우만 큐에 넣는다.

            // x2
            if(2*curr.index < MAX+1 && curr.time < time[2*curr.index]) {
                queue.add(new Pos(2*curr.index,curr.time));
                time[2*curr.index] = curr.time;
            }

            // +1
            if(curr.index+1 < MAX+1 && curr.time+1 < time[curr.index+1] ) {
                queue.add(new Pos(curr.index+1,curr.time+1));
                time[curr.index+1] = curr.time+1;
            }

            // -1
            if(curr.index - 1 >= 0 && curr.time+1 < time[curr.index-1]) {
                queue.add(new Pos(curr.index-1,curr.time+1));
                time[curr.index-1] = curr.time+1;
            }
        }
    }
}
