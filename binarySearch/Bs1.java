package org.example.binarySearch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Math.max;

//BOJ1654 랜선 자르기
public class Bs1 {
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        long[] lans = new long[k];
        long maxLan = 0;

        for(int i=0;i<k;i++){
            lans[i] = Long.parseLong(br.readLine());
            maxLan = max(maxLan, lans[i]);  //범위 설정을 위한 최대랜선
        }

        System.out.println(binarySearch(1, maxLan,lans)); // 이분탐색
    }

    public static long binarySearch(long start, long end, long[] lans){
        if( start > end ) return end; // start가 end보다 커지면 end 반환
        long mid = (start+end)/2; // 중간값 구하기
        if(getLineNum(mid,lans) >= n) return binarySearch(mid+1,end,lans); // 우측 구간 탐색하기
        else return binarySearch(start,mid-1,lans); // 좌측구간 탐색하기
    }

    // 생성 가능한 랜선의 개수 구하기
    public static int getLineNum(long line, long[] lans){
        int result = 0;
        for(long lan : lans){
            result += lan/line;
        }
        return result;
    }
}
