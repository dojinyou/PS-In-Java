package problemsolving.programmers.highscorekit.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Printer {
  private final PrinterQueue printQueue = new PrinterQueue();

  public int solution(int[] priorities, final int targetId) {
    printQueue.init(priorities);
    int count = 0;
    while (printQueue.isNotEmpty()) {
      count++;
      Document document = printQueue.print();

      if (document.getId() == targetId) {
        break;
      }
    }
    return count;
  }

  private class PrinterQueue {
    private final Deque<Document> queue = new ArrayDeque<>();
    private int maxPriority = -1;

    public void init(int[] priorities) {
      for (int id = 0; id < priorities.length; id++) {
        final int priority = priorities[id];
        Document newDocument = new Document(id ,priority);

        add(newDocument);
      }
    }

    private void add(Document newDocument) {
      maxPriority = Math.max(maxPriority, newDocument.getPriority());

      queue.add(newDocument);
    }

    public Document pop() {
      final Document document = queue.poll();

      if (queue.isEmpty()) {
        maxPriority = -1;
        return document;
      }

      if (document.getPriority() == maxPriority) {
        maxPriority = getMaxPriority();
      }

      return document;
    }

    private int getMaxPriority() {
      int tempMaxPriority = -1;
      Iterator<Document> iterator = queue.iterator();

      while (iterator.hasNext()) {
        int priority = iterator.next().getPriority();

        tempMaxPriority = Math.max(priority, tempMaxPriority);
      }

      return tempMaxPriority;
    }

    public boolean isNotEmpty() {
      return !queue.isEmpty();
    }

    public Document print() {
      Document document = null;
      while(isNotEmpty()) {
        document = pop();

        if (maxPriority <= document.getPriority()) {
          break;
        }

        add(document);
      }
      return document;
    }
  }

  private class Document {
    private final int id;
    private final int priority;

    private Document(int id, int priority) {
      this.id = id;
      this.priority = priority;
    }

    public int getId() {
      return id;
    }

    public int getPriority() {
      return priority;
    }
  }
}
