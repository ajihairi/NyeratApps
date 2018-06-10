package id.ac.polban.kota111.nyerat.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.os.Handler;


import id.ac.polban.kota111.nyerat.R;
import id.ac.polban.kota111.nyerat.activities.MainLatihanActivity;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        getSupportActionBar().setTitle("Nyerat Aksara Sunda");

        Button buttonGampangPisan = (Button) findViewById(R.id.button_gampang_pisan);
        buttonGampangPisan.setOnClickListener((View.OnClickListener) this);

        Button buttonGampang = (Button) findViewById(R.id.button_gampang);
        buttonGampang.setOnClickListener(this);

        Button buttonRadaSedeng = (Button) findViewById(R.id.button_rada_sedeng);
        buttonRadaSedeng.setOnClickListener(this);

        Button buttonSedeng = (Button) findViewById(R.id.button_sedeng);
        buttonSedeng.setOnClickListener(this);

        Button buttonRadaHese = (Button) findViewById(R.id.button_rada_hese);
        buttonRadaHese.setOnClickListener(this);

        Button buttonHese = (Button) findViewById(R.id.button_hese);
        buttonHese.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                startActivity(new Intent(MainMenuActivity.this,AboutActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_gampang_pisan:
                startActivity(new Intent(MainMenuActivity.this, MainLatihanActivity.class));
                break;
            case R.id.button_gampang:
                startActivity(new Intent(MainMenuActivity.this, MainLatihanActivity.class));
                break;
            case R.id.button_rada_sedeng:
                startActivity(new Intent(MainMenuActivity.this, MainLatihanActivity.class));
                break;
            case R.id.button_sedeng:
                startActivity(new Intent(MainMenuActivity.this, MainLatihanActivity.class));
                break;
            case R.id.button_rada_hese:
                startActivity(new Intent(MainMenuActivity.this, MainLatihanActivity.class));
                break;
            case R.id.button_hese:
                startActivity(new Intent(MainMenuActivity.this, MainLatihanActivity.class));
                break;


        }
    }
}
