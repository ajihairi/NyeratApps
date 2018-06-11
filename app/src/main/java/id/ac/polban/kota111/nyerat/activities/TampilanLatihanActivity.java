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

import id.ac.polban.kota111.nyerat.R;

import id.ac.polban.kota111.nyerat.AksaraClassifier;
import id.ac.polban.kota111.nyerat.PaintView;
import id.ac.polban.kota111.nyerat.models.ExerciseItem;

public class TampilanLatihanActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String LABEL_FILE = "90-aksara-dasar-sundanese.txt";
    private static final String MODEL_FILE = "optimized_aksara_sunda_tensorflow.pb";

    private AksaraClassifier classifier;
    private PaintView paintView;
    private EditText resultText;
    private String[] currentTopLabels;
    //public TextView kontenSoal;
    public TextView TimeView;

    private int seconds = 0;
    private boolean startRun;

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

        paintView = (PaintView) findViewById(R.id.paintView);

        TextView drawHereText = (TextView) findViewById(R.id.drawHere);
        paintView.setDrawText(drawHereText);

        Button clearButton = (Button) findViewById(R.id.buttonClear);
        clearButton.setOnClickListener(this);

        Button classifyButton = (Button) findViewById(R.id.buttonClassify);
        classifyButton.setOnClickListener(this);

        ImageButton backButton = (ImageButton) findViewById(R.id.back_button);
        backButton.setOnClickListener(this);

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            startRun = savedInstanceState.getBoolean("startRun");
        }
        kontenHandler();
        startRun = true;
        Timer();

        resultText = (EditText) findViewById(R.id.editText);
//        kontenSoal = (TextView) findViewById(R.id.teks_soal);
        TimeView = (TextView) findViewById(R.id.stop_watch);
        //getSoal(soalTampil);

        loadModel();


    }

    public void kontenHandler(){
        Intent intent = getIntent();

        String parseIdGampangPisan = intent.getExtras().getString("idGampangPisan");
        String parseIdGampang = intent.getExtras().getString("idGampang");
        String parseIdRadaSedeng = intent.getExtras().getString("idRadaSedeng");

        String parseIdSedeng = intent.getExtras().getString("idSedeng");
        String parseIdRadaHese = intent.getExtras().getString("idRadaHese");

        String parseIdHese = intent.getExtras().getString("idHese");

        TextView kontenSoal = (TextView) findViewById(R.id.teks_soal);

        final String teksSoal;
        final String idSoal;
        final String teksJawaban;

        ExerciseItem exerciseItem;

        QueryFilters filterExerciseItem = new QueryFilters();

        if (parseIdGampangPisan != null){
            filterExerciseItem.add("id", "exercise1item1");

            try {
                exerciseItem = LocalData.get(filterExerciseItem, ExerciseItem.class);
                idSoal = exerciseItem.getId();
                teksSoal = exerciseItem.getItemText();

                kontenSoal.setText(teksSoal);

            } catch (LocalDataNotFoundException e) {
                e.printStackTrace();
            }
        } else if(parseIdGampang != null){
            filterExerciseItem.add("id", "exercise2item1");


            try {
                exerciseItem = LocalData.get(filterExerciseItem, ExerciseItem.class);
                teksSoal = exerciseItem.getItemText();

                kontenSoal.setText(teksSoal);
            } catch (LocalDataNotFoundException e) {
                e.printStackTrace();
            }

        } else if (parseIdRadaSedeng != null){
            filterExerciseItem.add("id", "exercise3item1");
            try {
                exerciseItem = LocalData.get(filterExerciseItem, ExerciseItem.class);
                teksSoal = exerciseItem.getItemText();

                kontenSoal.setText(teksSoal);
            } catch (LocalDataNotFoundException e) {
                e.printStackTrace();
            }

        }else if (parseIdSedeng != null){
            filterExerciseItem.add("id", "exercise4item1");

            try {
                exerciseItem = LocalData.get(filterExerciseItem, ExerciseItem.class);
                teksSoal = exerciseItem.getItemText();

                kontenSoal.setText(teksSoal);
            } catch (LocalDataNotFoundException e) {
                e.printStackTrace();
            }

        }else if (parseIdRadaHese != null){
            filterExerciseItem.add("id", "exercise5item1");

            try {
                exerciseItem = LocalData.get(filterExerciseItem, ExerciseItem.class);
                teksSoal = exerciseItem.getItemText();

                kontenSoal.setText(teksSoal);
            } catch (LocalDataNotFoundException e) {
                e.printStackTrace();
            }

        }else  if (parseIdHese != null){
            filterExerciseItem.add("id", "exercise6item1");

            try {
                exerciseItem = LocalData.get(filterExerciseItem, ExerciseItem.class);
                teksSoal = exerciseItem.getItemText();

                kontenSoal.setText(teksSoal);
            } catch (LocalDataNotFoundException e) {
                e.printStackTrace();
            }

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
        String kunciJawaban = "ᮟᮧ"; //string buat kunci jawaban
        if (kunciJawaban.equals(inputJawaban)) {
            Toast.makeText(TampilanLatihanActivity.this,
                    "Jawaban Anda Benar", Toast.LENGTH_LONG).show();
            startRun = false;

        } else {
            Toast.makeText(TampilanLatihanActivity.this,
                    "Jawaban Anda Salah", Toast.LENGTH_LONG).show();
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