package org.example.string;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//BOJ9081 단어 맞추기
public class String6 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            String value = br.readLine();
            char[] str = value.toCharArray();
            int[] alphabets = new int['Z'-'A'+1];
            StringBuilder sb = new StringBuilder();

            int index = -1;

            // 내림차순으로 정렬되어 있는지 확인
            for(int i = str.length-1;i>0;i--){
                if(str[i-1] < str[i]) { // 내림차순이 깨지는 부분
                    index = i-1;
                    break;
                }
            }

            // 내림차순이 깨지는 부분이 있는 경우
            if(index != -1){
                // 깨지는 부분의 앞부분은 미리 빌더에 넣어놓기
                for(int i=0;i<index;i++){
                    sb.append(str[i]);
                }

                // 깨진 부분부터 알파벳테이블에 단어 수 카운트하기
                for(int i = index; i<str.length;i++){
                    alphabets[getInt(str[i])]++;
                }

                // 깨진 부분 알파벳의 다음 알파벳 구하기
                int pointer = getInt(str[index]);
                for(int i = pointer+1;i<alphabets.length;i++){
                    if(alphabets[i] > 0){
                        sb.append(getChar(i)); // 다음 알파벳 빌더에 넣기
                        alphabets[i]--;
                        break;
                    }
                }

                // 나머지 알파벳은 오름차순으로 빌더에 넣기
                for(int i=0;i<alphabets.length;i++){
                    for(int j=0;j<alphabets[i];j++){
                        sb.append(getChar(i));
                    }
                }

                // 출력
                System.out.println(sb.toString());

            }
            // 단어 전체가 내림차순으로 구성된 경우
            else {
                System.out.println(value);
            }

        }
    }


    public static char getChar(int value){
        return (char)(value+'A');
    }

    public static int getInt(char value){
        return value-'A';
    }
}
