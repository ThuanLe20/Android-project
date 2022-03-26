package com.example.finaldamb.Setting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.finaldamb.R;

public class Gmail extends AppCompatActivity {
    private EditText edittextto, edittextsubject, edittextmsg;
    private Button btnsend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmail);

        edittextto = findViewById(R.id.edittextto);
        edittextsubject = findViewById(R.id.edittextsubject);
        edittextmsg = findViewById(R.id.edittextmsg);
        
        btnsend = findViewById(R.id.btnsend);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendmail();
            }
        });
    }
    public void sendmail(){
        String manymail = edittextto.getText().toString();
        String[] mail = manymail.split(",");

        String subject = edittextsubject.getText().toString();
        String msg = edittextmsg.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,mail);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,msg);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose an email client"));
    }
}