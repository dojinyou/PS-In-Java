package problemsolving.programmers.highscorekit.hash;

import java.util.HashMap;
import java.util.Map;

public class NotFinishPlayer {
  private static final int MIN_COUNT = 0;

  public String solution(String[] participants, String[] finishers) {
    Map<String, Integer> nameToNumOfPlayer = new HashMap<>();

    addNumOfPlayer(participants, nameToNumOfPlayer);

    removeNumOfPlayer(finishers, nameToNumOfPlayer);

    return getNotFinisherName(nameToNumOfPlayer);
  }

  private String getNotFinisherName(Map<String, Integer> nameToNumOfPlayer) {
    for (Map.Entry<String, Integer> entry : nameToNumOfPlayer.entrySet()) {
      String playerName = entry.getKey();
      int numOfNotFinisher = entry.getValue();

      if (0 < numOfNotFinisher) {
        return playerName;
      }
    }
    return null;
  }

  private void removeNumOfPlayer(String[] finishers, Map<String, Integer> nameToNumOfPlayer) {
    for (String finisherName : finishers) {
      int numOfPlayer = nameToNumOfPlayer.get(finisherName);
      nameToNumOfPlayer.put(finisherName, numOfPlayer - 1);
    }
  }

  private void addNumOfPlayer(String[] participants, Map<String, Integer> nameToNumOfPlayer) {
    for (String participantName : participants) {
      int numOfPlayer = nameToNumOfPlayer.computeIfAbsent(participantName, name -> MIN_COUNT);
      nameToNumOfPlayer.put(participantName, numOfPlayer + 1);
    }
  }
}
