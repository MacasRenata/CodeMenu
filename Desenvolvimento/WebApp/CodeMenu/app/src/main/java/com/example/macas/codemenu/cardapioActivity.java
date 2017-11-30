package com.example.macas.codemenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class cardapioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_menu);


            cardapio cardapio = (cardapio) super.getIntent().getSerializableExtra("cardapio");
            TextView nome = (TextView) findViewById(R.id.listItem);
            TextView tipo = (TextView) findViewById(R.id.listItem);
            TextView preco = (TextView) findViewById(R.id.listItem);
            TextView urlImagem = (TextView) findViewById(R.id.listItem);

            nome.setText(cardapio.getNome());
            tipo.setText(cardapio.getTipo());
            preco.setText(cardapio.getPreco());
            urlImagem.setText(cardapio.getUrlImagem());

        }

}


