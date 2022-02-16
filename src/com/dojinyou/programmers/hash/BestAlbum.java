import java.util.*;

// 프로그래머스 : 코딩테스트 연습 > 해시 > 베스트앨범
// 관련 링크 : https://programmers.co.kr/learn/courses/30/lessons/42579

class BestAlbum {
    public int[] solution(String[] gerneNames, int[] musicPlays) {
        Hashtable<String, Gerne> gerneTable = new Hashtable<String, Gerne>();
        for (int i = 0; i<gerneNames.length; i++) {
            String gerneName = gerneNames[i];
            int musicID = i;
            int musicPlay = musicPlays[i];

            Music newMusic = new Music(i, musicPlay);
            Gerne gerne = gerneTable.containsKey(gerneName)
                    ? gerneTable.get(gerneName)
                    : new Gerne(gerneName);
            gerne.addMusic(newMusic);

            gerneTable.put(gerneName, gerne);
        }
        ArrayList<Gerne> gernes = new ArrayList<Gerne>(gerneTable.values());
        Collections.sort(gernes);
        List<Integer> bestMusicIDs = new ArrayList<>();
        for (Gerne gerne : gernes) {
            bestMusicIDs.addAll(gerne.getBestMusics(2));
        }
        return bestMusicIDs.stream().mapToInt(i->i).toArray();
    }
}
class Gerne implements Comparable<Gerne>{
    private final String NAME;
    private ArrayList<Music> musicList;
    private int plays;

    Gerne(String name) {
        this.NAME = name;
        this.musicList = new ArrayList<>();
        this.plays = 0;
    }
    public String getName() {return NAME;}
    public Music[] getMusicList() {
        return musicList.toArray(
                new Music[this.getSongCount()]
        );
    }
    public int getPlays() {return plays;}
    public int getSongCount() {return musicList.size();}

    public boolean addMusic(Music newMusic) {
        if (this.contains(newMusic)){
            return false;
        }
        musicList.add(newMusic);
        plays += newMusic.getPlays();
        return true;
    }
    public boolean contains(Music music) {
        return musicList.contains(music);
    }

    public List<Integer> getBestMusics(int num) {
        List<Integer> bestMusicIDs = new ArrayList<>();
        List<Music> sortedList = new ArrayList<>(this.musicList);
        Collections.sort(sortedList);
        for (int i =0; i < Math.min(num, sortedList.size()); i++) {
            bestMusicIDs.add(sortedList.get(i).getID());
        }
        return bestMusicIDs;
    }

    public String toString() {
        return this.getName() + ":" +this.getPlays();
    }

    @Override
    public int compareTo(Gerne other) {
        return -(this.getPlays() - other.getPlays());
    }
}
class Music implements Comparable<Music> {
    private final int ID;
    private int plays;

    Music(int id){
        this(id, 0);
    }
    Music(int id, int plays) {
        this.ID = id;
        this.plays = plays;
    }

    public int getID() {return this.ID;}
    public int getPlays() {return this.plays;}
    public void play() {this.plays++;}

    public String toString() {return Integer.toString(this.getID());}
    @Override
    public int compareTo(Music other) {
        if (other.getPlays() != this.getPlays()) {
            // plays의 내림차순으로 정렬
            return -(this.getPlays() - other.getPlays());
        }
        // plays가 같다면 ID의 오름차순으로 정렬
        return this.getID() - other.getID();
    }
}