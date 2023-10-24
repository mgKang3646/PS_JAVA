package org.example.math;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ5073 삼각형과 세 변
public class Math2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            boolean isTriangle = true;
            int[] tri = new int[3];
            tri[0] = Integer.parseInt(st.nextToken());
            tri[1] = Integer.parseInt(st.nextToken());
            tri[2] = Integer.parseInt(st.nextToken());

            if(tri[0] == 0) break;

            int max = 0;
            int maxIndex = 0;
            for(int i=0;i<3;i++){
                if( tri[i] > max ) {
                    max = tri[i];
                    maxIndex = i;
                }
            }

            int sum = 0;
            for(int i=0;i<3;i++){
                if(i != maxIndex) sum += tri[i];
            }

            if( max >= sum ){
                System.out.println("Invalid");
            }else{
                if (tri[0] == tri[1] && tri[1] == tri[2]) {
                    System.out.println("Equilateral");
                }
                else if (tri[0] == tri[1] || tri[0] == tri[2] || tri[1] == tri[2]) {
                    System.out.println("Isosceles");
                }
                else{
                    System.out.println("Scalene");
                }
            }
        }
    }

}
