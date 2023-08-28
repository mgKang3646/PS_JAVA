package org.example.tree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//BOJ14675 단절점과 단절선
public class Tree4 {


    static int n;
    static List<Integer>[] tree;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        List<Integer>[] tree = new List[n+1];

        for(int i=1;i<=n;i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            // 양방향 간선
            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        int q = Integer.parseInt(br.readLine());

        for(int i=0;i<q;i++){
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if(t==1){
                if(tree[k].size() >= 2) System.out.println("yes"); // 리스트의 크기가 2이상이면 yes
                else System.out.println("no"); // 아니면 no
            }

            else{
                System.out.println("yes"); // 단절선은 무조건 yes
            }
        }




    }
}
