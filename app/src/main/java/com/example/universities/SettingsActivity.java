package com.example.universities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
    public void setIceland (View view) {
        // Siirrytään MainActivityyn ja välitetään valtion nimi
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("COUNTRY", "Iceland");
        startActivity(intent);
    }

    public void setNorway (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("COUNTRY", "Norway");
        startActivity(intent);
    }

    public void setSweden (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("COUNTRY", "Sweden");
        startActivity(intent);
    }

    public void setFinland (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("COUNTRY", "Finland");
        startActivity(intent);
    }

    public void setDenmark (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("COUNTRY", "Denmark");
        startActivity(intent);
    }

    public void backToMain (View view) {
        // Palataan takaisin MainActivityyn
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart(){
        super.onStart();
        // aktiviteetti tulossa näkyviin
    }

    @Override
    protected void onResume(){
        super.onResume();
        // aktiviteetti on tullut näkyviin
    }

    @Override
    protected void onStop(){
        super.onStop();
        // aktiviteetti on pois näkyvistä
    }

    @Override
    protected void onPause(){
        super.onPause();
        // aktiviteetti on menossa pois näkyvistä
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        // aktiviteetti on tuhottu, siivottu muistista
    }
}