package com.example.macas.codemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cardapio_beb extends AppCompatActivity {

    private String idBeb;
    private String content;

    public String getId() {
        return this.idBeb;
    }

    public String getContent() {
        return this.content;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Button btMenuPrincipal, btCardapioRef, btPedidoCozinha;

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

        btCardapioRef = (Button) findViewById(R.id.btCardapioBeb);

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

        btPedidoCozinha = (Button) findViewById(R.id.btConfirmaPedido);

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
