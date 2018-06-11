package id.ac.polban.kota111.nyerat.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.os.Handler;
import id.ac.polban.kota111.nyerat.models.Exercise;

import com.rezkyatinnov.kyandroid.localdata.LocalData;
import com.rezkyatinnov.kyandroid.localdata.LocalDataNotFoundException;
import com.rezkyatinnov.kyandroid.localdata.QueryFilters;
import id.ac.polban.kota111.nyerat.NyeratApp;


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
        Intent intent;
        switch (view.getId()) {
            case R.id.button_gampang_pisan:
                intent = new Intent(this, MainLatihanActivity.class);
                intent.putExtra("exerciseID", "exercise1"); //parse string id
                startActivity(intent);

                break;
            case R.id.button_gampang:
                intent = new Intent(this, MainLatihanActivity.class);
                intent.putExtra("exerciseID", "exercise2"); //parse string id
                startActivity(intent);
                break;
            case R.id.button_rada_sedeng:
                intent = new Intent(this, MainLatihanActivity.class);
                intent.putExtra("exerciseID", "exercise3"); //parse string id
                startActivity(intent);
                break;
            case R.id.button_sedeng:
                intent = new Intent(this, MainLatihanActivity.class);
                intent.putExtra("exerciseID", "exercise4"); //parse string id
                startActivity(intent);
                break;
            case R.id.button_rada_hese:
                intent = new Intent(this, MainLatihanActivity.class);
                intent.putExtra("exerciseID", "exercise5"); //parse string id
                startActivity(intent);
                break;
            case R.id.button_hese:
                intent = new Intent(this, MainLatihanActivity.class);
                intent.putExtra("exerciseID", "exercise5"); //parse string id
                startActivity(intent);
                break;


        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainMenuActivity.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Anjeun yakin badé kaluar ti aplikasi?")
                .setCancelable(false)
                .setPositiveButton("Muhun", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("Alim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
}
