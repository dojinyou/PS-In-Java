import java.util.ArrayDeque;

// 프로그래머스 : 코딩테스트 연습 > 깊이/너비 우선 탐색(BFS/DFS) > 단어 변환
// 관련 링크 : https://programmers.co.kr/learn/courses/30/lessons/43163?language=java

class Solution {
    public int solution(String begin, String target, String[] words) {
        ArrayDeque<TransWord> q = new ArrayDeque<>();
        boolean[] isVisited = new boolean[words.length];
        q.add(new TransWord(target.toCharArray(), begin.toCharArray()));

        while (!q.isEmpty()) {
            TransWord transWord = q.pop();
            if (transWord.isTarget()) {
                return transWord.getChanged();
            }
            for (int i=0; i<words.length;i++) {
                if (!isVisited[i] && transWord.isChangeWord(words[i].toCharArray())) {
                    isVisited[i] = true;
                    q.add(new TransWord(transWord, words[i].toCharArray()));
                }
            }
        }
        return 0;
    }

}
class TransWord {
    private final char[] TARGET;
    private char[] word;
    private int changed;

    TransWord(char[] target, char[] word) {
        this.TARGET = target;
        this.word = word;
        this.changed = 0;
    }

    TransWord(TransWord prevWord, char[] newWord) {
        this.TARGET = prevWord.getTarget();
        this.word = newWord;
        this.changed = prevWord.getChanged()+1;
    }
    public char[] getTarget() {return this.TARGET;}
    public int getChanged() {return this.changed;}

    public boolean isTarget() {
        for (int i =0; i<this.word.length;i++){
            if (this.TARGET[i] != this.word[i]) {return false;}
        }
        return true;
    }
    public boolean isChangeWord(char[] changeWord) {
        int diff = 0;
        for (int i =0; i<this.word.length;i++){
            if (changeWord[i] != this.word[i]) {diff++;}
        }
        return diff==1;
    }
}