package com.example.macas.codemenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class cardapioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_cardapio);


            cardapio cardapios = (cardapio) super.getIntent().getSerializableExtra("cardapio");
            ListView nome = (ListView) findViewById(R.id.listItem);
            ListView tipo = (ListView) findViewById(R.id.listItem);
            ListView preco = (ListView) findViewById(R.id.listItem);
            ListView urlImagem = (ListView) findViewById(R.id.listItem);

            nome.setOnClickListener(cardapio.getNome());
            tipo.setAdapter(cardapios.getTipo());
            preco.setAdapter(cardapios.getPreco());
            urlImagem.setAdapter(cardapios.getUrlImagem());

        }

}


