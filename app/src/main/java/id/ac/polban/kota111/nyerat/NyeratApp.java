package id.ac.polban.kota111.nyerat;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.rezkyatinnov.kyandroid.Kyandroid;
import com.rezkyatinnov.kyandroid.localdata.KyandroidRealmModule;
import com.rezkyatinnov.kyandroid.localdata.LocalData;
import com.rezkyatinnov.kyandroid.localdata.LocalDataNotFoundException;
import com.rezkyatinnov.kyandroid.localdata.QueryFilters;
import com.rezkyatinnov.kyandroid.session.Session;

import id.ac.polban.kota111.nyerat.activities.MainMenuActivity;
import id.ac.polban.kota111.nyerat.activities.SplashScreenActivity;
import id.ac.polban.kota111.nyerat.enums.Medal;
import id.ac.polban.kota111.nyerat.models.DataInitiator;
import id.ac.polban.kota111.nyerat.models.Exercise;
import id.ac.polban.kota111.nyerat.models.ExerciseItem;
import id.ac.polban.kota111.nyerat.models.NyeratRealmModule;

public class NyeratApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            Kyandroid.setDbKey("XWY9rKOhI6vQ1GDmhgJeebCX8gaRRQj0x7E0bvKLC9UxPIf8c1cgMN3MwMvwLvYX");
        } catch (Kyandroid.DbKeyWrongLengthException e) {
            e.printStackTrace();
        }
        Kyandroid.init(this,
                "http://api.example.com/",
                RestService.class,
                "NYERAT_PREFF",
                Context.MODE_PRIVATE,
                "NYERAT_DB",
                1,
                false,
                new KyandroidRealmModule(),
                new NyeratRealmModule());



        // bikin if data yang ada di exercise masih kosong (id)
        QueryFilters filters = new QueryFilters();
        filters.add("id", "exercise1");
        Exercise exercise1;
        try {
            exercise1 = LocalData.get(filters, Exercise.class);
        } catch (LocalDataNotFoundException e) {
            e.printStackTrace();

            DataInitiator.generateExerciseData();
            DataInitiator.generateExercise1ItemData();
            DataInitiator.generateExercise2ItemData();
            DataInitiator.generateExercise3ItemData();
            DataInitiator.generateExercise4ItemData();
            DataInitiator.generateExercise5ItemData();
            DataInitiator.generateExercise6ItemData();
        }

    }



}
