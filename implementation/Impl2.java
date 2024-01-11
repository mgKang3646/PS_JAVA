package org.example.implementation;
import java.io.*;
import java.util.*;

//BOJ1244 스위치 켜고 끄기
public class Impl2 {

    public final static int ON = 1;
    public final static int OFF = -1;

    // 남학생의 경우, 배수의 스위치 상태변경
    // 여학생의 경우, 주어빈 번호의 좌우대칭이 가장 큰 부분을 찾고 모두 바꾸어준다. ( 한개면 하나만 변경 )
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] switches = new int[size+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<size+1;i++){
            int value = Integer.parseInt(st.nextToken());
            value = ( value == 1 ) ? ON : OFF;
            switches[i] = value;
        }

        int num = Integer.parseInt(br.readLine());

        for(int i=0;i<num;i++){
            st = new StringTokenizer(br.readLine());

            int sex = Integer.parseInt(st.nextToken());
            int switchNum = Integer.parseInt(st.nextToken());

            // 스위치 상태 변경
            if(sex == 1) manProcess(switches,switchNum);
            else femaleProcess(switches,switchNum);

        }

        // 출력
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<switches.length;i++){
            int value = switches[i];
            value = ( value == ON )? 1 : 0;

            if(i%20==0) sb.append(value).append("\n");
            else sb.append(value).append(" ");
        }

        System.out.println(sb.toString());

    }

    // 남자인 경우 상태 변경
    public static void manProcess(int[] switches,int num){

        int count = 1;
        int i = num*count;

        while(i<switches.length){
            switches[i] *= -1;
            count += 1;
            i = num*count;
        }
    }

    // 여자인 경우 상태 변경
    public static void femaleProcess(int[] switches, int num){
        int leftP = num-1;
        int rightP = num+1;

        // 좌우 대칭 체크
        while(leftP>0&&rightP<switches.length){

            if( switches[leftP] != switches[rightP] ) break;
            leftP--;
            rightP++;

        }

        // 구간 상태변경
        int start = leftP+1;
        int end = rightP-1;

        for(int i=start;i<=end;i++){
            switches[i] *= -1;
        }
    }
}
