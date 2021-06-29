package com.app.appreidopitaco;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton btnHallFama = (ImageButton) findViewById(R.id.btnHalDaFama);

        btnHallFama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaListaHall();
            }
        });
    }

    private void vaiParaListaHall(){
        Intent intent = new Intent(this, Activity_Custom.class);
        startActivity(intent);
    }
}