package com.example.kelebekyakala;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

ImageView image[];
    int puan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView kalan = findViewById(R.id.kalan);
        TextView puan = findViewById(R.id.puan);
        ImageView[] image = new ImageView[]{findViewById(R.id.img),
                findViewById(R.id.img1), findViewById(R.id.img2)};

        hideImage();
        new CountDownTimer(10000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                hideImage();
                Random random = new Random();
                int uretilen = random.nextInt(3);
                image[uretilen].setVisibility(View.VISIBLE);
                kalan.setText("Kalan: " + millisUntilFinished / 1000);

            }

            @Override
            public void onFinish() {
                hideImage();

            }
        }.start();


    }

    public void hideImage() {


        for (ImageView gezici : image) {
            gezici.setVisibility(View.INVISIBLE);
        }
    }
    public void catchAgent(View view){

        puan++;
    }
}