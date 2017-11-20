package com.example.macas.codemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PagePedido extends AppCompatActivity {

    Button btSolicitar, btSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_pedido);


        btSolicitar = (Button) findViewById(R.id.btSolicitar);

        btSolicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaCardapio();
            }

            void chamaCardapio() {
                Intent intent = new Intent();
                intent.setClass(PagePedido.this, PageCardapio.class);
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
                intent.setClass(PagePedido.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
