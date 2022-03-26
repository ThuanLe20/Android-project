package com.example.finaldamb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;




public class ETC extends AppCompatActivity {
    LinearLayout etc1, etc2, etc3, etc4, etc5, etc6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etc);

        etc1 = findViewById(R.id.etc1);
        etc2 = findViewById(R.id.etc2);
        etc3 = findViewById(R.id.etc3);
        etc4 = findViewById(R.id.etc4);
        etc5 = findViewById(R.id.etc5);
        etc6 = findViewById(R.id.etc6);

        etc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://tienganhtflat.com/");
            }
        });
        etc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.memrise.com/vi/");
            }
        });
        etc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://vi.duolingo.com/");
            }
        });
        etc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.oxfordlearnersdictionaries.com/");
            }
        });
        etc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.lingodeer.com/");
            }
        });
        etc6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.busuu.com/en/p/start-learning?utm_medium=cpc&utm_source=google&utm_campaign=ROW_EN_Web_Brand_E&utm_group=ROW_EN_Web_Brand_E&utm_term=busuu&gclid=CjwKCAiArOqOBhBmEiwAsgeLmeySdrq_nZqBaI6othkRmQP1hjkyUR-J51SdFDIEiJDw8kGMSOCf6xoCvMgQAvD_BwE&gclsrc=aw.ds");
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}