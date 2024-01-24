package org.example.hash;
import java.io.*;
import java.util.*;

//BOJ20920 영단어 암기는 괴로워
public class Hash3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> hashMap = new HashMap<>();

        for(int i=0;i<n;i++){
            String str = br.readLine();
            if(str.length() < m) continue;

            if(hashMap.containsKey(str)){
                int count = hashMap.get(str);
                hashMap.replace(str,count+1);
            }else{
                hashMap.put(str,1);
            }
        }

        PriorityQueue<Word> pq = new PriorityQueue<>();
        List<String> keyList = new ArrayList<>(hashMap.keySet());
        for( String key : keyList ){
            pq.add(new Word(key,hashMap.get(key)));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll().value).append("\n");
        }

        System.out.println(sb.toString());

    }

    public static class Word implements Comparable<Word>{
        String value;
        int count;

        public Word(String value, int count){
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(Word word){
            if( this.count == word.count ){
                if(this.value.length() == word.value.length()){
                    return this.value.compareTo(word.value);
                }else{
                    return word.value.length() - this.value.length();
                }
            }else{
                return word.count - this.count;
            }
        }
    }



}
