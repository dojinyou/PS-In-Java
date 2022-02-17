import java.util.ArrayDeque;
import java.util.ArrayList;

// 프로그래머스 : 코딩테스트 > 스택/큐 > 프린터
// 관련 링크 : https://programmers.co.kr/learn/courses/30/lessons/42587


class Printer {
    public int solution(int[] priorities, int location) {
        Print print = new Print();
        int numOfDocs = priorities.length;
        for (int i = 0; i<numOfDocs;i++) {
            Document newDoc = new Document(i, priorities[i]);
            print.addDocument(newDoc);
        }
        int[] result = print.work();
        int answer = 1;
        for (int printDocID : result) {
            if (location == printDocID) {
                break;
            }
            answer ++;
        }
        return answer;
    }
}

class Print {
    private ArrayDeque<Document> workList;

    Print() {
        this.workList = new ArrayDeque<>();
    }
    public void addDocument(Document newDoc) {this.workList.add(newDoc);}
    public int[] work() {
        ArrayList<Integer> result = new ArrayList<>();
        while(this.workList.size() != 0) {
            int topPriority = this.getTopPriority();
            while (true) {
                Document doc = this.workList.pop();
                if (doc.getPriority() == topPriority) {
                    result.add(doc.getID());
                    break;
                } else {
                    this.addDocument(doc);
                }
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }
    public int getTopPriority() {
        int topPriority = 0;
        for (Document doc : this.workList) {
            topPriority = Math.max(topPriority, doc.getPriority());
        }
        return topPriority;
    }
}

class Document implements Comparable<Document> {
    private final int ID;
    private final int PRIORITY;

    Document(int id, int priority) {
        this.ID = id;
        this.PRIORITY = priority;
    }

    public int getID() {return this.ID;}
    public int getPriority() {return this.PRIORITY;}

    @Override
    public int compareTo (Document other) {
        return this.PRIORITY - other.PRIORITY;
    }
}