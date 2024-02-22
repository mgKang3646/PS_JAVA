package org.example.binarySearch;

import java.io.*;
import java.util.*;

//BOJ11723 집합 ( binarySearch를 이용한 풀이 )
// 비트마스킹 풀이로 다시 풀어보기!!
public class Bs9 {

    // 추가, 제거, 탐색이 용이한 자료구조는???
    // 다른 풀이보자.
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> valueList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while(n-- >0){

            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int value = 0;
            if( !op.equals("all") && !op.equals("empty")) value = Integer.parseInt(st.nextToken());

            switch(op){
                case "add" : add(valueList,value); break;
                case "remove" : remove(valueList,value); break;
                case "check" : sb.append(check(valueList,value)).append("\n");break;
                case "toggle" : toggle(valueList,value); break;
                case "all" : valueList = all(); break;
                case "empty" : valueList = empty(); break;
                default: break;
             }

             Collections.sort(valueList);

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    public static void add(List<Integer> valueList, int value){
        if(binarySearch(valueList,value,0,valueList.size()-1)==-1){
            valueList.add(value);
        }
    }

    public static void remove(List<Integer> valueList, int value){
        int index = binarySearch(valueList,value,0,valueList.size()-1);
        if(index !=-1){
            valueList.remove(index);
        }
    }

    public static int check(List<Integer> valueList, int value){
        if(binarySearch(valueList,value,0,valueList.size()-1)==-1) return 0;
        else return 1;
    }

    public static void toggle(List<Integer> valueList, int value){
        int index = binarySearch(valueList,value,0,valueList.size()-1);
        if(index == -1) valueList.add(value);
        else valueList.remove(index);
    }

    public static List<Integer> all(){
        return new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
    }

//    public static void all(List<Integer> valueList){
//        valueList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
//    }

    public static List<Integer> empty(){
        return new ArrayList<>();
    }


    public static int binarySearch(List<Integer> valueList, int target, int left, int right){

        if(valueList.size() == 0) return -1;
        if( left > right ) return -1;

        int mid = ( left + right )/2;

        if(valueList.get(mid) > target ) return binarySearch(valueList,target,left,mid-1);
        else if( valueList.get(mid) < target ) return binarySearch(valueList,target,mid+1,right);
        else return mid;
    }
}
