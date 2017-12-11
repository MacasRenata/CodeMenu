package com.example.macas.codemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pagamentoPage extends AppCompatActivity {

    Button btSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_pagamento);

        btSair = (Button) findViewById(R.id.btSair);

        btSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaCardapio();
            }

            void chamaCardapio() {
                Intent intent = new Intent();
                intent.setClass(pagamentoPage.this, MainActivityMenu.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
