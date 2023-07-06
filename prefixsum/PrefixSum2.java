package org.example.prefixsum;


import java.io.*;
import java.util.StringTokenizer;

//BOJ2042 구간 합 구하기
public class PrefixSum2 {
    static long[] arr;
    static long[] tree;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new long[n+1];
        tree = new long[4*n+1];

        for(int i =1;i<n+1;i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken());
        }

        init_tree(1,n,1);
        int z = m+k;
        while(z-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            //수정
            if(a==1){
                long diff = c - arr[b];
                arr[b] = c;
                update_tree(1,n,1,b,diff);
            }
            //구간합
            else if(a==2){
                sb.append(sum_tree(1,n,1,b,(int)c)).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static long init_tree(int start,int end,int node){
        if( start == end ){
            tree[node] = arr[start];
        }
        else {
            int mid = (start + end) / 2;
            tree[node] = init_tree(start, mid, 2 * node) + init_tree(mid + 1, end, 2 * node + 1);
        }
        return tree[node];
    }

    public static void update_tree(int start,int end,int node,int idx,long diff){
        if(idx < start || end < idx) return;
        tree[node] += diff;
        if ( start != end ){
            int mid = (start+end)/2;
            update_tree(start,mid,2*node,idx,diff);
            update_tree(mid+1,end,2*node+1,idx,diff);
        }
    }

    public static long sum_tree(int start,int end, int node,int fs, int fe){
        if ( fe < start || end < fs ) return 0;
        if ( fs <= start && end <= fe ) return tree[node];

        int mid = (start+end)/2;
        return sum_tree(start,mid,2*node,fs,fe) + sum_tree(mid+1,end,2*node+1,fs,fe);
    }
}
