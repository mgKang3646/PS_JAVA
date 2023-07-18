package org.example.greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import static java.lang.Math.*;

//BOJ2109 순회공연
public class Greedy2 {
    static Course[] courses;
    static int maxDay = 0;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        courses = new Course[n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            maxDay = max(maxDay,d);
            courses[i] =  new Course(d,p);
        }
    }

    public static void solution(){
        int[] pays = new int[maxDay+1];

        for (Course course : courses) {
            for(int d=course.d;d>0;d--){
                if( course.p > pays[d] ) {
                    int tmpP = pays[d];
                    pays[d] = course.p;

                    int tmpD = d-1;
                    while(tmpD>0){
                        if(tmpP > pays[tmpD]){
                            int tmpP2 = pays[tmpD];
                            pays[tmpD] = tmpP;
                            tmpP = tmpP2;
                        }
                        tmpD--;
                    }
                    break;
                }
            }
        }

        int ans =0;
        for (int pay : pays) {
            ans += pay;
        }
        System.out.println(ans);
    }

    public static class Course {
        public int p;
        public int d;

        public Course(int d, int p) {
            this.p = p;
            this.d = d;
        }
    }
}


