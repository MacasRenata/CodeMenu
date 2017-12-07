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


