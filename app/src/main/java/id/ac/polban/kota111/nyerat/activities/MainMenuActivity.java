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

        QueryFilters filtersMedal = new QueryFilters(); //deklarasi queri untuk medal
        QueryFilters filterBestTime = new QueryFilters(); //filterBestime


        switch (view.getId()) {
            case R.id.button_gampang_pisan:
                //startActivity(new Intent(MainMenuActivity.this, MainLatihanActivity.class));

                QueryFilters filters = new QueryFilters();
                filters.add("id", "exercise1"); //filter id
                filtersMedal.add("medal", "BELUM ADA"); //filter medal

                Exercise exercise1;
                final String parseIdGampangPisan; //string param id
                final String parseMedalGampangPisan; //STRING PARAM gambar medal
                final long parseBTGampangPisan; //String param besttime
                try {
                    exercise1 = LocalData.get(filters, Exercise.class);

                    parseIdGampangPisan = exercise1.getId();//get string id
                    parseMedalGampangPisan = exercise1.getMedal(); // get string medal
                    parseBTGampangPisan = exercise1.getBestTime(); //get Long BestTime
                    Intent intentGampangPisan = new Intent(this, MainLatihanActivity.class);
                    intentGampangPisan.putExtra("idGampangPisan", parseIdGampangPisan); //parse string id
                    intentGampangPisan.putExtra("medalGampangPisan", parseMedalGampangPisan); //parse string medal
                    intentGampangPisan.putExtra("btGampangPisan", parseBTGampangPisan); //parse long besttime
                    startActivity(intentGampangPisan);
                } catch (LocalDataNotFoundException e) {
                    e.printStackTrace();
                }

                break;
            case R.id.button_gampang:
                QueryFilters filters2 = new QueryFilters();
                filters2.add("id", "exercise2");
                filtersMedal.add("medal", "BELUM ADA");
                Exercise exercise2;
                final String parseIdGampang;
                final String parseMedalGampang;
                final long parseBtGampang;
                try {
                    exercise2 = LocalData.get(filters2, Exercise.class);
                    parseIdGampang = exercise2.getId();
                    parseMedalGampang = exercise2.getMedal();
                    parseBtGampang = exercise2.getBestTime();
                    Intent intentGampang = new Intent(this, MainLatihanActivity.class);
                    intentGampang.putExtra("idGampang", parseIdGampang);
                    intentGampang.putExtra("medalGampang", parseMedalGampang);
                    intentGampang.putExtra("btGampang", parseBtGampang);
                    startActivity(intentGampang);
                } catch (LocalDataNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button_rada_sedeng:
                QueryFilters filters3 = new QueryFilters();
                filters3.add("id", "exercise3");
                filtersMedal.add("medal","BELUM ADA");
                Exercise exercise3;
                final String parseIdRadaSedeng;
                final String  parseMedalRadaSedeng;
                final long parseBtRadaSedeng;
                try {
                    exercise3 = LocalData.get(filters3, Exercise.class);
                    parseIdRadaSedeng = exercise3.getId().toString();
                    parseMedalRadaSedeng = exercise3.getMedal();
                    parseBtRadaSedeng = exercise3.getBestTime();
                    Intent intentRadaSedeng = new Intent(this, MainLatihanActivity.class);
                    intentRadaSedeng.putExtra("idRadaSedeng", parseIdRadaSedeng);
                    intentRadaSedeng.putExtra("medalRadaSedeng", parseMedalRadaSedeng);
                    intentRadaSedeng.putExtra("btRadaSedeng", parseBtRadaSedeng);
                    startActivity(intentRadaSedeng);
                } catch (LocalDataNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button_sedeng:
                QueryFilters filters4 = new QueryFilters();
                filters4.add("id", "exercise4");
                filtersMedal.add("medal", "BELUM ADA");
                Exercise exercise4;
                final String parseIdSedeng;
                final String parseMedalSedeng;
                final long parseBtSedeng;
                try {
                    exercise4 = LocalData.get(filters4, Exercise.class);
                    parseIdSedeng = exercise4.getId().toString();
                    parseMedalSedeng = exercise4.getMedal();
                    parseBtSedeng = exercise4.getBestTime();
                    Intent intentSedeng = new Intent(this, MainLatihanActivity.class);
                    intentSedeng.putExtra("idSedeng", parseIdSedeng);
                    intentSedeng.putExtra("medalSedeng", parseMedalSedeng);
                    intentSedeng.putExtra("btSedeng", parseBtSedeng);
                    startActivity(intentSedeng);
                } catch (LocalDataNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button_rada_hese:
                QueryFilters filters5 = new QueryFilters();
                filters5.add("id", "exercise5");
                Exercise exercise5;
                final String parseIdRadaHese;
                final String parseMedalRadaHese;
                final long parseBtRadaHese;
                try {
                    exercise5 = LocalData.get(filters5, Exercise.class);
                    parseIdRadaHese = exercise5.getId().toString();
                    parseMedalRadaHese = exercise5.getMedal();
                    parseBtRadaHese = exercise5.getBestTime();
                    Intent intentRadaHese = new Intent(this, MainLatihanActivity.class);
                    intentRadaHese.putExtra("idRadaHese", parseIdRadaHese);
                    intentRadaHese.putExtra("medalRadaHese",parseMedalRadaHese );
                    intentRadaHese.putExtra("btRadaHese", parseBtRadaHese);
                    startActivity(intentRadaHese);
                } catch (LocalDataNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button_hese:
                QueryFilters filters6 = new QueryFilters();
                filters6.add("id", "exercise6");
                Exercise exercise6;
                final String parseIdHese;
                final String parseMedalHese;
                final long parseBtHese;
                try {
                    exercise6 = LocalData.get(filters6, Exercise.class);
                    parseIdHese = exercise6.getId().toString();
                    parseMedalHese = exercise6.getMedal();
                    parseBtHese = exercise6.getBestTime();
                    Intent intentHese = new Intent(this, MainLatihanActivity.class);
                    intentHese.putExtra("idHese", parseIdHese);
                    intentHese.putExtra("medalHese", parseMedalHese);
                    intentHese.putExtra("btHese", parseBtHese);
                    startActivity(intentHese);
                } catch (LocalDataNotFoundException e) {
                    e.printStackTrace();
                }break;


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
