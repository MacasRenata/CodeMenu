package com.example.macas.codemenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class cardapioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_cardapio);


            cardapio cardapio = (cardapio) super.getIntent().getSerializableExtra("cardapio");
            ListView nome = (ListView) findViewById(R.id.listItem);
            ListView tipo = (ListView) findViewById(R.id.listItem);
            ListView preco = (ListView) findViewById(R.id.listItem);
            ListView urlImagem = (ListView) findViewById(R.id.listItem);

            nome.setAdapter(cardapio.getNome());
            tipo.setText(cardapio.getTipo());
            preco.setText(cardapio.getPreco());
            urlImagem.setText(cardapio.getUrlImagem());

        }

}


