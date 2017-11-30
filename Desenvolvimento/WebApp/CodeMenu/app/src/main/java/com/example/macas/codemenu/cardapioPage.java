package com.example.macas.codemenu;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ListView;

public class cardapioPage extends AppCompatActivity {

    ListView lv;
    String id;

    Button btConfirma, btSair;

    //talvez fazer metodo da lista aqui

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_cardapio);


        btConfirma = (Button) findViewById(R.id.btConfirma);

        btConfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaCardapio();
            }

            void chamaCardapio() {
                Intent intent = new Intent();
                intent.setClass(cardapioPage.this, pedidoPage.class);
                startActivity(intent);
                finish();

            }
        });

        btSair = (Button) findViewById(R.id.btSair);

        btSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaCardapio();
            }

            void chamaCardapio() {
                Intent intent = new Intent();
                intent.setClass(cardapioPage.this, MainActivityMenu.class);
                startActivity(intent);
                finish();

            }
        });

    }

}
