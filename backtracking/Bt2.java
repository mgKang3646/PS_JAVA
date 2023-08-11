package org.example.backtracking;


import java.util.Scanner;

//BOJ15650 N과 M(2)
public class Bt2 {

    static int n;
    static int m;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];

        recursive2(1,0);
    }

    public static void recursive2(int index, int depth){
        if(depth==m){
            for (int value : arr) {
                System.out.print(value+" ");
            }
            System.out.println();
            return;
        }

        for(int i=index; i<n+1;i++){
            arr[depth] = i;
            recursive2(i+1,depth+1);
        }
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);

        sb = new StringBuilder();
        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n+1];

        for(int i =1;i<=n;i++){
            visited[i] = true;
            String result = String.valueOf(i);
            recursive(i,1,result);
            visited[i] = false;
        }

        System.out.println(sb.toString());
    }

    public static void recursive(int x, int count,String result){
        if( count == m ){
            sb.append(result).append("\n");
            return;
        }

        for(int i=x+1;i<=n;i++){
            if(visited[i]) continue;
            visited[i] = true;
            String tmp = result + " " + String.valueOf(i);
            recursive(i,count+1,tmp);
            visited[i] = false;
        }
    }
}
