package com.example.photogallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class HomeActivity extends AppCompatActivity {
    private String urlImg = "https://goo.gl/gEgYUd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ivAndroid = findViewById(R.id.ivAndroid1);
        Button btChangeImg = findViewById(R.id.btChangeImg);
        Button btCall = findViewById(R.id.btCall);
        LinearLayout llActions = findViewById(R.id.llActions);
        LinearLayout llPassword = findViewById(R.id.llPassword);
        Button btPassword = findViewById(R.id.btPassword);
        EditText etPassword = findViewById(R.id.etPassword);

        btPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = etPassword.getText().toString();
                if (password.equals("pass123")){
                    llActions.setVisibility(View.VISIBLE);
                    llPassword.setVisibility(View.GONE);
                }else{
                    Toast.makeText(HomeActivity.this,"Password Incorrecta",Toast.LENGTH_SHORT).show();
                }
            }
        });


        btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "tel:627657008";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(phone));
                startActivity(intent);

            }
        });

        ivAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                if(!urlImg.contains("http")){
                    urlImg = "http://" + urlImg;
                }
                intent.setData(Uri.parse(urlImg));
                startActivity(intent);

            }
        });

        btChangeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  ivAndroid.setImageDrawable(getResources().getDrawable(R.drawable.foto2));
                Glide.with(HomeActivity.this).load(urlImg).into(ivAndroid);
            }
        });
    }
}