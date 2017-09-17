package com.example.manuygabi.codemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CardapioBeb extends AppCompatActivity {

    Button btMenuPrincipal, btCardapioRef, btPedidoCozinha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.CardapioBeb);

        btMenuPrincipal = (Button) findViewById(R.id.btMenuPrincipal);

        btMenuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaMenuPrincipal();
            }

            void chamaMenuPrincipal() {
                Intent intent = new Intent();
                intent.setClass(CardapioBeb.this, MenuPrincipal.class);
                startActivity(intent);
                finish();
            }
        });

        btCardapioRef = (Button) findViewById(R.id.btCardapioRef);

        btCardapioRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaCardapioRef();
            }

            void chamaCardapioRef() {
                Intent intent = new Intent();
                intent.setClass(CardapioBeb.this, CardapioRef.class);
                startActivity(intent);
                finish();
            }
        });

        btPedidoCozinha = (Button) findViewById(R.id.btPedidoCozinha);

        btPedidoCozinha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaPedidoCozinha();
            }

            void chamaPedidoCozinha() {
                Intent intent = new Intent();
                intent.setClass(CardapioBeb.this, Pedidos.class); // Aqui precisa alterar para a chamada @Cozinha do sistema
                startActivity(intent);
                finish();
            }
        });
    }
}
