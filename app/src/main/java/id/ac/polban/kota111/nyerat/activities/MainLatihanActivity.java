package id.ac.polban.kota111.nyerat.activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.rezkyatinnov.kyandroid.localdata.LocalData;
import com.rezkyatinnov.kyandroid.localdata.LocalDataNotFoundException;
import com.rezkyatinnov.kyandroid.localdata.QueryFilters;

import id.ac.polban.kota111.nyerat.enums.Medal;
import id.ac.polban.kota111.nyerat.models.Exercise;
import id.ac.polban.kota111.nyerat.R;

public class MainLatihanActivity extends AppCompatActivity implements View.OnClickListener {


    ImageView gambarContent; //deklarasi var global gambar konten
    ImageView gambarMedali; //var global gambar medali
    TextView teksBestTime; // var global bestime
    String idExercise; //varglobal idexercise

    Exercise exercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_latihan);

        Button buttonMulai = findViewById(R.id.button_mulai);
        buttonMulai.setOnClickListener(this);
        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(this);


        init();
    }

    private void init() {

        Intent intent = getIntent();
        idExercise = intent.getExtras().getString("exerciseID");

        gambarContent = findViewById(R.id.image_content_soal);
        gambarMedali = findViewById(R.id.image_medal);
        teksBestTime = findViewById(R.id.teks_best_time);

        QueryFilters filters = new QueryFilters();
        filters.add("id", idExercise); //filter id

        try {
            exercise = LocalData.get(filters, Exercise.class);

            teksBestTime.setText(String.valueOf(exercise.getBestTime()));
            changeMedalImage(exercise);
            changeContentImage();

        } catch (LocalDataNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void changeContentImage() {
        if (idExercise.equalsIgnoreCase("exercise1")) {
            gambarContent.setImageResource(R.drawable.gampang_pisan);
        } else if (idExercise.equalsIgnoreCase("exercise2")) {
            gambarContent.setImageResource(R.drawable.gampang);
        } else if (idExercise.equalsIgnoreCase("exercise3")) {
            gambarContent.setImageResource(R.drawable.rada_sedeng);
        } else if (idExercise.equalsIgnoreCase("exercise4")) {
            gambarContent.setImageResource(R.drawable.sedeng);
        } else if (idExercise.equalsIgnoreCase("exercise5")) {
            gambarContent.setImageResource(R.drawable.rada_hese);
        } else if (idExercise.equalsIgnoreCase("exercise6")) {
            gambarContent.setImageResource(R.drawable.hese);
        }
    }

    private void changeMedalImage(Exercise exercise) {


        if (exercise.getMedal() == Medal.BRONZE) {
            gambarMedali.setImageResource(R.drawable.medal_bronze);
        } else if (exercise.getMedal() == Medal.SILVER) {
            gambarMedali.setImageResource(R.drawable.medal_silver);
        } else if (exercise.getMedal() == Medal.GOLD) {
            gambarMedali.setImageResource(R.drawable.medal_gold);
        } else {
            gambarMedali.setImageResource(R.drawable.medal_null);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_mulai:
                //startActivity(new Intent(MainLatihanActivity.this, TampilanLatihanActivity.class));
                mulaiHandler();
                break;
            case R.id.button_back:
                finish();
                break;


        }
    }

    private void mulaiHandler() {

        Intent intent = new Intent(this, TampilanLatihanActivity.class);
        intent.putExtra("exerciseID", idExercise); //parse string id
        intent.putExtra("itemNo", 1);
        startActivity(intent);

    }
}
