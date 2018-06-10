package id.ac.polban.kota111.nyerat.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.support.annotation.Nullable;

import id.ac.polban.kota111.nyerat.NyeratApp;
import id.ac.polban.kota111.nyerat.R;

public class SplashScreenActivity extends Activity {

    protected int _splashTime = 2000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);

        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this,
                        MainMenuActivity.class));
                finish();
            }
        }, secondsDelayed * 1000);




    }

}