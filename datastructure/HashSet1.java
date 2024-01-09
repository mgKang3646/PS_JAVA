package org.example.datastructure;

import java.io.*;
import java.util.*;


//BOJ25757 임스와 함께하는 미니게임

// 1. 동일인 중복체크 => SET 자료구조로 중복 제거
// 2. 게임 횟수 체크 => 중복이 제거된 사람 / 게임 참여가능 인원 => 몫이 결과

public class HashSet1 {

    public static final int Y = 1;
    public static final int F = 2;
    public static final int O = 3;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int gameCount = getGameCount(game);
        java.util.HashSet<String> set = new java.util.HashSet<>();

        while(n-- > 0){
            set.add(br.readLine());
        }

        int total = set.size();
        int result = total/gameCount;

        System.out.println(result);

    }

    public static int getGameCount(String game){
        switch(game){
            case "Y" : return HashSet1.Y;
            case "F" : return HashSet1.F;
            case "O" : return HashSet1.O;
            default: return -1;
        }
    }
}
