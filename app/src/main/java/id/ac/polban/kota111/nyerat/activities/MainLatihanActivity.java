package id.ac.polban.kota111.nyerat.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import id.ac.polban.kota111.nyerat.R;

public class MainLatihanActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_latihan);

        Button buttonMulai = findViewById(R.id.button_mulai);
        buttonMulai.setOnClickListener(this);
        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(this);
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_mulai:
                startActivity(new Intent(MainLatihanActivity.this, TampilanLatihanActivity.class));
                break;
            case R.id.button_back:
                finish();
                break;


        }
    }
}
