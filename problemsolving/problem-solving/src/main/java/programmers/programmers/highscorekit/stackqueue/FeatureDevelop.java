package programmers.programmers.highscorekit.stackqueue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FeatureDevelop {
  // Problem : https://school.programmers.co.kr/learn/courses/30/lessons/42586
  public int[] solution(int[] progresses, int[] speeds) {
    List<Integer> numOfDeployedTaskList = new ArrayList<>();

    TaskManager taskManager = new TaskManager(progresses, speeds);

    while (!taskManager.deployedAllTask()) {
      List<Task> deployedTask = taskManager.deploy();
      if (deployedTask == null) {
        break;
      }
      numOfDeployedTaskList.add(deployedTask.size());
    }

    return numOfDeployedTaskList.stream().mapToInt(Integer::intValue).toArray();
  }

  private class TaskManager {
    private final Deque<Task> tasks = new LinkedList<>();
    private final Deque<Task> deployedTasks = new LinkedList<>();

    public TaskManager(int[] progresses, int[] speeds) {
      for (int id = 0; id < progresses.length; id++) {
        tasks.add(new Task(id, speeds[id], progresses[id]));
      }
    }

    public List<Task> deploy() {
      List<Task> completedTasks = new ArrayList<>();

      Task primaryTask = tasks.peekFirst();

      int numOfDays = primaryTask.calculateNumOfDays();

      for (int day = 0; day < numOfDays; day++) {
        updateProgress();
      }

      while (tasks.peekFirst().isCompleted()) {
        Task completedTask = tasks.poll();
        completedTasks.add(completedTask);
        deployedTasks.add(completedTask);

        if (tasks.isEmpty()) {
          break;
        }
      }

      return completedTasks;
    }

    private void updateProgress() {
      for (Task task : tasks) {
        task.updateProgress();
      }
    }

    public boolean deployedAllTask() {
      return tasks.isEmpty();
    }
  }

  private class Task {
    private static final int COMPLETE_PROGRESS = 100;
    private final int id;
    private final int speed;
    private int progress;

    private Task(int id, int speed, int progress) {
      this.id = id;
      this.speed = speed;
      this.progress = progress;
    }

    public int getId() {
      return id;
    }

    public int getSpeed() {
      return speed;
    }

    public int getProgress() {
      return progress;
    }

    public boolean isCompleted() {
      return progress == COMPLETE_PROGRESS;
    }

    public void updateProgress() {
      progress = Math.min(progress + speed, COMPLETE_PROGRESS);
    }

    public int calculateNumOfDays() {
      if (isCompleted()) {
        return 0;
      }

      int remainProgress = COMPLETE_PROGRESS - progress;
      int numOfDays = 0;

      while (remainProgress > 0) {
        remainProgress -= speed;
        numOfDays++;
      }

      return numOfDays;
    }
  }
}
