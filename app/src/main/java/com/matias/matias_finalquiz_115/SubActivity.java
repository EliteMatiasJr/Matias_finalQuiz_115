package com.matias.matias_finalquiz_115;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

    TextView tvQuoteAuthor, tvQuoteContent;
    SharedPreferences preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        tvQuoteAuthor  = (TextView) findViewById(R.id.tv_quote_author);
        tvQuoteContent = (TextView) findViewById(R.id.tv_quote_content);

        preference = getSharedPreferences("test", Context.MODE_WORLD_READABLE);

        //Load Quote
        String author = preference.getString("author","");
        String quote  = preference.getString("quote","");

        String authorText = author + " said";
        tvQuoteAuthor.setText(authorText);
        String quoteText = '"' + quote + '"';
        tvQuoteContent.setText(quoteText);

        Toast.makeText(this, "Quote loaded!", Toast.LENGTH_SHORT).show();
    }

    public void prevActivity (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
