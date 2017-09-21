package com.example.manuygabi.codemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cardapio_beb extends AppCompatActivity {

    Button btMenuPrincipal, btCardapioRef, btPedidoCozinha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardapio_beb);

        btMenuPrincipal = (Button) findViewById(R.id.btMenuPrincipal);

        btMenuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaMenuPrincipal();
            }

            void chamaMenuPrincipal() {
                Intent intent = new Intent();
                intent.setClass(cardapio_beb.this, menu_principal.class);
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
                intent.setClass(cardapio_beb.this, cardapio_ref.class);
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
                intent.setClass(cardapio_beb.this, pedidos.class); // Aqui precisa alterar para a chamada @Cozinha do sistema
                startActivity(intent);
                finish();
            }
        });
    }
}
