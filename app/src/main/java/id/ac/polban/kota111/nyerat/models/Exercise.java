package id.ac.polban.kota111.nyerat.models;

import id.ac.polban.kota111.nyerat.enums.Medal;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Exercise extends RealmObject {

    @PrimaryKey
    private String id;
    private String medal;
    private long bestTime;

    public Exercise(String id, String medal, long bestTime) {
        this.id = id;
        this.medal = medal;
        this.bestTime = bestTime;
    }

    public Exercise() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Medal getMedal() {
        return Medal.valueOf(medal);
    }

    public void setMedal(Medal medal) {
        this.medal = medal.medal();
    }

    public long getBestTime() {
        return bestTime;
    }

    public void setBestTime(long bestTime) {
        this.bestTime = bestTime;
    }
}
