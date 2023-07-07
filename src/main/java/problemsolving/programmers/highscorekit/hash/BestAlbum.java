package problemsolving.programmers.highscorekit.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestAlbum {
  // Problem : https://school.programmers.co.kr/learn/courses/30/lessons/42579

  public int[] solution(String[] gerneNames, int[] musicPlays) {
    Map<String, Genre> nameToGenre = new HashMap<>();
    fillMusic(gerneNames, musicPlays, nameToGenre);

    return getBestAlbum(nameToGenre);
  }

  private int[] getBestAlbum(Map<String, Genre> nameToGenre) {
    List<Music> bestAlbum = new ArrayList<>();
    List<Genre> genres = new ArrayList<>(nameToGenre.values());
    Collections.sort(genres);

    for (Genre genre : genres) {
      bestAlbum.add(genre.getBestMusic(0));
      if (genre.getMusicList().size() > 1) {
        bestAlbum.add(genre.getBestMusic(1));
      }
    }
    return bestAlbum.stream().mapToInt(Music::getId).toArray();
  }

  private void fillMusic(String[] gerneNames, int[] musicPlays, Map<String, Genre> nameToGenre) {
    for (int id = 0; id < gerneNames.length; id++) {
      String gerneName = gerneNames[id];
      int plays = musicPlays[id];

      Music newMusic = new Music(id, plays);

      Genre genre = nameToGenre.computeIfAbsent(gerneName, Genre::new);
      genre.addMusic(newMusic);
    }
  }

  private class Music implements Comparable<Music> {
    private final int id;
    private final int plays;

    private Music(int id, int plays) {
      this.id = id;
      this.plays = plays;
    }

    public int getId() {
      return id;
    }

    public int getPlays() {
      return plays;
    }

    @Override
    public int compareTo(Music other) {
      if (this.plays == other.getPlays()) {
        return this.id - other.getId(); // 오름차순
      }
      return -(this.plays - other.getPlays()); // 내림차순
    }
  }

  private class Genre implements Comparable<Genre> {
    private final String name;
    private int plays = 0;

    private List<Music> musicList = new ArrayList<>();

    private Genre(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public int getPlays() {
      return plays;
    }

    public List<Music> getMusicList() {
      return musicList;
    }

    public void addMusic(Music newMusic) {
      musicList.add(newMusic);
      this.plays += newMusic.plays;
    }

    @Override
    public int compareTo(Genre other) {
      return -(this.plays - other.getPlays()); // 내림차순
    }

    public Music getBestMusic(int idx) {
      Music[] sortedMusicList = musicList.toArray(new Music[0]);
      Arrays.sort(sortedMusicList);
      return sortedMusicList[idx];
    }
  }
}
