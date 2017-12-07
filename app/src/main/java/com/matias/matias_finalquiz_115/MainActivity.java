package com.matias.matias_finalquiz_115;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etAuthor, etQuote;
    SharedPreferences preference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAuthor  = (EditText) findViewById(R.id.et_author);
        etQuote   = (EditText) findViewById(R.id.et_quote);

        preference = getSharedPreferences("test", Context.MODE_WORLD_READABLE);
    }

    public void saveQuote(View view) {
        SharedPreferences.Editor editor = preference.edit();
        editor.putString("author", etAuthor.getText().toString());
        editor.putString("quote", etQuote.getText().toString());
        editor.commit();
        Toast.makeText(this, "Quote saved!",Toast.LENGTH_SHORT).show();
    }

    public void subActivity (View view){
        Intent intent = new Intent(this, SubActivity.class);
        startActivity(intent);
    }
}
