package com.example.macas.codemenu;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    Button btCardapio, btPedido, btPagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btCardapio = (Button) findViewById(R.id.btCardapio);

        btCardapio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaCardapio();
            }

            void chamaCardapio() {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, CardapioActivity.class);
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
                intent.setClass(MainActivity.this, PedidoActivity.class);
                startActivity(intent);
                finish();
            }
        });


        btPagamento = (Button) findViewById(R.id.btPagamento);

        btPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaPagamento();
            }

            void chamaPagamento() {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, PagamentoActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

}
