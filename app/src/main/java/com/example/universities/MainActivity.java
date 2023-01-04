package com.example.universities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String mCountry = "Finland";
    private RequestQueue mQueue;
    String mUrl = "http://universities.hipolabs.com/search?country="+mCountry;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQueue = Volley.newRequestQueue(this);

        if( getIntent().getStringExtra("COUNTRY") != null) {
            mCountry = getIntent().getStringExtra("COUNTRY");
            mUrl = "http://universities.hipolabs.com/search?country="+mCountry;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Talletetaan olion tila
        savedInstanceState.putString("COUNTRY",mCountry);

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mCountry = savedInstanceState.getString("COUNTRY", mCountry);
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

    public void fetchUniversityData(View view) {
        i++; // Kasvatetaan lukua jolla haetaan arraysta seuraavan korkeakoulun nimi
        TextView countryTextView = findViewById(R.id.countryTextView);
        countryTextView.setText(mCountry);
        // Haetaan tiedot URLista
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, mUrl, null, response -> {

                    parseJsonAndUpdateUi(response);
                    }, error -> {
                    countryTextView.setError("Error!");
                } );
        // lisätään request volley queueen
        mQueue.add(jsonArrayRequest);
    }

    private void parseJsonAndUpdateUi(JSONArray uniArray){
        // Jsonista data käyttöliittymäkomponentteihin
        TextView uniTextView = findViewById(R.id.uniTextView);

        try {
            JSONObject uniObject = uniArray.getJSONObject(i);
            String university = uniObject.getString("name");
            uniTextView.setText(university);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void goToSettings(View view){
        // Siirrytään SettingsActivityyn
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

}