package com.example.finaldamb.Word;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.finaldamb.R;

public class DetailsWord extends AppCompatActivity {

    TextView txtName, txtKN, txtKD, txtPD, txtNV, txtSignal, txtDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_word);
        txtName = findViewById(R.id.txtName);
        txtKN =findViewById(R.id.txtKN);
        txtKD =findViewById(R.id.txtKD);
        txtPD =findViewById(R.id.txtPD);
        txtNV =findViewById(R.id.txtNV);
        txtSignal =findViewById(R.id.txtSignal);
        txtDescription =findViewById(R.id.txtDescription);

        // lay du lieu
        txtName.setText(getIntent().getStringExtra("Name"));
        txtKN.setText(getIntent().getStringExtra("KN"));
        txtKD.setText(getIntent().getStringExtra("KD"));
        txtPD.setText(getIntent().getStringExtra("PD"));
        txtNV.setText(getIntent().getStringExtra("NV"));
        txtSignal.setText(getIntent().getStringExtra("Signal"));
        txtDescription.setText(getIntent().getStringExtra("Description"));
    }
}