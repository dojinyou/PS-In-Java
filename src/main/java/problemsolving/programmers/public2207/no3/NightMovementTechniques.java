package problemsolving.programmers.public2207.no3;

public class NightMovementTechniques {

  public int solution(
      int distance,
      int[][] scope,
      int[][] times
  ) {
    Gaurd[] gaurds = new Gaurd[scope.length];
    for (int i = 0; i < gaurds.length; i++) {
      gaurds[i] = new Gaurd(scope[i], times[i]);
    }

    for (int i = 0; i <= distance; i++) {
      for (Gaurd gaurd : gaurds) {
        if (gaurd.inScope(i) && gaurd.isWorking(i)) {
          return i;
        }
      }
    }

    return distance;
  }

  class Gaurd implements Comparable<Gaurd> {
    final int minScope;
    final int maxScope;
    final int totalTime;
    final int workTime;

    Gaurd(
        int[] scope,
        int[] times
    ) {
      this.minScope = scope[0];
      this.maxScope = scope[1];
      this.totalTime = times[0] + times[1];
      this.workTime = times[0];
    }

    @Override
    public int compareTo(Gaurd o) {
      if (maxScope == o.minScope) {
        return maxScope - o.maxScope;
      }
      return minScope - o.minScope;
    }

    public boolean inScope(int location) {
      return minScope <= location && location <= maxScope;
    }

    public boolean isWorking(int time) {
      return (time % totalTime) < workTime;
    }
  }

}
