package programmers.programmers.highscorekit.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DiskController {
  private static final int MAX_JOBS = 500;
  private static final int REQUEST_TIME_IDX = 0;
  private static final int WORKING_TIME_IDX = 1;
  private final PriorityQueue<Task> taskQueue = new PriorityQueue<>(MAX_JOBS);
  private final List<Task> completedTasks = new ArrayList<>(MAX_JOBS);
  private int[][] jobs;

  public int solution(int[][] jobs) {
    this.jobs = jobs;
    work();
    return getMinResponseTime();
  }

  private void work() {
    int currentTime = 0;
    int nextJobIdx = addJob(currentTime, 0);;

    Task currentTask = taskQueue.poll();
    if (currentTask != null) {
      currentTask.startTask(currentTime);
      currentTime = currentTask.getCompleteTime();
    }

    while(nextJobIdx < jobs.length) {
      nextJobIdx = addJob(currentTime, nextJobIdx);

      if (currentTask == null && taskQueue.isEmpty()) {
        currentTime = jobs[nextJobIdx][REQUEST_TIME_IDX];
        continue;
      }

      if (currentTask == null) {
        currentTask = taskQueue.poll();
        currentTask.startTask(currentTime);
        currentTime = currentTask.getCompleteTime();
        continue;
      }

      if (currentTask.getCompleteTime() == currentTime) {
        completedTasks.add(currentTask);
        currentTask = taskQueue.poll();
        currentTask.startTask(currentTime);
      }
      currentTime = currentTask.getCompleteTime();
    }
  }

  private int addJob(int currentTime, int currentJobIdx) {
    for (int i = currentJobIdx; i < jobs.length; i++) {
      int requestTime = jobs[i][REQUEST_TIME_IDX];
      int workingTime = jobs[i][WORKING_TIME_IDX];

      if (currentTime < requestTime) {
        return i;
      }

      Task newTask = new Task(requestTime, workingTime);

      taskQueue.add(newTask);
    }

    return jobs.length;
  }

  private class Task implements Comparable<Task>{
    private final int requestTime;
    private final int workingTime;
    private int completeTime;
    private int responseTime;

    private Task(int requestTime, int workingTime) {
      this.requestTime = requestTime;
      this.workingTime = workingTime;
    }

    public int getCompleteTime() {
      return completeTime;
    }

    public int getResponseTime() {
      return responseTime;
    }

    public void startTask(int startingTime) {
      this.completeTime = startingTime + workingTime;
      this.responseTime = completeTime - requestTime;
    }

    public int getWorkingTime() {
      return workingTime;
    }

    private int getRequestTime() {
      return requestTime;
    }

    @Override
    public int compareTo(Task o) {
      if (this.workingTime == o.getWorkingTime()) {
        return this.requestTime - o.getRequestTime();
      }
      return this.workingTime - o.getWorkingTime();
    }
  }
}
