package id.ac.polban.kota111.nyerat.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ExerciseItem extends RealmObject {

    @PrimaryKey
    private String id;
    private Exercise exercise;
    private int itemNo;
    private String itemText; //soal latin
    private String itemAnswer; //jawaban aksara sunda buat di compare / kunci jawaban
    private long timeElapsed;
    private int stars;

    public ExerciseItem(String id, Exercise exercise, int itemNo, String itemText, String itemAnswer, long timeElapsed, int stars) {
        this.id = id;
        this.exercise = exercise;
        this.itemNo = itemNo;
        this.itemText = itemText;
        this.itemAnswer = itemAnswer;
        this.timeElapsed = timeElapsed;
        this.stars = stars;
    }

    public ExerciseItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public String getItemAnswer() {
        return itemAnswer;
    }

    public void setItemAnswer(String itemAnswer) {
        this.itemAnswer = itemAnswer;
    }

    public long getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(long timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
