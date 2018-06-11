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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_latihan);

        Button buttonMulai = findViewById(R.id.button_mulai);
        buttonMulai.setOnClickListener(this);
        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(this);

        kontenHandler();
    }

    public void kontenHandler(){
        Intent intent = getIntent();
        String parseIdGampangPisan = intent.getExtras().getString("idGampangPisan");
        String parseMedalGampangPisan = intent.getExtras().getString("medalGampangPisan");
        long parseBTGampangPisan = intent.getExtras().getLong("btGampangPisan");


        String parseIdGampang = intent.getExtras().getString("idGampang");
        String parseMedalGampang = intent.getExtras().getString("medalGampang");
        long parseBtGampang = intent.getExtras().getLong("btGampang");

        String parseIdRadaSedeng = intent.getExtras().getString("idRadaSedeng");
        String parseMedalRadaSedeng = intent.getExtras().getString("medalRadaSedeng");
        long parseBtRadaSedeng = intent.getExtras().getLong("btRadaSedeng");

        String parseIdSedeng= intent.getExtras().getString("idSedeng");
        String parseMedalSedeng = intent.getExtras().getString("medalSedeng");
        long parseBtSedeng = intent.getExtras().getLong("btSedeng");

        String parseIdRadaHese = intent.getExtras().getString("idRadaHese");
        String parseMedalRadaHese = intent.getExtras().getString("medalRadaHese");
        long parseBtRadaHese = intent.getExtras().getLong("btRadaHese");

        String parseIdHese = intent.getExtras().getString("idHese");
        String parseMedalHese = intent.getExtras().getString("medalHese");
        long parseBtHese = intent.getExtras().getLong("btHese");

        ImageView gambarContent = findViewById(R.id.image_content_soal);
        ImageView gambarMedali = findViewById(R.id.image_medal);
        TextView teksBestTime = findViewById(R.id.teks_best_time);

        //deklarasi string sbg pembanding
        String idLatihan1 = "exercise1";
        String idLatihan2 = "exercise2";
        String idLatihan3 = "exercise3";
        String idLatihan4 = "exercise4";
        String idLatihan5 = "exercise5";
        String idLatihan6 = "exercise6";

        String medaliEmas = "SILVER";
        String medaliPerak = "SILVER";
        String medaliPerunggu = "BRONZE";
        String  medaliBelumAda = "BELUM ADA";

        if (idLatihan1.equals(parseIdGampangPisan)){
            gambarContent.setImageResource(R.drawable.gampang_pisan);
            teksBestTime.setText(String.valueOf(parseBTGampangPisan));

                if (parseMedalGampangPisan.equals(medaliBelumAda)){
                    gambarMedali.setImageResource(R.drawable.medal_null);
                } else
                    if(parseMedalGampangPisan.equals(medaliPerunggu)){
                    gambarMedali.setImageResource(R.drawable.medal_bronze);
                }else
                    if(parseMedalGampangPisan.equals(medaliPerak)){
                    gambarMedali.setImageResource(R.drawable.medal_silver);
                }else
                    if(parseMedalGampangPisan.equals(medaliEmas)){
                    gambarMedali.setImageResource(R.drawable.medal_gold);
                }


        } else if(idLatihan2.equals(parseIdGampang)){
            gambarContent.setImageResource(R.drawable.gampang);
            teksBestTime.setText(String.valueOf(parseBtGampang));

            if (parseMedalGampang.equals(medaliBelumAda)){
                gambarMedali.setImageResource(R.drawable.medal_null);
            } else
            if(parseMedalGampang.equals(medaliPerunggu)){
                gambarMedali.setImageResource(R.drawable.medal_bronze);
            }else
            if(parseMedalGampang.equals(medaliPerak)){
                gambarMedali.setImageResource(R.drawable.medal_silver);
            }else
            if(parseMedalGampang.equals(medaliEmas)){
                gambarMedali.setImageResource(R.drawable.medal_gold);
            }

        }else if(idLatihan3.equals(parseIdRadaSedeng)){
            teksBestTime.setText(String.valueOf(parseBtRadaSedeng));
            gambarContent.setImageResource(R.drawable.rada_sedeng);

            if (parseMedalRadaSedeng.equals(medaliBelumAda)){
                gambarMedali.setImageResource(R.drawable.medal_null);
            } else
            if(parseMedalRadaSedeng.equals(medaliPerunggu)){
                gambarMedali.setImageResource(R.drawable.medal_bronze);
            }else
            if(parseMedalRadaSedeng.equals(medaliPerak)){
                gambarMedali.setImageResource(R.drawable.medal_silver);
            }else
            if(parseMedalRadaSedeng.equals(medaliEmas)){
                gambarMedali.setImageResource(R.drawable.medal_gold);
            }
        }else if(idLatihan4.equals(parseIdSedeng)){
            gambarContent.setImageResource(R.drawable.sedeng);
            teksBestTime.setText(String.valueOf(parseBtSedeng));

            if (parseMedalSedeng.equals(medaliBelumAda)){
                gambarMedali.setImageResource(R.drawable.medal_null);
            } else
            if(parseMedalSedeng.equals(medaliPerunggu)){
                gambarMedali.setImageResource(R.drawable.medal_bronze);
            }else
            if(parseMedalSedeng.equals(medaliPerak)){
                gambarMedali.setImageResource(R.drawable.medal_silver);
            }else
            if(parseMedalSedeng.equals(medaliEmas)){
                gambarMedali.setImageResource(R.drawable.medal_gold);
            }
        }else if (idLatihan5.equals(parseIdRadaHese)){
            gambarContent.setImageResource(R.drawable.rada_hese);
            teksBestTime.setText(String.valueOf(parseBtRadaHese));

//            assert parseMedalRadaHese != null;
            if (parseMedalRadaHese.equals(medaliBelumAda)){
                gambarMedali.setImageResource(R.drawable.medal_null);
            } else
            if(parseMedalRadaHese.equals(medaliPerunggu)){
                gambarMedali.setImageResource(R.drawable.medal_bronze);
            }else
            if(parseMedalRadaHese.equals(medaliPerak)){
                gambarMedali.setImageResource(R.drawable.medal_silver);
            }else
            if(parseMedalRadaHese.equals(medaliEmas)){
                gambarMedali.setImageResource(R.drawable.medal_gold);
            }


        }else if (idLatihan6.equals(parseIdHese)){
            gambarContent.setImageResource(R.drawable.hese);
            teksBestTime.setText(String.valueOf(parseBtHese));

            if (parseMedalHese.equals(medaliBelumAda)){
                gambarMedali.setImageResource(R.drawable.medal_null);
            } else
            if(parseMedalHese.equals(medaliPerunggu)){
                gambarMedali.setImageResource(R.drawable.medal_bronze);
            }else
            if(parseMedalHese.equals(medaliPerak)){
                gambarMedali.setImageResource(R.drawable.medal_silver);
            }else
            if(parseMedalHese.equals(medaliEmas)){
                gambarMedali.setImageResource(R.drawable.medal_gold);
            }
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
        Intent intent = getIntent();

        String parseIdGampangPisan = intent.getExtras().getString("idGampangPisan");

        String parseIdGampang = intent.getExtras().getString("idGampang");

        String parseIdRadaSedeng = intent.getExtras().getString("idRadaSedeng");

        String parseIdSedeng = intent.getExtras().getString("idSedeng");
        String parseIdRadaHese = intent.getExtras().getString("idRadaHese");

        String parseIdHese = intent.getExtras().getString("idHese");



        if (parseIdGampangPisan != null) {
            Intent intentGampangPisan = new Intent(this, TampilanLatihanActivity.class);
            intentGampangPisan.putExtra("idGampangPisan", parseIdGampangPisan);
            startActivity(intentGampangPisan);
        } else if (parseIdGampang != null){
            Intent intentGampang = new Intent(this, TampilanLatihanActivity.class);
            intentGampang.putExtra("idGampang", parseIdGampang);
            startActivity(intentGampang);
        } else if (parseIdRadaSedeng != null){
            Intent intentRadaSedeng = new Intent(this, TampilanLatihanActivity.class);
            intentRadaSedeng.putExtra("idRadaSedeng", parseIdRadaSedeng);
            startActivity(intentRadaSedeng);
        }else if (parseIdSedeng != null){
            Intent intentSedeng = new Intent(this, TampilanLatihanActivity.class);
            intentSedeng.putExtra("idSedeng", parseIdSedeng);
            startActivity(intentSedeng);
        }else if (parseIdRadaHese != null){
            Intent intentRadaHese = new Intent(this, TampilanLatihanActivity.class);
            intentRadaHese.putExtra("idRadaHese", parseIdRadaHese);
            startActivity(intentRadaHese);
        }else if (parseIdHese != null){
            Intent intentHese = new Intent(this, TampilanLatihanActivity.class);
            intentHese.putExtra("idHese", parseIdHese);
            startActivity(intentHese);
        }
    }
}
