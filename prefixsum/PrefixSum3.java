package org.example.prefixsum;


import java.io.*;
import java.util.StringTokenizer;

//#BOJ10999 구간합 구하기2 ( prefixsum )
public class PrefixSum3 {

    static StringTokenizer st;
    static long[] arr; // 수열
    static long[] tree; // 세그먼트 트리
    static long[] lazy; // lazy 트리


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
        lazy = new long[4*n+1];

        //수열 초기화
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i]=Long.parseLong(st.nextToken());
        }

        //세그먼트 트리 초기화
        init_tree(1,n,1);

        int z = m+k;
        while(z-- > 0){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);

            // 세그먼트 트리 변경하기
            if(a==1){
                long diff = Long.parseLong(str[3]);
                update_tree(1,n,1,b,c,diff);
            }
            // 구간합 구하기
            else if(a==2){
                sb.append(sum_tree(1,n,1,b,c)).append("\n");
            }
        }

        //출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 세그먼트 트리 초기화
    public static long init_tree(int start, int end, int node){
        if( start == end ) tree[node] = arr[start];
        else {
            int mid = (start+end)/2;
            tree[node] = init_tree(start,mid,2*node) + init_tree(mid+1,end,2*node+1);
        }
        return tree[node];
    }

    // 구간 합 구하기
    public static long sum_tree(int start,int end,int node,int fs,int fe){
        propagation(start,end,node); // 방문한 노드에 지연값이 있다면 처리하기
        if( fs > end || fe < start ) return 0;
        if( fs <= start && end <= fe ) return tree[node];

        int mid = (start+end)/2;
        return sum_tree(start,mid,2*node,fs,fe) + sum_tree(mid+1,end,2*node+1,fs,fe);
    }

    // 구간 변경 하기
    public static void update_tree(int start,int end, int node,int fs, int fe,long diff){
        propagation(start,end,node); // 방문한 노드에 지연값이 있다면 처리하기
        if(start > fe || end < fs ) return;
        if( fs <= start && end <= fe ) { // 방문한 노드가 변경구간 안에 있다면 변경작업 지연
            tree[node] += (end-start+1)*diff; // 리프노드의 개수만큼 변경값 더하기
            if( start != end ){
                lazy[2*node] += diff; // 자식노드 변경작업 지연됨을 표시하기
                lazy[2*node+1] += diff; // 자식노드 변경작업 지연됨을 표시하기
            }
            return; // 변경작업 중지
        }
        // 변경 구간 탐색하기
        int mid = (start+end)/2;
        update_tree(start,mid,2*node,fs,fe,diff);
        update_tree(mid+1,end,2*node+1,fs,fe,diff);
        tree[node] = tree[2*node] + tree[2*node+1]; // 상위 구간은 변경되었으니 변경된 구간합 초기화하기
    }

    // 자식노드에게 지연전파하기
    public static void propagation(int start,int end,int node){
        if(lazy[node] != 0) { // 지연값이 있는 경우
            tree[node] += (end-start+1)*lazy[node]; // 지연된 변경값을 처리
            if(start != end){ // 자식에게 지연 전파
                lazy[2*node] += lazy[node];
                lazy[2*node+1] += lazy[node];
            }
            lazy[node] = 0; // 원복
        }
    }
}
