package com.example.macas.codemenu;


import android.os.AsyncTask;
import android.os.Bundle;

import com.example.macas.codemenu.download_dados;
import com.example.macas.codemenu.webservice;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;


public class menu_principal extends AppCompatActivity {

    Button btCardapio, btPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);

        AsyncTask<Void, Void, Void> url = new download_dados().execute();  //download dos dados do webservice

        btCardapio = (Button) findViewById(R.id.btCardapio);

        btCardapio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                chamaCardapio();
            }

            void chamaCardapio() {
                Intent intent = new Intent();
                intent.setClass(menu_principal.this, cardapio_beb.class);
                startActivity(intent);
                finish();
            }
        });

        btPedido = (Button) findViewById(R.id.btPedido);

        btPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaPedido();
            }

            void chamaPedido() {
                Intent intent = new Intent();
                intent.setClass(menu_principal.this, pedidos.class);
                startActivity(intent);
                finish();
            }
        });


    }

}
