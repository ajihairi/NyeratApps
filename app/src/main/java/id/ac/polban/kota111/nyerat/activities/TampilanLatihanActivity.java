package id.ac.polban.kota111.nyerat.activities;

import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.rezkyatinnov.kyandroid.localdata.LocalData;
import com.rezkyatinnov.kyandroid.localdata.LocalDataNotFoundException;
import com.rezkyatinnov.kyandroid.localdata.QueryFilters;

import org.w3c.dom.Text;

import java.util.List;

import id.ac.polban.kota111.nyerat.R;

import id.ac.polban.kota111.nyerat.AksaraClassifier;
import id.ac.polban.kota111.nyerat.PaintView;
import id.ac.polban.kota111.nyerat.enums.Medal;
import id.ac.polban.kota111.nyerat.models.Exercise;
import id.ac.polban.kota111.nyerat.models.ExerciseItem;
import io.realm.Realm;
import io.realm.RealmResults;

public class TampilanLatihanActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String LABEL_FILE = "90-aksara-dasar-sundanese.txt";
    private static final String MODEL_FILE = "optimized_aksara_sunda_tensorflow.pb";

    private AksaraClassifier classifier;
    private PaintView paintView;
    private EditText resultText;
    private String[] currentTopLabels;
    //public TextView kontenSoal;
    public TextView TimeView;
    public TextView SkorView;

    private int seconds = 0;
    private boolean startRun;

    String idExercise;
    String kunciJawaban;
    int itemNo;

    Exercise exercise;
    ExerciseItem exerciseItem;


    TextView kontenSoal;
    TextView drawHereText;
    Button clearButton;
    Button classifyButton;
    ImageButton backButton;
//
//    //inisialisasi variabel
//    public int scoreDidapat = 0;
//    public int soalTampil = 1;

    /**
     * This is called when the application is first initialized/started. Basic setup logic is
     * performed here.
     *
     * @param savedInstanceState Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tampilan_latihan);

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            startRun = savedInstanceState.getBoolean("startRun");
        }

        Intent intent = getIntent();
        idExercise = intent.getExtras().getString("exerciseID");
        itemNo = intent.getExtras().getInt("itemNo");

        initView();
        init();

//        kontenHandler();
        startRun = true;
        Timer();

        resultText = (EditText) findViewById(R.id.editText);
//        kontenSoal = (TextView) findViewById(R.id.teks_soal);
        TimeView = (TextView) findViewById(R.id.stop_watch);
        SkorView = findViewById(R.id.teks_skor);
        //getSoal(soalTampil);

        loadModel();


    }

    private void initView(){

        kontenSoal = (TextView) findViewById(R.id.teks_soal);
        paintView = (PaintView) findViewById(R.id.paintView);

        drawHereText = (TextView) findViewById(R.id.drawHere);
        paintView.setDrawText(drawHereText);

        clearButton = (Button) findViewById(R.id.buttonClear);
        clearButton.setOnClickListener(this);

        classifyButton = (Button) findViewById(R.id.buttonClassify);
        classifyButton.setOnClickListener(this);

        backButton = (ImageButton) findViewById(R.id.back_button);
        backButton.setOnClickListener(this);
    }

    private void init(){
        QueryFilters filters = new QueryFilters();
        filters.add("id", idExercise); //filter id

        try {
            exercise = LocalData.get(filters, Exercise.class);


            filters = new QueryFilters();
            filters.add("itemNo", itemNo); //filter id
            List<ExerciseItem> exerciseItems = LocalData.getList(filters, ExerciseItem.class);

            for(ExerciseItem item:exerciseItems){
                if(item.getExercise().getId().equalsIgnoreCase(idExercise)) {
                    exerciseItem = item;
                    kontenSoal.setText(exerciseItem.getItemText());
                    kunciJawaban = exerciseItem.getItemAnswer();
                }
            }

        } catch (LocalDataNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void Timer() {

        //final TextView  elapsedTime = (TextView)findViewById(R.id.elapsed_time);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

//                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                String time = String.format("%02d:%02d", minutes, secs);
                TimeView.setText(time);

                //int elapsedTimee = secs;
                //String waktunya = String.format("waktu yang didapat %02d", elapsedTimee);
                //elapsedTime.setText(waktunya);

                if (startRun) {
                    seconds++;
                } else if (startRun = false) {

                }

                handler.postDelayed(this, 500);
            }
        });

    }

    /**
     * This method is called when the user clicks a button in the view.
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonClear:
                lanjut();
                startRun = true;
                seconds = 0;
                itemNo =itemNo+1;
                if(itemNo>10){
                    countMedal();
                    finish();
                }else {
                    init();
                }
                break;
            case R.id.buttonClassify:
                cekJawaban();
                paintView.reset();
                paintView.invalidate();
                break;

            case R.id.back_button:
                finish();
                break;
        }
    }

    /**
     * Clear the text and drawing to return to the beginning state.
     */
    private void lanjut() {
        paintView.reset();
        paintView.invalidate();
        resultText.setText("");
    }

    /**
     * Perform the classification, updating UI elements with the results.
     */
    private void cekJawaban() {
        float pixels[] = paintView.getPixelData();
        currentTopLabels = classifier.classify(pixels);
        resultText.append(currentTopLabels[0]); //outputnya nanti dimasukin ke variable inputjawaban
        String inputJawaban = resultText.getText().toString();
        if (kunciJawaban.equals(inputJawaban)) {
            Toast.makeText(TampilanLatihanActivity.this,
                    "Jawaban Anda Benar", Toast.LENGTH_LONG).show();
            exerciseItem.setTimeElapsed(seconds);
            exerciseItem.setStars(countStars(seconds));

            LocalData.saveOrUpdate(exerciseItem);
            startRun = false;

        } else {
            Toast.makeText(TampilanLatihanActivity.this,
                    "Jawaban Anda Salah", Toast.LENGTH_LONG).show();
        }

    }

    protected int countStars(long seconds){
        if (seconds <= 30 ){
            return 2;
        } else {
            return 1;
        }
    }

    protected void countMedal(){
        try {
            QueryFilters filters = new QueryFilters();
            filters.add("exercise.id", idExercise); //filter id
            List<ExerciseItem> exerciseItems = LocalData.getList(filters, ExerciseItem.class);

            int countStars = 0;
            long bestTime = 999999999;
            for(ExerciseItem item:exerciseItems){
                countStars = countStars + item.getStars();
                if(item.getTimeElapsed()>0 && item.getTimeElapsed()<bestTime){
                    bestTime = item.getTimeElapsed();
                }
            }

            exercise.setMedal(countStars>16?Medal.GOLD:countStars>10?Medal.SILVER:Medal.BRONZE);
            exercise.setBestTime(bestTime);

            LocalData.saveOrUpdate(exercise);

        } catch (LocalDataNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onResume() {
        paintView.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        paintView.onPause();
        super.onPause();
    }

    /**
     * Load pre-trained model in memory.
     */
    private void loadModel() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    classifier = AksaraClassifier.create(getAssets(),
                            MODEL_FILE, LABEL_FILE, PaintView.FEED_DIMENSION,
                            "input", "keep_prob", "output");
                } catch (final Exception e) {
                    throw new RuntimeException("Error loading pre-trained model.", e);
                }
            }
        }).start();
    }
}