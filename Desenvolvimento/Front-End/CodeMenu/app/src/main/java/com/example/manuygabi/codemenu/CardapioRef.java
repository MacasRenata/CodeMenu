package com.example.manuygabi.codemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CardapioRef extends AppCompatActivity {

    Button btCardapioBeb, btMenuPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.CardapioRef);


        btCardapioBeb = (Button) findViewById(R.id.btCardapioBeb);

        btCardapioBeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaBebida();
            }

            void chamaBebida() {
                Intent intent = new Intent();
                intent.setClass(CardapioRef.this, CardapioBeb.class);
                startActivity(intent);
                finish();
            }
        });

        btMenuPrincipal = (Button) findViewById(R.id.btMenuPrincipal);

        btMenuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaMenuPrincipal();
            }

            void chamaMenuPrincipal() {
                Intent intent = new Intent();
                intent.setClass(CardapioRef.this, MenuPrincipal.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
