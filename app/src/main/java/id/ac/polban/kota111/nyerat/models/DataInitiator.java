package id.ac.polban.kota111.nyerat.models;

import com.rezkyatinnov.kyandroid.localdata.LocalData;
import com.rezkyatinnov.kyandroid.localdata.LocalDataNotFoundException;
import com.rezkyatinnov.kyandroid.localdata.QueryFilters;

import id.ac.polban.kota111.nyerat.enums.Medal;

public class DataInitiator {

    public static void generateExerciseData(){
        Exercise exercise1  = new Exercise();
        Exercise exercise2  = new Exercise();
        Exercise exercise3  =   new Exercise();
        Exercise exercise4  =   new Exercise();
        Exercise exercise5  =   new Exercise();
        Exercise exercise6  =   new Exercise();

        exercise1.setId("exercise1");
//        exercise1.setMedal(Medal.BELUMADA);
        exercise1.setMedal("BELUM ADA");
        exercise1.setBestTime(0);
        LocalData.saveOrUpdate(exercise1);

        exercise2.setId("exercise2");
        exercise2.setMedal("BELUM ADA");
        exercise2.setBestTime(0);
        LocalData.saveOrUpdate(exercise2);

        exercise3.setId("exercise3");
        exercise3.setMedal("BELUM ADA");
        exercise3.setBestTime(0);
        LocalData.saveOrUpdate(exercise3);

        exercise4.setId("exercise4");
        exercise4.setMedal("BELUM ADA");
        exercise4.setBestTime(0);
        LocalData.saveOrUpdate(exercise4);

        exercise5.setId("exercise5");
        exercise5.setMedal("BELUM ADA");
        exercise5.setBestTime(0);
        LocalData.saveOrUpdate(exercise5);

        exercise6.setId("exercise6");
        exercise6.setMedal("NULL");
        exercise6.setBestTime(0);
        LocalData.saveOrUpdate(exercise6);

    }

    public static void generateExercise1ItemData(){
        ExerciseItem exercise1Item1     = new ExerciseItem();
        ExerciseItem exercise1Item2     = new ExerciseItem();
        ExerciseItem exercise1Item3     = new ExerciseItem();
        ExerciseItem exercise1Item4     = new ExerciseItem();
        ExerciseItem exercise1Item5     = new ExerciseItem();
        ExerciseItem exercise1Item6     = new ExerciseItem();
        ExerciseItem exercise1Item7     = new ExerciseItem();
        ExerciseItem exercise1Item8     = new ExerciseItem();
        ExerciseItem exercise1Item9     = new ExerciseItem();
        ExerciseItem exercise1Item10    = new ExerciseItem();

        exercise1Item1.setId("exercise1item1");
        exercise1Item1.setItemNo(1);
        exercise1Item1.setItemText("A");
        exercise1Item1.setItemAnswer("ᮃ");
        LocalData.saveOrUpdate(exercise1Item1);

        exercise1Item2.setId("exercise1item2");
        exercise1Item2.setItemNo(2);
        exercise1Item2.setItemText("I");
        exercise1Item2.setItemAnswer("ᮄ");
        LocalData.saveOrUpdate(exercise1Item2);

        exercise1Item3.setId("exercise1item3");
        exercise1Item3.setItemNo(3);
        exercise1Item3.setItemText("VA");
        exercise1Item3.setItemAnswer("ᮗ");
        LocalData.saveOrUpdate(exercise1Item3);

        exercise1Item4.setId("exercise1item4");
        exercise1Item4.setItemNo(4);
        exercise1Item4.setItemText("HA");
        exercise1Item4.setItemAnswer("ᮠ");
        LocalData.saveOrUpdate(exercise1Item4);

        exercise1Item5.setId("exercise1item5");
        exercise1Item5.setItemNo(5);
        exercise1Item5.setItemText("E");
        exercise1Item5.setItemAnswer("ᮈ");
        LocalData.saveOrUpdate(exercise1Item5);

        exercise1Item6.setId("exercise1item6");
        exercise1Item6.setItemNo(6);
        exercise1Item6.setItemText("HA");
        exercise1Item6.setItemAnswer("ᮠ");
        LocalData.saveOrUpdate(exercise1Item6);

        exercise1Item7.setId("exercise1item7");
        exercise1Item7.setItemNo(7);
        exercise1Item7.setItemText("U");
        exercise1Item7.setItemAnswer("ᮅ");
        LocalData.saveOrUpdate(exercise1Item7);

        exercise1Item8.setId("exercise1item8");
        exercise1Item8.setItemNo(8);
        exercise1Item8.setItemText("VA");
        exercise1Item8.setItemAnswer("ᮗ");
        LocalData.saveOrUpdate(exercise1Item8);

        exercise1Item9.setId("exercise1item9");
        exercise1Item9.setItemNo(9);
        exercise1Item9.setItemText("0");
        exercise1Item9.setItemAnswer("᮰");
        LocalData.saveOrUpdate(exercise1Item9);

        exercise1Item10.setId("exercise1item9");
        exercise1Item10.setItemNo(10);
        exercise1Item10.setItemText("U");
        exercise1Item10.setItemAnswer("ᮅ");
        LocalData.saveOrUpdate(exercise1Item10);

    }
    public static void generateExercise2ItemData(){
        ExerciseItem exercise2Item1     = new ExerciseItem();
        ExerciseItem exercise2Item2     = new ExerciseItem();
        ExerciseItem exercise2Item3     = new ExerciseItem();
        ExerciseItem exercise2Item4     = new ExerciseItem();
        ExerciseItem exercise2Item5     = new ExerciseItem();
        ExerciseItem exercise2Item6     = new ExerciseItem();
        ExerciseItem exercise2Item7     = new ExerciseItem();
        ExerciseItem exercise2Item8     = new ExerciseItem();
        ExerciseItem exercise2Item9     = new ExerciseItem();
        ExerciseItem exercise2Item10    = new ExerciseItem();

        exercise2Item1.setId("exercise2item1");
        exercise2Item1.setItemNo(1);
        exercise2Item1.setItemText("GA");
        exercise2Item1.setItemAnswer("ᮌ");
        LocalData.saveOrUpdate(exercise2Item1);

        exercise2Item2.setId("exercise2item2");
        exercise2Item2.setItemNo(2);
        exercise2Item2.setItemText("NGA");
        exercise2Item2.setItemAnswer("ᮍ");
        LocalData.saveOrUpdate(exercise2Item2);

        exercise2Item3.setId("exercise2item3");
        exercise2Item3.setItemNo(3);
        exercise2Item3.setItemText("CA");
        exercise2Item3.setItemAnswer("ᮎ");
        LocalData.saveOrUpdate(exercise2Item3);

        exercise2Item4.setId("exercise2item4");
        exercise2Item4.setItemNo(4);
        exercise2Item4.setItemText("DA");
        exercise2Item4.setItemAnswer("ᮓ");
        LocalData.saveOrUpdate(exercise2Item4);

        exercise2Item5.setId("exercise2item5");
        exercise2Item5.setItemNo(5);
        exercise2Item5.setItemText("NA");
        exercise2Item5.setItemAnswer("ᮔ");
        LocalData.saveOrUpdate(exercise2Item5);

        exercise2Item6.setId("exercise2item6");
        exercise2Item6.setItemNo(6);
        exercise2Item6.setItemText("PA");
        exercise2Item6.setItemAnswer("ᮕ");
        LocalData.saveOrUpdate(exercise2Item6);

        exercise2Item7.setId("exercise2item7");
        exercise2Item7.setItemNo(7);
        exercise2Item7.setItemText("GA");
        exercise2Item7.setItemAnswer("ᮌ");
        LocalData.saveOrUpdate(exercise2Item7);

        exercise2Item8.setId("exercise2item8");
        exercise2Item8.setItemNo(8);
        exercise2Item8.setItemText("CA");
        exercise2Item8.setItemAnswer("ᮎ");
        LocalData.saveOrUpdate(exercise2Item8);

        exercise2Item9.setId("exercise2item9");
        exercise2Item9.setItemNo(9);
        exercise2Item9.setItemText("PA");
        exercise2Item9.setItemAnswer("ᮕ");
        LocalData.saveOrUpdate(exercise2Item9);

        exercise2Item10.setId("exercise2item10");
        exercise2Item10.setItemNo(10);
        exercise2Item10.setItemText("DA");
        exercise2Item10.setItemAnswer("ᮓ");
        LocalData.saveOrUpdate(exercise2Item10);

    }

    public static void generateExercise3ItemData(){
        ExerciseItem exercise3Item1     = new ExerciseItem();
        ExerciseItem exercise3Item2     = new ExerciseItem();
        ExerciseItem exercise3Item3     = new ExerciseItem();
        ExerciseItem exercise3Item4     = new ExerciseItem();
        ExerciseItem exercise3Item5     = new ExerciseItem();
        ExerciseItem exercise3Item6     = new ExerciseItem();
        ExerciseItem exercise3Item7     = new ExerciseItem();
        ExerciseItem exercise3Item8     = new ExerciseItem();
        ExerciseItem exercise3Item9     = new ExerciseItem();
        ExerciseItem exercise3Item10    = new ExerciseItem();


        exercise3Item1.setId("exercise3item1");
        exercise3Item1.setItemNo(1);
        exercise3Item1.setItemText("3");
        exercise3Item1.setItemAnswer("᮳");
        LocalData.saveOrUpdate(exercise3Item1);

        exercise3Item2.setId("exercise3item2");
        exercise3Item2.setItemNo(2);
        exercise3Item2.setItemText("WA");
        exercise3Item2.setItemAnswer("ᮝ");
        LocalData.saveOrUpdate(exercise3Item2);

        exercise3Item3.setId("exercise3item3");
        exercise3Item3.setItemNo(3);
        exercise3Item3.setItemText("LA");
        exercise3Item3.setItemAnswer("ᮜ");
        LocalData.saveOrUpdate(exercise3Item3);

        exercise3Item4.setId("exercise3item4");
        exercise3Item4.setItemNo(4);
        exercise3Item4.setItemText("6");
        exercise3Item4.setItemAnswer("᮶");
        LocalData.saveOrUpdate(exercise3Item4);

        exercise3Item5.setId("exercise3item5");
        exercise3Item5.setItemNo(5);
        exercise3Item5.setItemText("5");
        exercise3Item5.setItemAnswer("᮵");
        LocalData.saveOrUpdate(exercise3Item5);

        exercise3Item6.setId("exercise3item6");
        exercise3Item6.setItemNo(6);
        exercise3Item6.setItemText("7");
        exercise3Item6.setItemAnswer("᮷");
        LocalData.saveOrUpdate(exercise3Item6);

        exercise3Item7.setId("exercise3item7");
        exercise3Item7.setItemNo(7);
        exercise3Item7.setItemText("8");
        exercise3Item7.setItemAnswer("᮸");
        LocalData.saveOrUpdate(exercise3Item7);

        exercise3Item8.setId("exercise3item8");
        exercise3Item8.setItemNo(8);
        exercise3Item8.setItemText("LA");
        exercise3Item8.setItemAnswer("ᮜ");
        LocalData.saveOrUpdate(exercise3Item8);

        exercise3Item9.setId("exercise3item9");
        exercise3Item9.setItemNo(9);
        exercise3Item9.setItemText("6");
        exercise3Item9.setItemAnswer("᮶");
        LocalData.saveOrUpdate(exercise3Item9);

        exercise3Item10.setId("exercise3item9");
        exercise3Item10.setItemNo(10);
        exercise3Item10.setItemText("5");
        exercise3Item10.setItemAnswer("᮵");
        LocalData.saveOrUpdate(exercise3Item10);

    }

    public static void generateExercise4ItemData(){
        ExerciseItem exercise4Item1     = new ExerciseItem();
        ExerciseItem exercise4Item2     = new ExerciseItem();
        ExerciseItem exercise4Item3     = new ExerciseItem();
        ExerciseItem exercise4Item4     = new ExerciseItem();
        ExerciseItem exercise4Item5     = new ExerciseItem();
        ExerciseItem exercise4Item6     = new ExerciseItem();
        ExerciseItem exercise4Item7     = new ExerciseItem();
        ExerciseItem exercise4Item8     = new ExerciseItem();
        ExerciseItem exercise4Item9     = new ExerciseItem();
        ExerciseItem exercise4Item10    = new ExerciseItem();

        exercise4Item1.setId("exercise4item1");
        exercise4Item1.setItemNo(1);
        exercise4Item1.setItemText("MA");
        exercise4Item1.setItemAnswer("ᮙ");
        LocalData.saveOrUpdate(exercise4Item1);

        exercise4Item2.setId("exercise4item2");
        exercise4Item2.setItemNo(2);
        exercise4Item2.setItemText("BA");
        exercise4Item2.setItemAnswer("ᮘ");
        LocalData.saveOrUpdate(exercise4Item2);

        exercise4Item3.setId("exercise4item3");
        exercise4Item3.setItemNo(3);
        exercise4Item3.setItemText("JA");
        exercise4Item3.setItemAnswer("ᮏ");
        LocalData.saveOrUpdate(exercise4Item3);

        exercise4Item4.setId("exercise4item4");
        exercise4Item4.setItemNo(4);
        exercise4Item4.setItemText("é");
        exercise4Item4.setItemAnswer("ᮆ");
        LocalData.saveOrUpdate(exercise4Item4);

        exercise4Item5.setId("exercise4item5");
        exercise4Item5.setItemNo(5);
        exercise4Item5.setItemText("EU");
        exercise4Item5.setItemAnswer("ᮉ");
        LocalData.saveOrUpdate(exercise4Item5);

        exercise4Item6.setId("exercise4item6");
        exercise4Item6.setItemNo(6);
        exercise4Item6.setItemText("O");
        exercise4Item6.setItemAnswer("ᮇ");
        LocalData.saveOrUpdate(exercise4Item6);

        exercise4Item7.setId("exercise4item7");
        exercise4Item7.setItemNo(7);
        exercise4Item7.setItemText("EU");
        exercise4Item7.setItemAnswer("ᮉ");
        LocalData.saveOrUpdate(exercise4Item7);

        exercise4Item8.setId("exercise4item8");
        exercise4Item8.setItemNo(8);
        exercise4Item8.setItemText("JA");
        exercise4Item8.setItemAnswer("ᮏ");
        LocalData.saveOrUpdate(exercise4Item8);

        exercise4Item9.setId("exercise4item9");
        exercise4Item9.setItemNo(9);
        exercise4Item9.setItemText("BA");
        exercise4Item9.setItemAnswer("ᮘ");
        LocalData.saveOrUpdate(exercise4Item9);

        exercise4Item10.setId("exercise4item9");
        exercise4Item10.setItemNo(10);
        exercise4Item10.setItemText("O");
        exercise4Item10.setItemAnswer("ᮇ");
        LocalData.saveOrUpdate(exercise4Item10);

    }

    public static void generateExercise5ItemData(){
        ExerciseItem exercise5Item1     = new ExerciseItem();
        ExerciseItem exercise5Item2     = new ExerciseItem();
        ExerciseItem exercise5Item3     = new ExerciseItem();
        ExerciseItem exercise5Item4     = new ExerciseItem();
        ExerciseItem exercise5Item5     = new ExerciseItem();
        ExerciseItem exercise5Item6     = new ExerciseItem();
        ExerciseItem exercise5Item7     = new ExerciseItem();
        ExerciseItem exercise5Item8     = new ExerciseItem();
        ExerciseItem exercise5Item9     = new ExerciseItem();
        ExerciseItem exercise5Item10    = new ExerciseItem();

        exercise5Item1.setId("exercise5item1");
        exercise5Item1.setItemNo(1);
        exercise5Item1.setItemText("SA");
        exercise5Item1.setItemAnswer("ᮞ");
        LocalData.saveOrUpdate(exercise5Item1);

        exercise5Item2.setId("exercise5item2");
        exercise5Item2.setItemNo(2);
        exercise5Item2.setItemText("KA");
        exercise5Item2.setItemAnswer("ᮊ");
        LocalData.saveOrUpdate(exercise5Item2);

        exercise5Item3.setId("exercise5item3");
        exercise5Item3.setItemNo(3);
        exercise5Item3.setItemText("4");
        exercise5Item3.setItemAnswer("᮴");
        LocalData.saveOrUpdate(exercise5Item3);

        exercise5Item4.setId("exercise5item4");
        exercise5Item4.setItemNo(4);
        exercise5Item4.setItemText("YA");
        exercise5Item4.setItemAnswer("ᮚ");
        LocalData.saveOrUpdate(exercise5Item4);

        exercise5Item5.setId("exercise5item5");
        exercise5Item5.setItemNo(5);
        exercise5Item5.setItemText("9");
        exercise5Item5.setItemAnswer("᮹");
        LocalData.saveOrUpdate(exercise5Item5);

        exercise5Item6.setId("exercise5item6");
        exercise5Item6.setItemNo(6);
        exercise5Item6.setItemText("NYA");
        exercise5Item6.setItemAnswer("ᮑ");
        LocalData.saveOrUpdate(exercise5Item6);

        exercise5Item7.setId("exercise5item7");
        exercise5Item7.setItemNo(7);
        exercise5Item7.setItemText("FA");
        exercise5Item7.setItemAnswer("ᮖ");
        LocalData.saveOrUpdate(exercise5Item7);

        exercise5Item8.setId("exercise5item8");
        exercise5Item8.setItemNo(8);
        exercise5Item8.setItemText("TA");
        exercise5Item8.setItemAnswer("ᮒ");
        LocalData.saveOrUpdate(exercise5Item8);

        exercise5Item9.setId("exercise5item9");
        exercise5Item9.setItemNo(9);
        exercise5Item9.setItemText("ZA");
        exercise5Item9.setItemAnswer("ᮐ");
        LocalData.saveOrUpdate(exercise5Item9);

        exercise5Item10.setId("exercise5item9");
        exercise5Item10.setItemNo(10);
        exercise5Item10.setItemText("SA");
        exercise5Item10.setItemAnswer("ᮞ");
        LocalData.saveOrUpdate(exercise5Item10);
    }

    public static void generateExercise6ItemData(){
        ExerciseItem exercise6Item1     = new ExerciseItem();
        ExerciseItem exercise6Item2     = new ExerciseItem();
        ExerciseItem exercise6Item3     = new ExerciseItem();
        ExerciseItem exercise6Item4     = new ExerciseItem();
        ExerciseItem exercise6Item5     = new ExerciseItem();
        ExerciseItem exercise6Item6     = new ExerciseItem();
        ExerciseItem exercise6Item7     = new ExerciseItem();
        ExerciseItem exercise6Item8     = new ExerciseItem();
        ExerciseItem exercise6Item9     = new ExerciseItem();
        ExerciseItem exercise6Item10    = new ExerciseItem();

        exercise6Item1.setId("exercise6item1");
        exercise6Item1.setItemNo(1);
        exercise6Item1.setItemText("RA");
        exercise6Item1.setItemAnswer("ᮛ");
        LocalData.saveOrUpdate(exercise6Item1);

        exercise6Item2.setId("exercise6item2");
        exercise6Item2.setItemNo(2);
        exercise6Item2.setItemText("2");
        exercise6Item2.setItemAnswer("᮲");
        LocalData.saveOrUpdate(exercise6Item2);

        exercise6Item3.setId("exercise6item3");
        exercise6Item3.setItemNo(3);
        exercise6Item3.setItemText("XA");
        exercise6Item3.setItemAnswer("ᮟ");
        LocalData.saveOrUpdate(exercise6Item3);

        exercise6Item4.setId("exercise6item4");
        exercise6Item4.setItemNo(4);
        exercise6Item4.setItemText("SYA");
        exercise6Item4.setItemAnswer("ᮯ");
        LocalData.saveOrUpdate(exercise6Item4);

        exercise6Item5.setId("exercise6item5");
        exercise6Item5.setItemNo(5);
        exercise6Item5.setItemText("1");
        exercise6Item5.setItemAnswer("᮱");
        LocalData.saveOrUpdate(exercise6Item5);

        exercise6Item6.setId("exercise6item6");
        exercise6Item6.setItemNo(6);
        exercise6Item6.setItemText("QA");
        exercise6Item6.setItemAnswer("ᮋ");
        LocalData.saveOrUpdate(exercise6Item6);

        exercise6Item7.setId("exercise6item7");
        exercise6Item7.setItemNo(7);
        exercise6Item7.setItemText("SYA");
        exercise6Item7.setItemAnswer("ᮯ");
        LocalData.saveOrUpdate(exercise6Item7);

        exercise6Item8.setId("exercise6item8");
        exercise6Item8.setItemNo(8);
        exercise6Item8.setItemText("RA");
        exercise6Item8.setItemAnswer("ᮛ");
        LocalData.saveOrUpdate(exercise6Item8);

        exercise6Item9.setId("exercise6item9");
        exercise6Item9.setItemNo(9);
        exercise6Item9.setItemText("2");
        exercise6Item9.setItemAnswer("᮲");
        LocalData.saveOrUpdate(exercise6Item9);

        exercise6Item10.setId("exercise6item9");
        exercise6Item10.setItemNo(10);
        exercise6Item10.setItemText("XA");
        exercise6Item10.setItemAnswer("ᮟ");
        LocalData.saveOrUpdate(exercise6Item10);

    }

}
