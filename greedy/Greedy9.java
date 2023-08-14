package org.example.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//BOJ2212 센서
public class Greedy9 {

    public static BufferedReader br;
    public static class Distance implements Comparable<Distance>{
        int dist;
        int sensorIndex;

        public Distance(int dist, int sensorIndex){
            this.dist =dist; // 구간사이의 거리
            this.sensorIndex = sensorIndex; // 구간의 시작점 인덱스
        }

        @Override
        public int compareTo(Distance o) {
            return this.dist - o.dist; // 오름차순
        }
    }

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        if(k >= n) System.out.println(0); // 집중국의 개수가 센서의 개수보다 크거나 같으면 거리의 합은 0이다.
        else System.out.println(solution(n,k));
    }

    public static int solution(int n, int k) throws IOException {
        int[] sensors = new int[n];
        Distance[] distances = new Distance[n-1];
        int[] pivots = new int[k-1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        // STEP1 : 센서 오름차순으로 정렬하기
        for (int i = 0; i < n; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensors);

        // STEP2 : 두 개의 센서 사이의 거리를 내림차순으로 정렬하기
        for (int i = 0; i < n - 1; i++) {
            distances[i] = new Distance(sensors[i + 1] - sensors[i], i);
        }

        Arrays.sort(distances, Comparator.reverseOrder());

        // STEP3 : 영역을 나누어 거리의 합의 최솟값 구하기
        for (int i = 0; i < k - 1; i++) {
            pivots[i] = distances[i].sensorIndex;
        }

        Arrays.sort(pivots);

        int ans = 0;
        int pointer = 0;
        for (int pivot : pivots) {
            ans += sensors[pivot] - sensors[pointer];
            pointer = pivot + 1;
        }
        ans += sensors[n - 1] - sensors[pointer];

        return ans;
    }
}
