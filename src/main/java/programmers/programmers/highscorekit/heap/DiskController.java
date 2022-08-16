package programmers.programmers.highscorekit.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {

  private static final int MAX_JOBS = 500;
  private static final int REQUEST_TIME_IDX = 0;
  private static final int WORKING_TIME_IDX = 1;
  private int[][] jobs;
  private final PriorityQueue<int[]> taskQueue = new PriorityQueue<>(
      MAX_JOBS,
      Comparator.comparingInt(job -> job[WORKING_TIME_IDX])
  );

  private int currentJobIdx = 0;

  private int endTime = 0;

  private int sumOfResponseTime = 0;

  private int numOfFinishedJob = 0;

  public int solution(int[][] jobs) {
    this.jobs = jobs;
    sortJobs();
    workAllJobs(jobs);

    return sumOfResponseTime / jobs.length;
  }

  private void workAllJobs(int[][] jobs) {
    while (numOfFinishedJob < jobs.length) {

      addAllRequestedJobs(jobs);

      if (taskQueue.isEmpty()) {
        setEndTimeToNextJobRequestTime(jobs);
        continue;
      }

      work();
    }
  }

  private void addAllRequestedJobs(int[][] jobs) {
    while (currentJobIdx < jobs.length && jobs[currentJobIdx][REQUEST_TIME_IDX] <= endTime) {
      taskQueue.add(jobs[currentJobIdx++]);
    }
  }

  private void setEndTimeToNextJobRequestTime(int[][] jobs) {
    int[] nextJob = jobs[currentJobIdx];
    endTime = nextJob[REQUEST_TIME_IDX];
  }

  private void work() {
    if (taskQueue.isEmpty()) {
      return;
    }

    int[] currentJob = taskQueue.poll();
    endTime += currentJob[WORKING_TIME_IDX];
    sumOfResponseTime += endTime - currentJob[REQUEST_TIME_IDX];
    numOfFinishedJob++;
  }

  private void sortJobs() {
    Arrays.sort(jobs, Comparator.comparingInt(job -> job[REQUEST_TIME_IDX]));
  }
}
