package com.example.macas.codemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class pedidoPage extends AppCompatActivity {

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
                intent.setClass(pedidoPage.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

        btSair = (Button) findViewById(R.id.btSair);

        btSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaMenuPrincipal();
            }

            void chamaMenuPrincipal() {
                Intent intent = new Intent();
                intent.setClass(pedidoPage.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

        cardapio cardapios = (cardapio) super.getIntent().getSerializableExtra("cardapio");
        ListView nome = (ListView) findViewById(R.id.listaItem);
        ListView tipo = (ListView) findViewById(R.id.listaItem);
        ListView preco = (ListView) findViewById(R.id.listaItem);
        ListView urlImagem = (ListView) findViewById(R.id.listaItem);

        nome.setFilterText(cardapio.class.getName());
        tipo.setFilterText(cardapio.class.getName());
        preco.setFilterText(cardapio.class.getName());
        urlImagem.setFilterText(cardapio.class.getName());

    }

}

