package id.ac.polban.kota111.nyerat.activities;

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

import id.ac.polban.kota111.nyerat.R;

import id.ac.polban.kota111.nyerat.AksaraClassifier;
import id.ac.polban.kota111.nyerat.PaintView;

public class TampilanLatihanActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String LABEL_FILE = "90-aksara-dasar-sundanese.txt";
    private static final String MODEL_FILE = "optimized_aksara_sunda_tensorflow.pb";

    private AksaraClassifier classifier;
    private PaintView paintView;
    private EditText resultText;
    private String[] currentTopLabels;
    public TextView kontenSoal;

    private int seconds = 0;
    private boolean startRun;

    //inisialisasi variabel
    public int scoreDidapat = 0;
    public int soalTampil = 1;

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
        startRun = true;
        Timer();

        resultText = (EditText) findViewById(R.id.editText);
        kontenSoal = (TextView) findViewById(R.id.teks_soal);

        //getSoal(soalTampil);

        loadModel();
    }

    public void soal1gampangPisan() {

    }

    public void getSoal(int a) {
        switch (a) {
            case 1:
                break;
        }
    }

    private void Timer() {
        final TextView timeView = (TextView) findViewById(R.id.stop_watch);
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
                timeView.setText(time);

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
                startRun = false;
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
        System.out.print(kunciJawaban);
        if (kunciJawaban.equals(inputJawaban)) {
            Toast.makeText(TampilanLatihanActivity.this,
                    "Jawaban Anda Benar", Toast.LENGTH_LONG).show();
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